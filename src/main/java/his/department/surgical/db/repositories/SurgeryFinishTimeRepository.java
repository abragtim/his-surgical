package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.SurgeryFinishTimeEntity;
import his.department.surgical.db.entities.composite_keys.SurgeryFinishTimeCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryFinishTimeRepository extends
        JpaRepository<SurgeryFinishTimeEntity, SurgeryFinishTimeCompositeKey> {}
