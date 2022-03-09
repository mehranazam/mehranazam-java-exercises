package learn.house.data;

import learn.house.models.Reservation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationFileRepository implements ReservationRepository{

    private static final String DELIMITER = ",";
    private static final String DELIMITER_REPLACEMENT = "@@@";
    private static final String HEADER = "id,start_date,end_date,guest_id,total";
    private final String filePath;

    public ReservationFileRepository(String filePath){
        this.filePath = filePath;
    }

    @Override
    public Reservation add(Reservation reservation) throws DataException {
        List<Reservation> all = findAll();
        reservation.setId(getNextId(all));
        all.add(reservation);
        writeAll(all);
        return reservation;
    }

    @Override
    public List<Reservation> findAll() throws DataException {

        ArrayList<Reservation> result = new ArrayList<Reservation>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.readLine();
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                Reservation reservation = deserialize(line);
                if(reservation != null){
                    result.add(reservation);
                }
            }
        }catch(FileNotFoundException ex){

        }catch(IOException ex){
            throw new DataException(ex.getMessage(), ex);
        }
        return result;
    }

    @Override
    public List<Reservation> findById(String id) throws DataException {
        return null;
    }

    @Override
    public boolean edit(Reservation editReservation) throws DataException {
        boolean success = false;

        List <Reservation> allReservations = findAll();

        for(int i = 0; i < allReservations.size(); i++){
            Reservation toCheck = allReservations.get(i);
            if(toCheck.getId() == editReservation.getId()){
                allReservations.set(i, editReservation);
                writeAll(allReservations);
                success = true;
                break;
            }
        }
        return success;
    }

    private int getNextId(List<Reservation> allReservations){
        int nextId = 0;
        for(Reservation r : allReservations){
            nextId = Math.max(nextId, r.getId());
        }
        return nextId + 1;
    }


    private void writeAll(List<Reservation> reservations) throws DataException{
        try(PrintWriter writer = new PrintWriter(filePath)){
            writer.println(HEADER);
            for(Reservation r : reservations){
                writer.println(serialize(r));
            }
        }
        catch(IOException ex){
            throw new DataException(ex.getMessage(), ex);
        }
    }

    private String serialize(Reservation reservation){
        return String.format("%s,%s,%s,%s,%s",
                reservation.getId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                );
    }

    private Reservation deserialize(String line){

    }


    @Override
    public boolean deleteById(int id) throws DataException {
        List<Reservation> all = findAll();
        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getId() == id){
                all.remove(i);
                writeAll(all);
                return true;
            }
        }
        return false;
    }

    private String clean(String value) {
        return value.replace(DELIMITER, DELIMITER_REPLACEMENT);
    }

    private String restore(String value) {
        return value.replace(DELIMITER_REPLACEMENT, DELIMITER);
    }
}
