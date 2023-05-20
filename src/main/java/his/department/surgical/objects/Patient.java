package his.department.surgical.objects;

import his.department.surgical.enums.PatientStatus;

import java.sql.Date;

public class Patient {

    private Integer medicalId;

    private HospitalBed hospitalBed;

    private Integer age;

    private String insuranceNumber;

    private String name;

    private Date dateOfBirth;

    private String idCardNumber;

    private String phone;

    private Character sex;

    private String email;

    private PatientStatus condition;

    public Patient(Integer medicalId,
                   HospitalBed hospitalBed,
                   Integer age,
                   String insuranceNumber,
                   String name,
                   Date dateOfBirth,
                   String idCardNumber,
                   String phone,
                   Character sex,
                   String email,
                   PatientStatus condition) {
        this.medicalId = medicalId;
        this.hospitalBed = hospitalBed;
        this.age = age;
        this.insuranceNumber = insuranceNumber;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCardNumber = idCardNumber;
        this.phone = phone;
        this.sex = sex;
        this.email = email;
        this.condition = condition;
    }

    public Integer getMedicalId() {
        return medicalId;
    }

    public HospitalBed getHospitalBed() {
        return hospitalBed;
    }

    public Integer getAge() {
        return age;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public String getPhone() {
        return phone;
    }

    public Character getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public PatientStatus getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "medicalId=" + medicalId +
                ", hospitalBed=" + hospitalBed +
                ", age=" + age +
                ", insuranceNumber='" + insuranceNumber + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", idCardNumber='" + idCardNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;

        return getMedicalId().equals(patient.getMedicalId());
    }

    @Override
    public int hashCode() {
        return getMedicalId().hashCode();
    }
}
