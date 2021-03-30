package lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.impl;

import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.CourseBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dao.DAOFactory;
import lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.CourseDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.CourseDTO;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);

    @Override
    public boolean addCourse(CourseDTO course) throws Exception {
        return courseDAO.add(new Course(course.getCid(),course.getCourseName()
                ,course.getCourseType(),course.getDuration()));
    }

    @Override
    public List<CourseDTO> getAllCourse() throws Exception {
        List<Course> courseList = courseDAO.getAll();

        List<CourseDTO> courseDTOS = new ArrayList<>();

        for (Course course :courseList ) {
            courseDTOS.add(new CourseDTO(course.getCid(),course.getCourseName(),
                    course.getCourseType(),course.getDuration()));
        }
        return  courseDTOS;
    }

    @Override
    public boolean deleteCourse(String id) throws Exception {
        return courseDAO.delete(id);
    }

    @Override
    public boolean updateCourse(CourseDTO course) throws Exception {
        return courseDAO.update(new Course(course.getCid(),course.getCourseName()
                ,course.getCourseType(),course.getDuration()));
    }


}
