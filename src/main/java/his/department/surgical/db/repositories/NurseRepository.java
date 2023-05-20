package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.NurseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends JpaRepository<NurseEntity, String> {}
    // TODO: extends also WorkerRepository (as part of https://github.com/abragtim/his-surgical/issues/7)
