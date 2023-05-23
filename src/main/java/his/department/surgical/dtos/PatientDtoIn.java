package his.department.surgical.dtos;

import his.department.surgical.enums.PatientStatus;
import his.department.surgical.exceptions.InvalidDateException;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PatientDtoIn {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Integer medicalId;

    private Integer roomNumber;

    private Integer bedNumber;

    private Integer age;

    private String insuranceNumber;

    private String name;

    private Date dateOfBirth;

    private String idCardNumber;

    private String phone;

    private Character sex;

    private String email;

    private PatientStatus patientStatus;

    public PatientDtoIn(Integer medicalId,
                        Integer roomNumber,
                        Integer bedNumber,
                        Integer age,
                        String insuranceNumber,
                        String name,
                        String dateOfBirth,
                        String idCardNumber,
                        String phone,
                        Character sex,
                        String email,
                        PatientStatus patientStatus)
            throws InvalidDateException {
        this.medicalId = medicalId;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.age = age;
        this.insuranceNumber = insuranceNumber;
        this.name = name;
        setDateOfBirth(dateOfBirth);
        this.idCardNumber = idCardNumber;
        this.phone = phone;
        this.sex = sex;
        this.email = email;
        this.patientStatus = patientStatus;
    }

    public Integer getMedicalId() {
        return medicalId;
    }

    public void setMedicalId(Integer medicalId) {
        this.medicalId = medicalId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws InvalidDateException {
        if (dateOfBirth == null) {
            this.dateOfBirth = null;
            return;
        }
        try {
            java.util.Date utilDateOfBirth = dateFormat.parse(dateOfBirth);
            this.dateOfBirth = new java.sql.Date(utilDateOfBirth.getTime());
        } catch (ParseException ex) {
            throw new InvalidDateException("Wrong date format. " +
                    "The expected format is dd-MM-yyyy.");
        }
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PatientStatus getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(PatientStatus patientStatus) {
        this.patientStatus = patientStatus;
    }
}
