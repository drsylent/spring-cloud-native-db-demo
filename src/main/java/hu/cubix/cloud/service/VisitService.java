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
        VisitEntity first = repository.findAll().stream().findFirst().orElse(new VisitEntity(1L, 0L));
        long visited = first.visited();
        repository.save(first);
        return visited;
    }
}
