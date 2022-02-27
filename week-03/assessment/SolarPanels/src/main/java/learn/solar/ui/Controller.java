package learn.solar.ui;

import learn.solar.data.DataException;
import learn.solar.domain.PanelService;

public class Controller {

    private final PanelService service;
    private final View view;

    public Controller(PanelService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run(){
        view.printHeader("Welcome to Unexplained Encounters.");

        try{
            runMenuLoop();
        }catch(DataException ex){
            view.printHeader("Error: " + ex.getMessage());
        }

        view.printHeader("Goodbye");
    }

    /*
    Create `Controller`
    *- add fields for service and view with corresponding constructor
    *- add a `run` method
     */
}
