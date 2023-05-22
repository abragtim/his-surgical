package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.WorkerEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity, String> {


    @Transactional
    @Query(value = "SELECT appoint_worker_as_surgery_support(" +
            ":workerPhone, :roomNumber, :startDate, :startTime, :role)",
            nativeQuery = true)
    boolean appointWorkerAsSurgerySupport(
            @Param("workerPhone") String workerPhone,
            @Param("roomNumber") Integer roomNumber,
            @Param("startDate") Date startDate,
            @Param("startTime") Time startTime,
            @Param("role") String role
    );
}
