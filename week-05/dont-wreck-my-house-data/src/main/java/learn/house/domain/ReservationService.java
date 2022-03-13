package learn.house.domain;

import learn.house.data.DataException;
import learn.house.data.GuestRepository;
import learn.house.data.HostRepository;
import learn.house.data.ReservationRepository;
import learn.house.models.Guest;
import learn.house.models.Host;
import learn.house.models.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final HostRepository hostRepository;

    public ReservationService(ReservationRepository reservationRepository, GuestRepository guestRepository, HostRepository hostRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.hostRepository = hostRepository;
    }

    public List<Reservation> findById(String id) throws DataException {
//        ReservationResult<List<Host>> result = new ReservationResult<>();
//
//        try{
//            List<Reservation> matchingReservations = reservationRepository.findById(id);
//            if(matchingReservations.size() > 1){
//                result.addErrorMessage("Reservation matched with another.");
//            }else if(matchingReservations.size() == 0){
//                result.addErrorMessage("ID doesn't match any reservation.");
//            }else{
//                List<Host> matchingHosts = hostRepository.findByEmail(matchingReservations.get(0).getId());
//                List<Host> fullyHydratedHosts = new ArrayList<>();
//                for(Host toHydrate : matchingHosts){
//                    fullyHydratedHosts.add(hydrate(toHydrate));
//                }
//                result.setPayload(fullyHydratedHosts);
//            }
//        }catch(DataException ex){
//            result.addErrorMessage(ex.getMessage());
//        }
//        return result;

        Map<String, Guest> guestMap = guestRepository.findAll().stream()
                .collect(Collectors.toMap(i -> i.getId(), i -> i));
        Map<String, Host> hostMap = hostRepository.findAll().stream()
                .collect(Collectors.toMap(i -> i.getId(), i -> i));

        List<Reservation> result = reservationRepository.findById(id);
        for(Reservation reservation : result){
            reservation.setGuest(guestMap.get(reservation.getGuest().getId()));
            reservation.setHost(hostMap.get(reservation.getHost().getId()));
        }
        return result;
    }

//    private Host hydrate(Host toHydrate) {
//        Reservation matchingReservation = reservationRepository.findById(toHydrate.g);
//        Host matchingHost = hostRepository.findById();
//
//    }

    public ReservationResult<Reservation> add(Reservation reservation) throws DataException {
        ReservationResult<Reservation> result = validate(reservation);
        if(!result.isSuccess()){
            return result;
        }

        result.setPayload(reservationRepository.add(reservation));

        return result;
    }

    public int generate(LocalDate startDate, LocalDate endDate, int count) throws DataException {
        if(startDate == null || endDate == null || startDate.isAfter(endDate) || count <= 0){
            return 0;
        }

        count = Math.min(count, 500);

        ArrayList<LocalDate> dates = new ArrayList<>();

        while(!startDate.isAfter(endDate)){
            dates.add(startDate);
            startDate = startDate.plusDays(1);
        }

        List<Host> hosts = hostRepository.findAll();
        List<Guest> guests = guestRepository.findAll();
        Random random = new Random();

        for(int i = 0; i < count; i++){
            Reservation reservation = new Reservation();
            reservation.setGuest(guests.get(random.nextInt(guests.size())));
            reservation.setHost(hosts.get(random.nextInt(hosts.size())));
            reservation.setStartDate(dates.get(random.nextInt(dates.size())));
            reservation.setEndDate(dates.get(random.nextInt(dates.size())));
            reservationRepository.add(reservation);
        }

        return count;
    }


    private ReservationResult<Reservation> validate(Reservation reservation) throws DataException {
        ReservationResult<Reservation> result = validateNulls(reservation);
        if(!result.isSuccess()){
            return result;
        }

        validateFields(reservation, result);
        if(!result.isSuccess()){
            return result;
        }

        validateChildrenExist(reservation, result);
        if(!result.isSuccess()){
            return result;
        }

        validateDuplicates(reservation, result);

        return result;
    }


        private void validateDuplicates(Reservation reservation, ReservationResult<Reservation> result) throws DataException {
            List<Reservation> reservations = findById(reservation.getId());
            for (Reservation r : reservations) {
                if (reservation.getGuest().equals(r.getGuest()) && reservation.getHost().equals(r.getHost()) && !r.getId().equals(reservation.getId())) {
                    result.addErrorMessage("Duplicate reservation found.");
                    break;
                }
            }
        }
        


    private ReservationResult<Reservation> validateNulls(Reservation reservation){
        ReservationResult<Reservation> result = new ReservationResult<>();

        if(reservation == null){
            result.addErrorMessage("Nothing to save.");
            return result;
        }

        if(reservation.getGuest() == null){
            result.addErrorMessage("Guest is required.");
        }
        if(reservation.getHost() == null){
            result.addErrorMessage("Host is required.");
        }
        if(reservation.getStartDate() == null){
            result.addErrorMessage("Start date is required.");
        }
        if(reservation.getEndDate() == null){
            result.addErrorMessage("End date is required.");
        }
        return result;
    }

    private void validateFields(Reservation reservation, ReservationResult<Reservation> result){
        if(reservation.getStartDate().isAfter(reservation.getEndDate())){
            result.addErrorMessage("Start date cannot be after end date.");
        }
        if(reservation.getStartDate().isBefore(LocalDate.now())){
            result.addErrorMessage("Start date cannot be in the past.");
        }

    }

    private void validateChildrenExist(Reservation reservation, ReservationResult<Reservation> result){
        if(reservation.getGuest().getId() == null
                || guestRepository.findById(reservation.getGuest().getId()) == null){
            result.addErrorMessage("Guest does not exist.");
        }

        if(hostRepository.findById(reservation.getHost().getId()) == null){
            result.addErrorMessage("Host does not exist.");
        }
    }

}
