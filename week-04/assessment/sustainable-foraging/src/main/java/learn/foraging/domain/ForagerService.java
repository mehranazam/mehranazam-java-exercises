package learn.foraging.domain;

import learn.foraging.data.DataException;
import learn.foraging.data.ForagerRepository;
import learn.foraging.models.Forager;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ForagerService {

    private final ForagerRepository repository;

    public ForagerService(ForagerRepository repository) {
        this.repository = repository;
    }

    public List<Forager> findByState(String stateAbbr) {
        return repository.findByState(stateAbbr);
    }

    public List<Forager> findByLastName(String prefix) {
        return repository.findAll().stream()
                .filter(i -> i.getLastName().startsWith(prefix))
                .collect(Collectors.toList());
    }

    public Result add(Forager forager) throws DataException {
        Result result = validate(forager);
        if (!result.isSuccess()) {
            return result;
        }

        List<Forager> foragers = repository.findAll();
        for (Forager e : foragers) {
            if (Objects.equals(forager.getId(), e.getId())
                    && Objects.equals(forager.getFirstName(), e.getFirstName())
                    && Objects.equals(forager.getLastName(), e.getLastName())
                    && Objects.equals(forager.getState(), e.getState())
            ) {
                result.addErrorMessage("duplicate encounter is not allowed");
                return result;
            }

        }
        forager = repository.add(forager);
        result.setPayload(forager);
        return result;
    }
}