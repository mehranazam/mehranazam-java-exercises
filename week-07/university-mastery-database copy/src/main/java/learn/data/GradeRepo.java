package learn.data;

import learn.models.Grade;

import java.util.List;

public interface GradeRepo {

    Grade addGrade(Grade toAdd)throws DataException;

    List<Grade> getGradesByCourse(int courseId) throws DataException;

    Grade getGrade( int courseId, int gradeId ) throws DataException;

    void deleteGrade(int courseId, int gradeId ) throws DataException;

    void updateGrade( Grade updatedGrade ) throws DataException;

}
