package hu.cubix.cloud.service;

import hu.cubix.cloud.db.entity.VisitEntity;
import hu.cubix.cloud.db.repository.VisitRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class VisitService {

    private final VisitRepository repository;

    public VisitService(VisitRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public long visited() {
        var visits = repository.findAll();
        boolean isNew = visits.isEmpty();
        VisitEntity first = isNew ? new VisitEntity() : visits.getFirst();
        long visited = first.visited();
        if (isNew) {
            repository.save(first);
        }
        return visited;
    }
}
