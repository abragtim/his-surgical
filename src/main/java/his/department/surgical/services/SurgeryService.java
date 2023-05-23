package his.department.surgical.services;

import his.department.surgical.db.entities.DatetimeEntity;
import his.department.surgical.db.entities.SurgeryEntity;
import his.department.surgical.db.entities.composite_keys.SurgeryCompositeKey;
import his.department.surgical.db.repositories.SurgeryRepository;
import his.department.surgical.objects.Surgery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

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

    public Page<Surgery> getAllActiveSurgeriesPageable(int pageNumber, int amountPerPage) {
        Page<SurgeryEntity> surgeriesEntities = surgeryRepository.findAllActive(
                PageRequest.of(pageNumber, amountPerPage));
        return surgeriesEntities.map(Surgery::fromEntity);
    }

    public Surgery getByRoomNumberAndStartDateTime (int operatingRoom,
                                                    DatetimeEntity startDateTime) throws
            NoSuchElementException {
        Optional<SurgeryEntity> surgeryEntity = surgeryRepository.findById(
                new SurgeryCompositeKey(operatingRoom, startDateTime));
        return Surgery.fromEntity(surgeryEntity.orElseThrow());
    }
}
