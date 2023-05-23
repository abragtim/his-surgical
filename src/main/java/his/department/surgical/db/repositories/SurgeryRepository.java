package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.HospitalBedEntity;
import his.department.surgical.db.entities.SurgeryEntity;
import his.department.surgical.db.entities.composite_keys.SurgeryCompositeKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends JpaRepository<SurgeryEntity, SurgeryCompositeKey> {

    @Query("SELECT surgery FROM SurgeryEntity surgery " +
            "LEFT JOIN SurgeryFinishTimeEntity finishTime ON surgery = finishTime.surgery " +
            "WHERE finishTime.finishDateTime IS NULL")
    Page<SurgeryEntity> findAllActive(Pageable pageable);
}
