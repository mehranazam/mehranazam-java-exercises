package learn.foraging.data;

import learn.foraging.models.CategoryValue;
import learn.foraging.models.Forage;
import learn.foraging.models.ItemWeight;

import java.time.LocalDate;
import java.util.List;

public interface ForageRepository {
    List<Forage> findByDate(LocalDate date);

    Forage add(Forage forage) throws DataException;

    boolean update(Forage forage) throws DataException;


    /**
     *
     * @param date given date by the user
     * @return list of kgs of items
     */
    List<ItemWeight> getItemWeight(LocalDate date);

//    /**
//     *
//     * @param date given date by user
//     * @return list of values of category
//     */
//    List<CategoryValue> getCategoryValue(LocalDate date);
}
