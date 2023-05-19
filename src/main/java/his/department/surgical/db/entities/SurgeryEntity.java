package his.department.surgical.db.entities;

import his.department.surgical.db.entities.composite_keys.SurgeryCompositeKey;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@IdClass(SurgeryCompositeKey.class)
@Table(name = "surgery")
public class SurgeryEntity {

    @Id
    @Column(name = "operating_room_number")
    private Integer operatingRoomNumber;

    @Id
    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "start_date", referencedColumnName = "date"),
            @JoinColumn(name = "start_time", referencedColumnName = "time")
    })
    @Nonnull
    private DatetimeEntity startDateTime;

    @ManyToOne
    @JoinColumn(name = "operated")
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "operating")
    private DoctorEntity leadSurgeon;

    public Integer getOperatingRoomNumber() {
        return operatingRoomNumber;
    }

    public DatetimeEntity getStartDateTime() {
        return startDateTime;
    }

    @Override
    public String toString() {
        return "SurgeryEntity{" +
                "operatingRoomNumber=" + operatingRoomNumber +
                ", startDateTime=" + startDateTime +
                ", patient=" + patient +
                ", leadSurgeon=" + leadSurgeon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SurgeryEntity that)) return false;

        if (!getOperatingRoomNumber().equals(that.getOperatingRoomNumber())) return false;
        return getStartDateTime().equals(that.getStartDateTime());
    }

    @Override
    public int hashCode() {
        int result = getOperatingRoomNumber().hashCode();
        result = 31 * result + getStartDateTime().hashCode();
        return result;
    }
}
