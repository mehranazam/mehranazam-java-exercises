package learn.data;

import learn.models.Course;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseFileRepo implements CourseRepo {

    String path;

    public CourseFileRepo( String path ){
        this.path = path;
    }

    @Override
    public List<Course> getCoursesByName(String courseName) throws DataException {

        List<Course> allCourses = getAllCourses();

        List<Course> toReturn =
                allCourses
                        .stream()
                        .filter( c -> c.getName().toLowerCase()
                                .startsWith(courseName.toLowerCase()) )
                        .collect(Collectors.toList());

        return toReturn;
    }

    @Override
    public Course getCourseById(String id) throws DataException {
        return getAllCourses().stream()
                .filter( c -> c.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    private List<Course> getAllCourses() throws DataException {
        List<Course> allCourses = new ArrayList<>();

        try( BufferedReader reader = new BufferedReader( new FileReader(path)) ){

            reader.readLine();

            for( String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] cells = line.split( "," );
                if( cells.length == 2 ){
                    Course toAdd = new Course();
                    toAdd.setId( cells[0] );
                    toAdd.setName( cells[1] );

                    allCourses.add( toAdd );
                }
            }

        } catch ( IOException e ) {
            throw new DataException( "Could not get all courses.", e );
        }

        return allCourses;
    }
}
