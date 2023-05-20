package his.department.surgical.db.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "medication")
public class MedicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient")
    @Nonnull
    private PatientEntity patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nurse")
    @Nonnull
    private NurseEntity nurse;

    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "date", referencedColumnName = "date"),
            @JoinColumn(name = "time", referencedColumnName = "time")
    })
    @Nonnull
    private DatetimeEntity datetime;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dose", nullable = false)
    private Double dose;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MedicationEntity{" +
                "patient=" + patient +
                ", nurse=" + nurse +
                ", datetime=" + datetime +
                ", name='" + name + '\'' +
                ", dose=" + dose +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicationEntity that)) return false;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
