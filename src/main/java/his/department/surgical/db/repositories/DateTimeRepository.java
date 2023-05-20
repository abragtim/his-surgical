package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.DatetimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DateTimeRepository extends
        JpaRepository<DatetimeEntity, DatetimeEntity> {}
