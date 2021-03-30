package lk.RoyalInstitution.StudentRegistrationSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Course {
    @Id
    private String cid;
    private String courseName;
    private String courseType;
    private String duration;

    @OneToMany(mappedBy = "course", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Registration> registrations;

    public Course() {
    }

    public Course(String cid, String courseName, String courseType, String duration) {
        this.cid = cid;
        this.courseName = courseName;
        this.courseType = courseType;
        this.duration = duration;
        this.registrations = registrations;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }



    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", duration='" + duration + '\'' +

                '}';
    }
}
