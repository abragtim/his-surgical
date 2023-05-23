package his.department.surgical.services;

import his.department.surgical.db.entities.HospitalBedEntity;
import his.department.surgical.db.repositories.HospitalBedRepository;
import his.department.surgical.objects.HospitalBed;
import his.department.surgical.objects.Surgery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class HospitalBedService {

    private final HospitalBedRepository hospitalBedRepository;

    @Autowired
    public HospitalBedService(HospitalBedRepository hospitalBedRepository) {
        this.hospitalBedRepository = hospitalBedRepository;
    }

    public Page<HospitalBed> getAllFreeBeds(int pageNumber, int amountPerPage) {
        Page<HospitalBedEntity> surgeriesEntities = hospitalBedRepository.findAllFree(
                PageRequest.of(pageNumber, amountPerPage));
        return surgeriesEntities.map(HospitalBed::fromEntity);
    }
}
