package learn.unexplained.ui;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.domain.EncounterResult;
import learn.unexplained.domain.EncounterService;
import learn.unexplained.models.Encounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Controller {

    @Autowired
    private final EncounterService service;

    private View view;

    @Autowired
    public Controller(EncounterService service, View view) {
        this.service = service;
        this.view = view;
    }

    @Autowired
    public void setView(View view) {
        this.view = view;
    }

    public void run() {
        view.printHeader("Welcome To Unexplained Encounters.");

        try {
            runMenuLoop();
        } catch (DataAccessException ex) {
            view.printHeader("CRITICAL ERROR:" + ex.getMessage());
        }

        view.printHeader("Goodbye");
    }

    private void runMenuLoop() throws DataAccessException {
        MenuOption option;
        do {
            option = view.displayMenuGetOption();
            switch (option) {
                case DISPLAY_ALL:
                    displayAllEncounters();
                    break;
                case ADD:
                    addEncounter();
                    break;
            }
        } while (option != MenuOption.EXIT);
    }

    private void displayAllEncounters() throws DataAccessException {
        List<Encounter> encounters = service.findAll();
        view.printAllEncounters(encounters);
    }

    private void addEncounter() throws DataAccessException {
        Encounter encounter = view.makeEncounter();
        EncounterResult result = service.add(encounter);
        view.printResult(result);
    }
}
