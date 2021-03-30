package lk.RoyalInstitution.StudentRegistrationSystem.dto;

public class CourseDTO {
    private String cid;
    private String courseName;
    private String courseType;
    private String duration;

    public CourseDTO() {
    }

    public CourseDTO(String cid, String courseName, String courseType, String duration) {
        this.cid = cid;
        this.courseName = courseName;
        this.courseType = courseType;
        this.duration = duration;
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
        return "CourseDTO{" +
                "cid='" + cid + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
