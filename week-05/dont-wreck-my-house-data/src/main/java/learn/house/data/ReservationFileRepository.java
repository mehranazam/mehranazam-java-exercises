package learn.house.data;

import learn.house.domain.ReservationResult;
import learn.house.models.Guest;
import learn.house.models.Reservation;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public ReservationResult<Reservation> add(Reservation reservation) throws DataException {
        List<Reservation> all = findAll();
        reservation.getHost().setId(java.util.UUID.randomUUID().toString());
        all.add(reservation);
        writeAll(all, reservation.getId());
        ReservationResult<Reservation> result = new ReservationResult<>();
        result.setPayload(reservation);
        return result;
    }

    private List<Reservation> findAll() throws DataException {

        ArrayList<Reservation> result = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(directory))){
            reader.readLine();
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] fields = line.split(",", -1);
                if(fields.length == 5){
                    result.add(deserialize(fields));
                }
            }
        }catch(IOException ex){
            throw new DataException("Could not find all reservations.", ex);
        }
        return result;
    }

    @Override
    public Reservation findById(String id) throws DataException {
        List<Reservation> allReservations = findAll();

        return allReservations.stream()
                .filter(r -> r.getId().equals(id))
                .findAny()
                .orElse(null);

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
    public ReservationResult<Reservation> edit(Reservation editReservation) throws DataException {
        ReservationResult<Reservation> success = new ReservationResult<>();

        List <Reservation> allReservations = findAll();

        for(int i = 0; i < allReservations.size(); i++){
            Reservation toCheck = allReservations.get(i);
            if(toCheck.getId().equals(editReservation.getId())){
                allReservations.set(i, editReservation);
                writeAll(allReservations, editReservation.getId());
                success.setPayload(toCheck);
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
                reservation.getId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getGuest().getId(),
                reservation.getTotal()
                );
    }

    private Reservation deserialize(String[] fields){
        //"id,start_date,end_date,guest_id,total";
        Reservation result = new Reservation();
        result.setId(fields[0]);
        result.setStartDate(LocalDate.parse(fields[1]));
        result.setEndDate(LocalDate.parse(fields[2]));

        Guest guest = new Guest();
        guest.setId(fields[3]);
        result.setGuest(guest);
        result.setTotal(BigDecimal.valueOf(Long.parseLong(fields[4])));

        return result;
    }


    @Override
    public ReservationResult<Reservation> deleteById(String id) throws DataException {

        ReservationResult<Reservation> success = new ReservationResult<>();
        List<Reservation> all = findAll();
        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getId().equals(id)){
                all.remove(i);
                writeAll(all, id);
               success.setPayload(all.get(i));
            }
        }
       return success;
    }

    private String getFilePath(String id){
        return Paths.get(directory, id + ".csv").toString();
    }

    private String clean(String value) {
        return value.replace(DELIMITER, DELIMITER_REPLACEMENT);
    }

    private String restore(String value) {
        return value.replace(DELIMITER_REPLACEMENT, DELIMITER);
    }
}
