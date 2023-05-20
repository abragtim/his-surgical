package his.department.surgical.db.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hospital_bed")
@IdClass(HospitalBedEntity.class)
public class HospitalBedEntity implements Serializable {

    @Id
    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;

    @Id
    @Column(name = "bed_number", nullable = false)
    private Integer bedNumber;

    public HospitalBedEntity() {}

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    @Override
    public String toString() {
        return "HospitalBedEntity{" +
                "roomNumber=" + roomNumber +
                ", bedNumber=" + bedNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HospitalBedEntity that)) return false;

        if (!getRoomNumber().equals(that.getRoomNumber())) return false;
        return getBedNumber().equals(that.getBedNumber());
    }

    @Override
    public int hashCode() {
        int result = getRoomNumber().hashCode();
        result = 31 * result + getBedNumber().hashCode();
        return result;
    }
}
