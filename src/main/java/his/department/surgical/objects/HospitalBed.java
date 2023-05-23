package his.department.surgical.objects;

import his.department.surgical.db.entities.HospitalBedEntity;
import his.department.surgical.db.entities.SurgeryEntity;

public class HospitalBed {

    private Integer roomNumber;

    private Integer bedNumber;

    public HospitalBed(Integer roomNumber, Integer bedNumber) {
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
    }

    public static HospitalBed fromEntity(HospitalBedEntity entity) {
        return new HospitalBed(
                entity.getRoomNumber(),
                entity.getBedNumber());
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    @Override
    public String toString() {
        return "HospitalBed{" +
                "roomNumber=" + roomNumber +
                ", bedNumber=" + bedNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HospitalBed that)) return false;

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
