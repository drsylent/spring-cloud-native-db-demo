package hu.cubix.cloud.db.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "visit")
public class VisitEntity {

    public VisitEntity() {
    }

    public VisitEntity(long id, long visited) {
        this.id = id;
        this.visited = visited;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "visited", nullable = false)
    private long visited;

    public long getId() {
        return id;
    }

    public long visited() {
        return ++visited;
    }
}
