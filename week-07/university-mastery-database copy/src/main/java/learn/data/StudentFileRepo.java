package learn.data;

import learn.models.Instructor;
import learn.models.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentFileRepo implements StudentRepo {

    String path;

    public StudentFileRepo( String path ){
        this.path = path;
    }

    @Override
    public List<Student> getStudentsByLastName(String lastName) throws DataException {
        List<Student> allStudents = getAllStudents();

        List<Student> matching = allStudents
                .stream()
                .filter( i -> i.getLastName().toLowerCase().startsWith(
                        lastName.toLowerCase()
                ) ).collect(Collectors.toList());

        return matching;
    }

    @Override
    public Student getStudentById(int id) throws DataException {
        return getAllStudents().stream()
                .filter( s -> s.getId() == id)
                .findAny()
                .orElse(null);
    }

    private List<Student> getAllStudents() throws DataException {
        List<Student> allStudents = new ArrayList<>();

        try( BufferedReader reader = new BufferedReader( new FileReader(path)) ){

            reader.readLine();

            for( String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] cells = line.split( "," );
                if( cells.length == 3){
                    Student toAdd = new Student();
                    toAdd.setId( Integer.parseInt(cells[0]) );
                    toAdd.setLastName( cells[1] );
                    toAdd.setFirstName( cells[2] );

                    allStudents.add( toAdd );
                }
            }

        } catch ( IOException e ) {
            throw new DataException( "Could not get all students.", e );
        }

        return allStudents;
    }

}
