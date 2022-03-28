package learn.domain;

import learn.data.*;
import learn.models.Course;
import learn.models.Grade;
import learn.models.Instructor;
import learn.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GradeService {

    CourseRepo cRepo;
    GradeRepo gRepo;
    InstructorRepo iRepo;
    StudentRepo sRepo;

    public Result<List<Grade>> getGradesByCourseName( String courseName ){
        Result<List<Grade>> result = new Result<>();

        //1. get the course by name

        try {
            List<Course> matchingCourses = cRepo.getCoursesByName( courseName );
            if( matchingCourses.size() > 1 ){
                result.addErrorMessage( "Course name matched more than one course.");
            } else if( matchingCourses.size() == 0 ){
                result.addErrorMessage( "Course name did not match any courses.");
            } else {
                //this grabs dehydrated grades
                //but those have null instructor names
                //null course names
                //null students names

                //unfortunately this doesn't work because of the lambda
//                List<Grade> matchingGrades =
//                        gRepo.getGradesByCourse(matchingCourses.get(0).getId())
//                                .stream()
//                                .map( g -> hydrate( g ))
//                                .collect(Collectors.toList());

                List<Grade> matchingGrades = gRepo.getGradesByCourse(matchingCourses.get(0).getId());
                List<Grade> fullyHydratedGrades = new ArrayList<>();
                for( Grade toHydrate : matchingGrades ){
                    fullyHydratedGrades.add( hydrate(toHydrate));
                }

                result.setPayload( fullyHydratedGrades );
            }
        } catch (DataException e) {
            result.addErrorMessage( e.getMessage() );
        }

        return result;
    }

    private Grade hydrate(Grade dehydrated) throws DataException {
        Instructor matchingInstructor = iRepo.getInstructorById( dehydrated.getCourseInstructor().getId() );
        Student matchingStudent = sRepo.getStudentById( dehydrated.getGradeStudent().getId() );
        Course matchingCourse = cRepo.getCourseById( dehydrated.getGradeCourse().getId() );

        //todo: do null checks/validation/etc

        dehydrated.setCourseInstructor( matchingInstructor );
        dehydrated.setGradeStudent(matchingStudent);
        dehydrated.setGradeCourse(matchingCourse);

        return dehydrated;
    }

}
