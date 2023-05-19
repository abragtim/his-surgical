package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.HospitalBedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalBedRepository extends
        JpaRepository<HospitalBedEntity, HospitalBedEntity> {}
