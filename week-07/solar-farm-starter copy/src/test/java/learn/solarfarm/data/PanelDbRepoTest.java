package learn.solarfarm.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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


    }

    @Test
    void shouldFindById() {
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