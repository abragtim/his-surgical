package his.department.surgical.dtos;

import his.department.surgical.db.entities.DatetimeEntity;

public class SurgeryDtoOut {

    private String startTime;
    private Integer operatingRoomNumber;
    private String leadingDoctorName;
    private String patientName;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(DatetimeEntity startTime) {
        this.startTime = startTime.toString();
    }

    public Integer getOperatingRoomNumber() {
        return operatingRoomNumber;
    }

    public void setOperatingRoomNumber(Integer operatingRoomNumber) {
        this.operatingRoomNumber = operatingRoomNumber;
    }

    public String getLeadingDoctorName() {
        return leadingDoctorName;
    }

    public void setLeadingDoctorName(String leadingDoctorName) {
        this.leadingDoctorName = leadingDoctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public SurgeryDtoOut(DatetimeEntity startTime,
                         Integer operatingRoomNumber,
                         String leadingDoctorName,
                         String patientName) {
        this.startTime = startTime.toString();
        this.operatingRoomNumber = operatingRoomNumber;
        this.leadingDoctorName = leadingDoctorName;
        this.patientName = patientName;
    }
}
