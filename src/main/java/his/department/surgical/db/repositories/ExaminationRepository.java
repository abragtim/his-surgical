package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.ExaminationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<ExaminationEntity, Integer> {}
