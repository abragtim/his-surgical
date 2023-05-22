package his.department.surgical.db.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "worker")
public class WorkerEntity {

    @Id
    @Column(name = "phone")
    private String phone;

    @Column(name = "email",
            unique = true,
            nullable = false)
    @Nonnull
    private String email;

    @Column(name = "contract_number",
            unique = true,
            nullable = false)
    @Nonnull
    private String contractNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @OneToMany(mappedBy = "supporter", fetch = FetchType.EAGER)
    private Set<SurgerySupporterEntity> surgeriesAsSupporter;

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public Set<SurgerySupporterEntity> getSurgeriesAsSupporter() {
        return surgeriesAsSupporter;
    }

    @Override
    public String toString() {
        return "WorkerEntity{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkerEntity that)) return false;

        return getPhone().equals(that.getPhone());
    }

    @Override
    public int hashCode() {
        return getPhone().hashCode();
    }
}
