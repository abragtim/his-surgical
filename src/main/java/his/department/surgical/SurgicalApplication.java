package his.department.surgical;

import his.department.surgical.db.entities.*;
import his.department.surgical.db.repositories.*;
import his.department.surgical.dtos.SurgeryDtoOut;
import his.department.surgical.enums.PatientStatus;
import his.department.surgical.objects.HospitalBed;
import his.department.surgical.objects.Patient;
import his.department.surgical.objects.Surgery;
import his.department.surgical.services.PatientService;
import his.department.surgical.services.SurgeryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SurgicalApplication {

	private final SurgeryService surgeryService;

	public SurgicalApplication(SurgeryService surgeryService) {
		this.surgeryService = surgeryService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SurgicalApplication.class, args);
	}

	@GetMapping("/surgeries")
	public Page<SurgeryDtoOut> getAllSurgeries(
			@RequestParam(value = "page") int page) {
		Page<Surgery> surgeries = this.surgeryService.getAllSurgeriesPageable(
				page, 10);
		return surgeries.map(Surgery::toDtoOut);
	}
}
