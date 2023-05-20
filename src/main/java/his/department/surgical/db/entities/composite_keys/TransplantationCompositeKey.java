package his.department.surgical.db.entities.composite_keys;

import his.department.surgical.db.entities.SurgeryEntity;

import java.io.Serializable;

public class TransplantationCompositeKey implements Serializable {

    private SurgeryEntity donorSurgery;

    private SurgeryEntity recipientSurgery;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransplantationCompositeKey that)) return false;

        if (!donorSurgery.equals(that.donorSurgery)) return false;
        return recipientSurgery.equals(that.recipientSurgery);
    }

    @Override
    public int hashCode() {
        int result = donorSurgery.hashCode();
        result = 31 * result + recipientSurgery.hashCode();
        return result;
    }
}
