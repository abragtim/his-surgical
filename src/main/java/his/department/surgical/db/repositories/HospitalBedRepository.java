package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.HospitalBedEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalBedRepository extends
        JpaRepository<HospitalBedEntity, HospitalBedEntity> {

    @Query("SELECT CASE WHEN COUNT(bed) > 0 THEN false ELSE true END " +
            "FROM HospitalBedEntity bed INNER JOIN PatientEntity patient ON bed = patient.hospitalBed " +
            "WHERE bed = :hospitalBed")
    boolean isBedAvailable(@Param("hospitalBed") HospitalBedEntity hospitalBedEntity);

    @Query("SELECT bed FROM HospitalBedEntity bed " +
            "LEFT JOIN PatientEntity patient ON bed = patient.hospitalBed " +
            "WHERE patient IS NULL")
    Page<HospitalBedEntity> findAllFree(Pageable pageable);
}
