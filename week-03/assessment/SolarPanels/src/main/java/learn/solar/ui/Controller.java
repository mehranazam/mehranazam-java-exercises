package learn.solar.ui;

import learn.solar.data.DataException;
import learn.solar.domain.PanelResult;
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
        try{
            runMenu();
        }catch(DataException exception){
            view.printHeader("Fatal Error: " + exception);
        }
    }


    private void runMenu() throws DataException {

            int option = 0;
            do {
                option = view.chooseOptionFromMenu();
                switch (option) {
                    case 0:
                        System.out.println("Goodbye");
                        break;
                    case 1:
                        viewBySection();
                        break;
                    case 2:
                        addPanel();
                        break;
                    case 3:
                        deletePanel();
                        break;
                }
            } while (option != 0);
        }

    private void viewBySection() throws DataException {
        view.printHeader("Find Panels by Section");
        String section = view.readSection();
        List<Panel> panels = service.findBySection(section);
        view.printPanels(section, panels);
    }

    private void addPanel() throws DataException {
        view.printHeader("Add Panel");
        Panel panel = view.makePanel();
        PanelResult result = service.add(panel);
        view.printResult(result);
    }

    private void updatePanel() throws DataException {
        view.printHeader("Update Panel");
        String section = view.readSection();
        List<Panel> panels = service.findBySection(section);
        Panel panel = view.update(panels);
        if(panel == null){
            return;
        }
        PanelResult result = service.update(panel);
        view.printResult(result);
    }

    private void deletePanel() throws DataException {
        view.printHeader("Delete Panel");

        String section = view.readSection();
        List<Panel> panels = service.findBySection(section);

        Panel panel = view.findPanel(panels);
        if(panel == null){
            return;
        }
        PanelResult result = service.deleteById(panel.getId());
        view.printResult(result);
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
