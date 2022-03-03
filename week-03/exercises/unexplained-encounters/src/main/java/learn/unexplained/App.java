package learn.unexplained;

import learn.unexplained.data.EncounterFileRepository;
import learn.unexplained.ui.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
@PropertySource("classpath:data.properties")
public class App {

    public static void main(String[] args) {
       // EncounterFileRepository repository = new EncounterFileRepository("./data/encounters.csv");

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        Controller controller = context.getBean(Controller.class);
        // Run the app!
        controller.run();
    }
}
