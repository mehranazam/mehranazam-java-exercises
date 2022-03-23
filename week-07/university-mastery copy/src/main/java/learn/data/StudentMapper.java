package learn.data;

import learn.models.Student;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {



    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student toReturn = new Student();

        toReturn.setId(rs.getInt("student_id"));
    }
}
