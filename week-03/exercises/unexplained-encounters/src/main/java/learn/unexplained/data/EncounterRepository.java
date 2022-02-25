package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.util.List;

public interface EncounterRepository {

    //C
    Encounter add(Encounter encounter) throws DataAccessException;
    //R
    List<Encounter> findAll() throws DataAccessException;
    List<Encounter> findByType(EncounterType encType) throws DataAccessException;
    //U
    //D


    boolean update(Encounter updatedEncounter) throws DataAccessException;

    boolean deleteById(int encounterId) throws DataAccessException;



}
