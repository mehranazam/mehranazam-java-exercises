package memories;

//import memories.ui.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

//@ComponentScan // Tells Spring to scan all classes in this package or its children
//@PropertySource("classpath:data.properties")
@SpringBootApplication
public class App {

    public static void main(String[] args) {

        //XML config
        //  ApplicationContext context = new ClassPathXmlApplicationContext("dependency-configuration.xml");
        // Controller controller  = context.getBean(Controller.class);

        //controller.run();
        //annotation example
//        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
//        Controller controller = context.getBean(Controller.class);
//
//        controller.run();
        SpringApplication.run(App.class, args);

    }
}
