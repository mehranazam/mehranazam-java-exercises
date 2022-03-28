package learn.solarfarm.data;

import learn.solarfarm.models.SolarPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PanelDbRepoTest {

    PanelDbRepo toTest;

    public PanelDbRepoTest(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DbTestConfig.class);

        toTest = ctx.getBean(PanelDbRepo.class);
    }


    @BeforeEach
    void setup(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DbTestConfig.class);

        JdbcTemplate template = ctx.getBean( JdbcTemplate.class );

        template.update("call set_known_good_state();");
    }

    @Test
    void shouldFindBySection() {
        List<SolarPanel> results = toTest.findBySection();

    }

    @Test
    void shouldFindById() {
        SolarPanel result = toTest.findById();
    }

    @Test
    void shouldCreate() {
    }

    @Test
    void shouldUpdate() {
    }

    @Test
    void shouldDeleteById() {
    }
}