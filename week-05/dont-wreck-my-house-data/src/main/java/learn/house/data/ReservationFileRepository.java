package learn.house.data;

import learn.house.models.Host;
import learn.house.models.Reservation;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationFileRepository implements ReservationRepository{

    private static final String DELIMITER = ",";
    private static final String DELIMITER_REPLACEMENT = "@@@";
    private static final String HEADER = "id,start_date,end_date,guest_id,total";
    private final String directory;

    public ReservationFileRepository(String directory){
        this.directory = directory;
    }

//    public ReservationFileRepository(String filePath){
//        this.filePath = filePath;
//    }

    @Override
    public Reservation add(Reservation reservation) throws DataException {
        List<Reservation> all = findById(reservation.getId());
        reservation.getHost().setId(java.util.UUID.randomUUID().toString());
        all.add(reservation);
        writeAll(all, reservation.getId());
        return reservation;
    }

    private List<Reservation> findAll() throws DataException {

        ArrayList<Reservation> result = new ArrayList<Reservation>();

        try(BufferedReader reader = new BufferedReader(new FileReader(directory))){
            reader.readLine();
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                Reservation reservation = deserialize(line);
                if(reservation != null){
                    result.add(reservation);
                }
            }
        }catch(IOException ex){
            throw new DataException("Could not find all reservations.", ex);
        }
        return result;
    }

    @Override
    public List<Reservation> findById(String id) throws DataException {
        List<Reservation> allReservations = findAll();

        List<Reservation> toReturn = allReservations.stream()
                .filter(r -> r.getId().toLowerCase()
                        .startsWith(id.toLowerCase()))
                .collect(Collectors.toList());

//        ArrayList<Reservation> result = new ArrayList<>();
//        try(BufferedReader reader = new BufferedReader(new FileReader(getFilePath(id)))){
//            reader.readLine();
//
//            for(java.lang.String line = reader.readLine(); line != null; line = reader.readLine()){
//                java.lang.String[] fields = line.split(",", -1);
//                if(fields.length == 5){
//                    result.add(deserialize(fields, id));
//                }
//            }
//        }catch(IOException ex){
//
//        }
//        return result;


    }

    @Override
    public boolean edit(Reservation editReservation) throws DataException {
        boolean success = false;

        List <Reservation> allReservations = findById(editReservation.getId());

        for(int i = 0; i < allReservations.size(); i++){
            Reservation toCheck = allReservations.get(i);
            if(toCheck.getId() == editReservation.getId()){
                allReservations.set(i, editReservation);
                writeAll(allReservations, editReservation.getId());
                success = true;
                break;
            }
        }
        return success;
    }


    private void writeAll(List<Reservation> reservations, String id) throws DataException{
        try(PrintWriter writer = new PrintWriter(getFilePath(id))){
            writer.println(HEADER);
            for(Reservation r : reservations){
                writer.println(serialize(r));
            }
        }
        catch(FileNotFoundException ex){
            throw new DataException(ex.getMessage(), ex);
        }
    }

    private String serialize(Reservation reservation){
        return java.lang.String.format("%s,%s,%s,%s,%s",
                reservation.getHost().getId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getGuest().getId(),
                reservation.getHost().getTotal()
                );
    }

    private Reservation deserialize(String[] fields, String id){
        Reservation result = new Reservation();
        result.setId(fields[0]);
        result.setStartDate();
    }


    @Override
    public boolean deleteById(String id) throws DataException {
        List<Reservation> all = findById(id);
        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getId().equals(id)){
                all.remove(i);
                writeAll(all, id);
                return true;
            }
        }
        return false;
    }

    private java.lang.String getFilePath(String id){
        return Paths.get(directory, id + ".csv").toString();
    }

    private java.lang.String clean(String value) {
        return value.replace(DELIMITER, DELIMITER_REPLACEMENT);
    }

    private java.lang.String restore(String value) {
        return value.replace(DELIMITER_REPLACEMENT, DELIMITER);
    }
}
