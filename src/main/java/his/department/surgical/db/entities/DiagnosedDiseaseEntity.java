package his.department.surgical.db.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "diagnosed_disease")
public class DiagnosedDiseaseEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "patient")
    @Nonnull
    private PatientEntity patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor")
    @Nonnull
    private DoctorEntity doctor;

    @Column(name = "icd_code", nullable = false)
    private String ICDCode;

    @Column(name = "name", nullable = false)
    private String name;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DiagnosedDiseaseEntity{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", ICDCode='" + ICDCode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiagnosedDiseaseEntity that)) return false;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
