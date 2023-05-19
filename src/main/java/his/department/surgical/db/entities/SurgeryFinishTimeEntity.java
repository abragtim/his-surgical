package his.department.surgical.db.entities;

import his.department.surgical.db.entities.composite_keys.SurgeryFinishTimeCompositeKey;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "surgery_finish_time")
@IdClass(SurgeryFinishTimeCompositeKey.class)
public class SurgeryFinishTimeEntity implements Serializable {

    @Id
    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "surgery_operating_room_number",
                    referencedColumnName = "operating_room_number"),
            @JoinColumn(name = "surgery_start_date",
                    referencedColumnName = "start_date"),
            @JoinColumn(name = "surgery_start_time",
                    referencedColumnName = "start_time")
    })
    @Nonnull
    private SurgeryEntity surgery;

    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "end_date", referencedColumnName = "date"),
            @JoinColumn(name = "end_time", referencedColumnName = "time")
    })
    @Nonnull
    private DatetimeEntity finishDateTime;

    public SurgeryFinishTimeEntity() {}

    public SurgeryEntity getSurgery() {
        return surgery;
    }

    @Override
    public String toString() {
        return "SurgeryFinishTimeEntity{" +
                "surgery=" + surgery +
                ", finishDateTime=" + finishDateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SurgeryFinishTimeEntity that)) return false;

        return getSurgery().equals(that.getSurgery());
    }

    @Override
    public int hashCode() {
        int result = getSurgery().hashCode();
        result = 31 * result + finishDateTime.hashCode();
        return result;
    }
}
