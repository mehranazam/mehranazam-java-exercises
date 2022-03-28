//package learn.data;
//
//import learn.models.Student;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class StudentMapper implements RowMapper<Student> {
//    @Override
//    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Student toReturn = new Student();
//
//        toReturn.setId( rs.getInt("student_id") );
//        toReturn.setFirstName( rs.getString( "first_name" ) );
//        toReturn.setLastName(rs.getString("last_name"));
//
//        return toReturn;
//
//    }
//}
