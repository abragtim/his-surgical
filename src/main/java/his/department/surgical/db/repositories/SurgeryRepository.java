package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.SurgeryEntity;
import his.department.surgical.db.entities.composite_keys.SurgeryCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends JpaRepository<SurgeryEntity, SurgeryCompositeKey> {}
