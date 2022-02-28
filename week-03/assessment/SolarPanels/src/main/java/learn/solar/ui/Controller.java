package learn.solar.ui;

import learn.solar.data.DataException;
import learn.solar.domain.PanelService;
import learn.solar.models.Panel;

import java.util.List;

public class Controller {

    private final PanelService service;
    private final View view;

    public Controller(PanelService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run(){
//        view.printHeader("Welcome to Unexplained Encounters.");
//
//        try{
//            runMenuLoop();
//        }catch(DataException ex){
//            view.printHeader("Error: " + ex.getMessage());
//        }
//
//        view.printHeader("Goodbye");


    }

    private void viewBySection(){
        List<Panel> panels = service.findBySection();

    }

    /*
    Create `Controller`
    *- add fields for service and view with corresponding constructor
    *- add a `run` method
    - implement `viewBySection` in controller, complete required view methods: `readSection`, `printPanels`
    - implement `addPanel` in controller, complete required view methods: `makePanel`, `readMaterial`, `printResult`
    - implement `updatePanel` in controller, complete required view methods: `choosePanel`, `update`
    - implement `deletePanel` in controller, complete required view methods (`deletePanel` can re-use `choosePanel`)
     */
}
