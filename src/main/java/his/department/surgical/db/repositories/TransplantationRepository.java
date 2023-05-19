package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.TransplantationEntity;
import his.department.surgical.db.entities.composite_keys.TransplantationCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransplantationRepository extends
        JpaRepository<TransplantationEntity, TransplantationCompositeKey> {
}
