package learn.data;

import learn.models.Course;
import learn.models.Instructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InstructorFileRepo implements InstructorRepo {

    String path;

    public InstructorFileRepo( String path ){
        this.path = path;
    }

    @Override
    public List<Instructor> getInstructorsByLastName(String lastName) throws DataException {

        List<Instructor> allInstructors = getAllInstructors();

        List<Instructor> matching = allInstructors
                .stream()
                .filter( i -> i.getLastName().toLowerCase().startsWith(
                        lastName.toLowerCase()
                ) ).collect(Collectors.toList());

        return matching;
    }

    @Override
    public Instructor getInstructorById(int id) throws DataException {
        return getAllInstructors().stream()
                .filter( i -> i.getId() == id)
                .findAny()
                .orElse(null);
    }

    private List<Instructor> getAllInstructors() throws DataException {
        List<Instructor> allInstructors = new ArrayList<>();

        try( BufferedReader reader = new BufferedReader( new FileReader(path)) ){

            reader.readLine();

            for( String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] cells = line.split( "," );
                if( cells.length == 3){
                    Instructor toAdd = new Instructor();
                    toAdd.setId( Integer.parseInt(cells[0]) );
                    toAdd.setLastName( cells[1] );
                    toAdd.setFirstName( cells[2] );

                    allInstructors.add( toAdd );
                }
            }

        } catch ( IOException e ) {
            throw new DataException( "Could not get all instructors.", e );
        }

        return allInstructors;
    }
}

