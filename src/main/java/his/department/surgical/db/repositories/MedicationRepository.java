package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<MedicationEntity, Integer> {}
