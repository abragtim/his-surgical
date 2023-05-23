package his.department.surgical;

import his.department.surgical.db.entities.DatetimeEntity;
import his.department.surgical.dtos.PatientDtoIn;
import his.department.surgical.dtos.SurgeryDtoOut;
import his.department.surgical.exceptions.*;
import his.department.surgical.objects.HospitalBed;
import his.department.surgical.objects.Patient;
import his.department.surgical.objects.Surgery;
import his.department.surgical.objects.Worker;
import his.department.surgical.services.HospitalBedService;
import his.department.surgical.services.PatientService;
import his.department.surgical.services.SurgeryService;
import his.department.surgical.services.WorkerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
@RestController
public class SurgicalApplication {

	private final SurgeryService surgeryService;
	private final PatientService patientService;
	private final HospitalBedService hospitalBedService;
	private final WorkerService workerService;

	public SurgicalApplication(SurgeryService surgeryService,
							   PatientService patientService,
							   HospitalBedService hospitalBedService,
							   WorkerService workerService) {
		this.surgeryService = surgeryService;
		this.patientService = patientService;
		this.hospitalBedService = hospitalBedService;
		this.workerService = workerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SurgicalApplication.class, args);
	}

	@GetMapping("/active-surgeries")
	public Page<SurgeryDtoOut> getAllActiveSurgeries(
			@RequestParam(value = "page") int page) {
		Page<Surgery> surgeries = this.surgeryService.getAllActiveSurgeriesPageable(
				page, 10);
		return surgeries.map(Surgery::toDtoOut);
	}

	@GetMapping("/free-beds")
	public Page<HospitalBed> getAllFreeHospitalBeds(
			@RequestParam(value = "page") int page) {
		return this.hospitalBedService.getAllFreeBeds(page, 20);
	}

	@PostMapping("/patients/create-patient")
	public ResponseEntity<String> createPatient(
			@RequestBody PatientDtoIn patientDtoIn
			) throws AlreadyExistsException,
			OccupiedBedException, BedNotFoundException {
		HospitalBed hospitalBed = new HospitalBed(
				patientDtoIn.getRoomNumber(),
				patientDtoIn.getBedNumber()
		);
		Patient patient = new Patient(
				patientDtoIn.getMedicalId(),
				hospitalBed,
				patientDtoIn.getAge(),
				patientDtoIn.getInsuranceNumber(),
				patientDtoIn.getName(),
				patientDtoIn.getDateOfBirth(),
				patientDtoIn.getIdCardNumber(),
				patientDtoIn.getPhone(),
				patientDtoIn.getSex(),
				patientDtoIn.getEmail(),
				patientDtoIn.getPatientStatus()
		);
		patientService.addNewPatient(patient);
		return ResponseEntity.ok("Patient created successfully.");
	}

	@PutMapping("/worker/appoint-to-surgery")
	public ResponseEntity<String> appointWorkerToSurgery(
			@RequestParam(value = "worker") String workerPhone,
			@RequestParam(value = "operating_room") Integer operatingRoom,
			@RequestParam(value = "start_time") String startDateTimeString,
			@RequestParam(value = "role") String role
	) throws InvalidDateException {
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			java.util.Date utilStartDateTime = dateFormat.parse(startDateTimeString);
			//Timestamp startDateTime = new Timestamp(utilStartDateTime.getTime());
			Date startDate = new Date(utilStartDateTime.getTime());
			Time startTime = new Time(utilStartDateTime.getTime());

			Surgery surgery = surgeryService.getByRoomNumberAndStartDateTime(
					operatingRoom,
					new DatetimeEntity(startDate, startTime));
			Worker worker = new Worker(workerPhone);
			this.workerService.appointWorkerToSurgeryAsSupport(worker, surgery, role);
		} catch (ParseException ex) {
			throw new InvalidDateException("Wrong date format. " +
					"The expected format is dd-MM-yyyy HH:mm.");
		} catch (SurgeryNotFoundException |
				 UnsuccessfulWorkerAppointmentBaseException |
				 WorkerNotFoundException e) {
			throw new RuntimeException(e);
		}
		return ResponseEntity.ok("Success");
	}
}
