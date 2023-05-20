package his.department.surgical.db.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nurse")
public class NurseEntity extends WorkerEntity {

    @Id
    @Column(name = "phone")
    private String phone;

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "NurseEntity{" +
                "phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NurseEntity that)) return false;
        if (!super.equals(o)) return false;

        return getPhone().equals(that.getPhone());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getPhone().hashCode();
        return result;
    }
}
