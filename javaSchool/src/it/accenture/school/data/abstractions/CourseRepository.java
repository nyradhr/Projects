package it.accenture.school.data.abstractions;

import it.accenture.school.data.DataException;
import it.accenture.school.model.Course;
import java.util.List;

public interface CourseRepository {

    //cambia nomi metodi!
    void addCourse(Course course)throws DataException;
    List<Course> getCoursesByTitleLike(String title) throws DataException;
    List<Course> getAllCourses() throws DataException;
}
