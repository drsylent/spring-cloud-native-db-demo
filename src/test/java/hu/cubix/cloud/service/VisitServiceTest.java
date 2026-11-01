package hu.cubix.cloud.service;

import hu.cubix.cloud.db.entity.VisitEntity;
import hu.cubix.cloud.db.repository.VisitRepository;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

class VisitServiceTest {

    private VisitRepository repository;
    private VisitService service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(VisitRepository.class);
        service = new VisitService(repository);
    }

    @Test
    void visited_empty() {
        Mockito.when(repository.findAll()).thenReturn(Collections.emptyList());

        long result = service.visited();

        MatcherAssert.assertThat(result, CoreMatchers.is(1L));
        Mockito.verify(repository).save(Mockito.any(VisitEntity.class));
    }

    @Test
    void visited_initialized() {
        VisitEntity entity = new VisitEntity(1L, 1L);
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(entity));

        long result = service.visited();

        MatcherAssert.assertThat(result, CoreMatchers.is(2L));
        Mockito.verify(repository, Mockito.never()).save(Mockito.any());
    }
}
