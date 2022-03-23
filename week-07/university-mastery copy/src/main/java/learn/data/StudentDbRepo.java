package learn.data;

import com.mysql.cj.jdbc.MysqlDataSource;
import learn.models.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.List;
import java.util.logging.Logger;

public class StudentDbRepo implements StudentRepo{


    JdbcTemplate template;


    public StudentDbRepo(JdbcTemplate template){
        this.template = template;
    }


    @Override
    public List<Student> getStudentsByLastName(String lastName) throws DataException {
        return template.
    }

    @Override
    public Student getStudentById(String id) throws DataException {
        return null;
    }
}
