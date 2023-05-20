package his.department.surgical.db.repositories;

import his.department.surgical.db.entities.SurgeryNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryNoteRepository extends
        JpaRepository<SurgeryNoteEntity, SurgeryNoteEntity> {}
