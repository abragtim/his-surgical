package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.SurgerySupporterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgerySupporterRepository extends
        JpaRepository<SurgerySupporterEntity, Integer> {}
