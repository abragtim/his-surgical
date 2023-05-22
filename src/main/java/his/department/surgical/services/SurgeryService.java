package his.department.surgical.services;

import his.department.surgical.db.entities.SurgeryEntity;
import his.department.surgical.db.repositories.SurgeryRepository;
import his.department.surgical.objects.Surgery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SurgeryService {

    private final SurgeryRepository surgeryRepository;

    @Autowired
    public SurgeryService(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    public Page<Surgery> getAllSurgeriesPageable(int pageNumber, int amountPerPage) {
        Page<SurgeryEntity> surgeriesEntities = surgeryRepository.findAll(
                PageRequest.of(pageNumber, amountPerPage));
        return surgeriesEntities.map(Surgery::fromEntity);
    }
}
