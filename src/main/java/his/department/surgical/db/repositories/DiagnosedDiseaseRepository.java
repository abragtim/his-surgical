package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.DiagnosedDiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosedDiseaseRepository extends
        JpaRepository<DiagnosedDiseaseEntity, Integer> {}
