package his.department.surgical.db.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@IdClass(SurgeryNoteEntity.class)
@Table(name = "surgery_note")
public class SurgeryNoteEntity implements Serializable {

    @Id
    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "operating_room_number", referencedColumnName = "operating_room_number"),
            @JoinColumn(name = "start_date", referencedColumnName = "start_date"),
            @JoinColumn(name = "start_time", referencedColumnName = "start_time"),
    })
    @Nonnull
    private SurgeryEntity surgery;

    @Id
    @Column(name = "note", nullable = false)
    private String note;

    public SurgeryEntity getSurgery() {
        return surgery;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "SurgeryNoteEntity{" +
                "surgery=" + surgery +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SurgeryNoteEntity that)) return false;

        if (!getSurgery().equals(that.getSurgery())) return false;
        return getNote().equals(that.getNote());
    }

    @Override
    public int hashCode() {
        int result = getSurgery().hashCode();
        result = 31 * result + getNote().hashCode();
        return result;
    }
}
