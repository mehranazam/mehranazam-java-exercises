package learn.data;

import com.mysql.cj.jdbc.MysqlDataSource;
import learn.models.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StudentDbRepo implements StudentRepo {

    JdbcTemplate template;

    public StudentDbRepo( JdbcTemplate template ) {
        this.template = template;
    }

    @Override
    public List<Student> getStudentsByLastName(String lastName) throws DataException {

        // BE CAREFUL...
        //lastName = "';  DROP database if exists university_mastery; --   ";

        //throw new DataException( "hey this broke", null);

//        return template.query(
//                "select student_id, first_name, last_name from students where last_name like ?;",
//                new StudentMapper(),
//                lastName + "%"
//                );

        List<Student> toReturn = template.query(
                "select student_id, first_name, last_name from students where last_name like ?;",
                (rs, rowNum) -> {
                    Student toBuild = new Student();

                    toBuild.setId( rs.getInt("student_id") );
                    toBuild.setFirstName( rs.getString( "first_name" ) );
                    toBuild.setLastName(rs.getString("last_name"));

                    return toBuild;
                },
                lastName + "%"
        );

        return toReturn;
    }

    @Override
    public Student getStudentById(int id) throws DataException {
        return null;
    }
}
