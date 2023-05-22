package his.department.surgical.db.entities.composite_keys;

import his.department.surgical.db.entities.DatetimeEntity;

import java.io.Serializable;

public class SurgeryCompositeKey implements Serializable {

    private Integer operatingRoomNumber;

    private DatetimeEntity startDateTime;

    protected SurgeryCompositeKey() {
    }

    public SurgeryCompositeKey(Integer operatingRoomNumber, DatetimeEntity startDateTime) {
        this.operatingRoomNumber = operatingRoomNumber;
        this.startDateTime = startDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SurgeryCompositeKey that)) return false;

        if (!operatingRoomNumber.equals(that.operatingRoomNumber)) return false;
        return startDateTime.equals(that.startDateTime);
    }

    @Override
    public int hashCode() {
        int result = operatingRoomNumber.hashCode();
        result = 31 * result + startDateTime.hashCode();
        return result;
    }
}
