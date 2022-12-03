package hu.webuni.cloud.db.repository;

import hu.webuni.cloud.db.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<VisitEntity, Long> {

}
