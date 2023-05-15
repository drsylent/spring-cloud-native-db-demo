package hu.cubix.cloud.service;

import hu.cubix.cloud.db.entity.VisitEntity;
import hu.cubix.cloud.db.repository.VisitRepository;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

class VisitServiceTest {

    private static final VisitRepository repository = Mockito.mock(VisitRepository.class);
    private static final VisitService service = new VisitService(repository);

    @Test
    void visited_empty() {
        Mockito.when(repository.findAll()).thenReturn(Collections.emptyList());

        long result = service.visited();

        MatcherAssert.assertThat(result, CoreMatchers.is(1L));
        Mockito.verify(repository, Mockito.atLeastOnce()).save(Mockito.any());
    }

    @Test
    void visited_initialized() {
        VisitEntity entity = new VisitEntity(1L, 1L);
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(entity));

        long result = service.visited();

        MatcherAssert.assertThat(result, CoreMatchers.is(2L));
        Mockito.verify(repository, Mockito.atLeastOnce()).save(entity);
        Mockito.verify(repository, Mockito.atMostOnce()).save(entity);
    }
}