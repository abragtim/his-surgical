package his.department.surgical.db.entities;

import his.department.surgical.db.entities.composite_keys.TransplantationCompositeKey;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "transplantation")
@IdClass(TransplantationCompositeKey.class)
public class TransplantationEntity {

    @Id
    @OneToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "donor_operating_room",
                    referencedColumnName = "operating_room_number"),
            @JoinColumn(name = "donor_surgery_start_date",
                    referencedColumnName = "start_date"),
            @JoinColumn(name = "donor_surgery_start_time",
                    referencedColumnName = "start_time")
    })
    @Nonnull
    private SurgeryEntity donorSurgery;

    @Id
    @OneToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "recipient_operating_room",
                    referencedColumnName = "operating_room_number"),
            @JoinColumn(name = "recipient_surgery_start_date",
                    referencedColumnName = "start_date"),
            @JoinColumn(name = "recipient_surgery_start_time",
                    referencedColumnName = "start_time")
    })
    @Nonnull
    private SurgeryEntity recipientSurgery;

    @Column(name = "organ", nullable = false)
    private String organ;

    public SurgeryEntity getDonorSurgery() {
        return donorSurgery;
    }

    public SurgeryEntity getRecipientSurgery() {
        return recipientSurgery;
    }

    @Override
    public String toString() {
        return "TransplantationEntity{" +
                "donorSurgery=" + donorSurgery +
                ", recipientSurgery=" + recipientSurgery +
                ", organ='" + organ + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransplantationEntity that)) return false;

        if (!getDonorSurgery().equals(that.getDonorSurgery())) return false;
        return getRecipientSurgery().equals(that.getRecipientSurgery());
    }

    @Override
    public int hashCode() {
        int result = getDonorSurgery().hashCode();
        result = 31 * result + getRecipientSurgery().hashCode();
        return result;
    }
}
