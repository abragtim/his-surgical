package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends
        JpaRepository<PatientEntity, Integer> {}
