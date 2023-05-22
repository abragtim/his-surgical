package his.department.surgical.objects;

import his.department.surgical.db.entities.DatetimeEntity;
import his.department.surgical.db.entities.SurgeryEntity;
import his.department.surgical.dtos.SurgeryDtoOut;

public class Surgery {

    private Integer operatingRoomNumber;

    private DatetimeEntity startDateTime;

    private String patientName; // TODO: use Patient.json

    private String leadingDoctorName; // TODO: create and use Doctor.json

    public Surgery(Integer operatingRoomNumber,
                   DatetimeEntity startDateTime,
                   String patientName,
                   String leadingDoctorName) {
        this.operatingRoomNumber = operatingRoomNumber;
        this.startDateTime = startDateTime;
        this.patientName = patientName;
        this.leadingDoctorName = leadingDoctorName;
    }

    public Integer getOperatingRoomNumber() {
        return operatingRoomNumber;
    }

    public DatetimeEntity getStartDateTime() {
        return startDateTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getLeadingDoctorName() {
        return leadingDoctorName;
    }

    public static Surgery fromEntity(SurgeryEntity entity) {
        return new Surgery(
                entity.getOperatingRoomNumber(),
                entity.getStartDateTime(),
                entity.getPatient().getName(),
                entity.getLeadSurgeon().getName());
    }

    public static SurgeryDtoOut toDtoOut(Surgery surgery) {
        return new SurgeryDtoOut(
                surgery.getStartDateTime(),
                surgery.getOperatingRoomNumber(),
                surgery.getLeadingDoctorName(),
                surgery.getPatientName()
        );
    }

    @Override
    public String toString() {
        return "Surgery{" +
                "operatingRoomNumber=" + operatingRoomNumber +
                ", startDateTime=" + startDateTime +
                '}';
    }
}
