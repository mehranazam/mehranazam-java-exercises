package learn.foraging.data;

import learn.foraging.models.Forage;
import learn.foraging.models.Forager;
import learn.foraging.models.Item;
import learn.foraging.models.ItemWeight;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ForageFileRepository implements ForageRepository {

    private static final String HEADER = "id,forager_id,item_id,kg";
    private final String directory;

    public ForageFileRepository(String directory) {
        this.directory = directory;
    }

    @Override
    public List<Forage> findByDate(LocalDate date) {
        ArrayList<Forage> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath(date)))) {

            reader.readLine(); // read header

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {

                String[] fields = line.split(",", -1);
                if (fields.length == 4) {
                    result.add(deserialize(fields, date));
                }
            }
        } catch (IOException ex) {
            // don't throw on read
        }
        return result;
    }

    @Override
    public Forage add(Forage forage) throws DataException {
        List<Forage> all = findByDate(forage.getDate());
        forage.setId(java.util.UUID.randomUUID().toString());
        all.add(forage);
        writeAll(all, forage.getDate());
        return forage;
    }

    @Override
    public boolean update(Forage forage) throws DataException {
        List<Forage> all = findByDate(forage.getDate());
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId().equals(forage.getId())) {
                all.set(i, forage);
                writeAll(all, forage.getDate());
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param date given date by the user
     * @return list of kgs of items
     */
    @Override
    public List<ItemWeight> getItemWeight(LocalDate date) {
        List<ItemWeight> itemWeights = findByDate(date).stream().collect(Collectors.groupingBy(
                        i -> i.getItem().getName(),
                        Collectors.summarizingDouble(Forage::getKilograms)
                )).entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .map(x -> new ItemWeight() {
                    @Override
                    public String getItemName() {
                        return x.getKey();
                    }

                    @Override
                    public double getKgs() {
                        return x.getValue().getSum();
                    }
                }).collect(Collectors.toList());
        return itemWeights;
    }

    private String getFilePath(LocalDate date) {
        return Paths.get(directory, date + ".csv").toString();
    }

    private void writeAll(List<Forage> forages, LocalDate date) throws DataException {
        try (PrintWriter writer = new PrintWriter(getFilePath(date))) {

            writer.println(HEADER);

            for (Forage item : forages) {
                writer.println(serialize(item));
            }
        } catch (FileNotFoundException ex) {
            throw new DataException(ex);
        }
    }

    private String serialize(Forage item) {
        return String.format("%s,%s,%s,%s",
                item.getId(),
                item.getForager().getId(),
                item.getItem().getId(),
                item.getKilograms());
    }

    private Forage deserialize(String[] fields, LocalDate date) {
        Forage result = new Forage();
        result.setId(fields[0]);
        result.setDate(date);
        result.setKilograms(Double.parseDouble(fields[3]));

        Forager forager = new Forager();
        forager.setId(fields[1]);
        result.setForager(forager);

        Item item = new Item();
        item.setId(Integer.parseInt(fields[2]));
        result.setItem(item);
        return result;
    }
}
