package his.department.surgical.objects;

public class HospitalBed {

    private Integer roomNumber;

    private Integer bedNumber;

    public HospitalBed(Integer roomNumber, Integer bedNumber) {
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
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
