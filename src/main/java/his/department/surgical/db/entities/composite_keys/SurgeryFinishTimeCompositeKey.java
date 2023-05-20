package his.department.surgical.db.entities.composite_keys;

import his.department.surgical.db.entities.SurgeryEntity;

import java.io.Serializable;

public class SurgeryFinishTimeCompositeKey implements Serializable {

    private SurgeryEntity surgery;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SurgeryFinishTimeCompositeKey that)) return false;

        return surgery.equals(that.surgery);
    }

    @Override
    public int hashCode() {
        return surgery.hashCode();
    }
}
