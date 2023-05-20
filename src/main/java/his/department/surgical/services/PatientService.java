package his.department.surgical.services;

import his.department.surgical.db.entities.HospitalBedEntity;
import his.department.surgical.db.entities.PatientEntity;
import his.department.surgical.db.repositories.HospitalBedRepository;
import his.department.surgical.db.repositories.PatientRepository;
import his.department.surgical.exceptions.AlreadyExistsException;
import his.department.surgical.exceptions.BedNotFoundException;
import his.department.surgical.exceptions.OccupiedBedException;
import his.department.surgical.objects.Patient;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    private final HospitalBedRepository hospitalBedRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository,
                          HospitalBedRepository hospitalBedRepository) {
        this.patientRepository = patientRepository;
        this.hospitalBedRepository = hospitalBedRepository;
    }

    public void addNewPatient(Patient patient) throws
            AlreadyExistsException, OccupiedBedException, BedNotFoundException {
        HospitalBedEntity hospitalBedEntity= new HospitalBedEntity(patient.getHospitalBed());
        if (!hospitalBedRepository.existsById(hospitalBedEntity)) {
            throw new BedNotFoundException("This bed doesn't exits.");
        } else if (!hospitalBedRepository.isBedAvailable(hospitalBedEntity)) {
            throw new OccupiedBedException(("This bed is occupied."));
        }

        PatientEntity patientEntity = new PatientEntity(patient, hospitalBedEntity);
        try {
            patientRepository.save(patientEntity);
        } catch (EntityExistsException ex) {
            throw new AlreadyExistsException("This patient already exists.");
        }
        patientRepository.flush();
    }
}
