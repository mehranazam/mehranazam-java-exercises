package learn.solar;

import learn.solar.data.DataException;
import learn.solar.data.PanelFileRepository;
import learn.solar.data.PanelRepository;
import learn.solar.domain.PanelService;
import learn.solar.ui.Controller;
import learn.solar.ui.View;

public class App {
    public static void main(String[] args) throws DataException {


        PanelFileRepository repo = new PanelFileRepository("./data/solarPanels.csv");



        PanelService service = new PanelService(repo);

        View view = new View();

        Controller controller = new Controller(service, view);

        controller.run();



        /*
        Create `App` and the `main` method.
    *- instantiate all required objects: repository, service, view, and controller
    *- run the controller
         */
    }
}
