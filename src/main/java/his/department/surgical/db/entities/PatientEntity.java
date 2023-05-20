package his.department.surgical.db.entities;

import his.department.surgical.enums.PatientStatus;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "patient",
        uniqueConstraints = @UniqueConstraint(name = "UC_Patient_Room_Bed",
                columnNames = {"room_number", "bed_number"}))
public class PatientEntity {

    @Id
    @Column(name = "medical_id", nullable = false)
    private Integer medicalId;

    @OneToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "room_number", referencedColumnName = "room_number"),
            @JoinColumn(name = "bed_number", referencedColumnName = "bed_number")
    })
    private HospitalBedEntity hospitalBed;

    @Column(name = "age")
    private Integer age;

    @Column(name = "insurance_number")
    private String insuranceNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "id_card_number")
    private String idCardNumber;

    @Column(name = "phone")
    private String phone;

    @Column(name = "sex", nullable = false)
    @Nonnull
    private Character sex;

    @Column(name = "email")
    private String email;

    @Column(name = "condition", nullable = false)
    @Nonnull
    @Enumerated(EnumType.STRING)
    private PatientStatus condition;

    public PatientEntity() {}

    public Integer getMedicalId() {
        return medicalId;
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
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
                ", condition=" + condition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientEntity that)) return false;

        return getMedicalId().equals(that.getMedicalId());
    }

    @Override
    public int hashCode() {
        return getMedicalId().hashCode();
    }
}
