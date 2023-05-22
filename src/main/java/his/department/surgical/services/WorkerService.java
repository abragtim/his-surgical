package his.department.surgical.services;

import his.department.surgical.db.entities.composite_keys.SurgeryCompositeKey;
import his.department.surgical.db.repositories.SurgeryRepository;
import his.department.surgical.db.repositories.WorkerRepository;
import his.department.surgical.exceptions.SurgeryNotFoundException;
import his.department.surgical.exceptions.UnsuccessfulWorkerAppointmentBaseException;
import his.department.surgical.exceptions.WorkerNotFoundException;
import his.department.surgical.objects.Surgery;
import his.department.surgical.objects.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;
    private final SurgeryRepository surgeryRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository,
                         SurgeryRepository surgeryRepository) {
        this.workerRepository = workerRepository;
        this.surgeryRepository = surgeryRepository;
    }

    public void appointWorkerToSurgeryAsSupport(Worker worker,
                                                Surgery surgery,
                                                String role)
            throws UnsuccessfulWorkerAppointmentBaseException,
            SurgeryNotFoundException, WorkerNotFoundException {
        if (!workerRepository.existsById(worker.getPhone())) {
            throw new WorkerNotFoundException(
                    "Worker with phone %s not found.".formatted(worker.getPhone()));
        } else if (!surgeryRepository.existsById(new SurgeryCompositeKey(
                surgery.getOperatingRoomNumber(),
                surgery.getStartDateTime()
        ))) {
            throw new SurgeryNotFoundException("Such surgery doesn't exist.");
        }
        if (!workerRepository.appointWorkerAsSurgerySupport(
                worker.getPhone(),
                surgery.getOperatingRoomNumber(),
                surgery.getStartDateTime().getDate(),
                surgery.getStartDateTime().getTime(),
                role)) {
            throw new UnsuccessfulWorkerAppointmentBaseException(
                    "An error occurred while assigning a worker to the operation.");
        }

    }
}
