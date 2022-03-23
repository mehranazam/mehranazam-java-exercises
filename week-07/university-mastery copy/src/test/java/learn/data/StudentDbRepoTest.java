package learn.data;

import learn.models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDbRepoTest {

    StudentDbRepo toTest;

    public StudentDbRepoTest(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DbTestConfig.class);


        toTest = ctx.getBean(StudentDbRepo.class);
    }

    @BeforeEach
    void setup(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DbTestConfig.class);

        JdbcTemplate template = ctx.getBean(JdbcTemplate.class);

        template.update("call set_known_good_state();");
    }


    @Test
    void shouldGetStudentsByValidLastName() throws DataException {

        List<Student> results = toTest.getStudentsByLastName("Brown");

        assertEquals(1, results.size());
        Student s = results.get(0);

        assertEquals(2, s.getId());
        assertEquals("Bob", s.getFirstName());
        assertEquals("Brown", s.getLastName());


        fail("Unit test not implemented");
    }

    @Test
    void getStudentById() {

        fail("Unit test not implemented");
    }
}