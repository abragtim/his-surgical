package his.department.surgical.db.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "surgery_support")
public class SurgerySupporterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "operating_room_number", referencedColumnName = "operating_room_number"),
            @JoinColumn(name = "start_date", referencedColumnName = "start_date"),
            @JoinColumn(name = "start_time", referencedColumnName = "start_time"),
    })
    @Nonnull
    private SurgeryEntity surgery;

    @ManyToOne
    @JoinColumn(name = "worker", referencedColumnName = "phone")
    private WorkerEntity supporter;

    @Column(name = "role", nullable = false)
    private String role;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SurgerySupporterEntity{" +
                "surgery=" + surgery +
                ", supporter=" + supporter +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SurgerySupporterEntity that)) return false;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
