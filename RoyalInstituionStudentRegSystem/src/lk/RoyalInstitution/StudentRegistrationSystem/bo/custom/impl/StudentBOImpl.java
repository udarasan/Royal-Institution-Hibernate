package lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.impl;

import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.StudentBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dao.DAOFactory;
import lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.StudentDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.StudentDTO;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean addStudent(StudentDTO student) throws Exception {
        return studentDAO.add(new Student(student.getId(), student.getName(),
                        student.getAddress(), student.getContact(), student.getDob(), student.getGender()));
    }

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        List<Student> studentsList = studentDAO.getAll();

        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Student student :studentsList ) {
            studentDTOList.add(new StudentDTO(student.getId(),student.getName(),
                    student.getAddress(), student.getContact(),
                    student.getDob(),student.getGender()));
        }
        return studentDTOList;
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public boolean updateStudent(StudentDTO student) throws Exception {
        return studentDAO.update(new Student(student.getId(), student.getName(),
                student.getAddress(), student.getContact(), student.getDob(), student.getGender()));
    }
}
