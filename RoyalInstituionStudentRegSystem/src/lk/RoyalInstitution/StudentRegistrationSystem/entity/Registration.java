package lk.RoyalInstitution.StudentRegistrationSystem.entity;

import javax.persistence.*;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rid;
    private String regDate;
    private Double regFee;

    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    public Registration() {
    }

    public Registration(int rid, String regDate, Double regFee, Student student, Course course) {
        this.setRid(rid);
        this.setRegDate(regDate);
        this.setRegFee(regFee);
        this.setStudent(student);
        this.setCourse(course);
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public Double getRegFee() {
        return regFee;
    }

    public void setRegFee(Double regFee) {
        this.regFee = regFee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "rid=" + rid +
                ", regDate='" + regDate + '\'' +
                ", regFee=" + regFee +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
