package learn.data;

import learn.models.Grade;

import java.util.List;

public interface GradeRepo {

    Grade addGrade(Grade toAdd)throws DataException;

    List<Grade> getGradesByCourse(String courseId) throws DataException;

    Grade getGrade( String courseId, int gradeId ) throws DataException;

    void deleteGrade(String courseId, int gradeId ) throws DataException;

    void updateGrade( Grade updatedGrade ) throws DataException;

}
