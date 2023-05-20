package his.department.surgical.db.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "examination")
public class ExaminationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient")
    @Nonnull
    private PatientEntity patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor")
    @Nonnull
    private DoctorEntity doctor;

    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "date", referencedColumnName = "date"),
            @JoinColumn(name = "time", referencedColumnName = "time")
    })
    @Nonnull
    private DatetimeEntity datetime;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ExaminationEntity{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", datetime=" + datetime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExaminationEntity that)) return false;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
