package learn.data;

import learn.models.Course;
import learn.models.Grade;
import learn.models.Instructor;
import learn.models.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GradeFileRepo implements GradeRepo {


    String directory;

    public GradeFileRepo( String directory ){
        this.directory = directory;
    }

    @Override
    public Grade addGrade(Grade toAdd) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Grade> getGradesByCourse(String courseId) throws DataException {
        List<Grade> toReturn = new ArrayList<>();
        String filePath = Paths.get(directory, courseId + ".csv").toString();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            reader.readLine();

            for( String line = reader.readLine(); line != null; line = reader.readLine() ){
                Grade parsedGrade = deserialize( line, courseId );

                toReturn.add( parsedGrade );
            }

        } catch (IOException e) {
            throw new DataException("Could not get grades by course id: " + courseId, e);
        }

        return toReturn;
    }

    private Grade deserialize(String line, String courseId) {
        Grade toReturn = new Grade();

        String[] cells = line.split( ",");

        toReturn.setId( Integer.parseInt( cells[0] ) );
        toReturn.setGradDate(LocalDate.parse(cells[3]));
        toReturn.setLetterGrade(cells[4]);

        //we don't have the full data needed to build instructor, course, or student objects
        //we can build a "dehydrated version" and then "fully hydrate" (look up the full version) in the service layer

        Instructor gradeInstructor = new Instructor();
        gradeInstructor.setId(Integer.parseInt(cells[1]));

        Student gradeStudent = new Student();
        gradeStudent.setId(Integer.parseInt(cells[2]));

        toReturn.setGradeStudent( gradeStudent);
        toReturn.setCourseInstructor(gradeInstructor);

        Course gradeCourse = new Course();
        gradeCourse.setId( courseId );

        toReturn.setGradeCourse(gradeCourse);

        return toReturn;
    }

    @Override
    public Grade getGrade(String courseId, int gradeId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteGrade(String courseId, int gradeId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateGrade(Grade updatedGrade) {
        throw new UnsupportedOperationException();
    }
}
