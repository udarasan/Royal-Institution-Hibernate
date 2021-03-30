package lk.RoyalInstitution.StudentRegistrationSystem.dto;


public class RegistrationDTO {

    private int rid;
    private String regDate;
    private Double regFee;
    private String id;
    private String cid;

    public RegistrationDTO() {
    }

    public RegistrationDTO(int rid, String regDate, Double regFee, String id, String cid) {
        this.rid = rid;
        this.regDate = regDate;
        this.regFee = regFee;
        this.id = id;
        this.cid = cid;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "rid=" + rid +
                ", regDate='" + regDate + '\'' +
                ", regFee=" + regFee +
                ", id='" + id + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}
