package kelimetris.core.lib.repository;

import kelimetris.core.lib.base.BaseRepository;
import kelimetris.core.lib.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends BaseRepository<Feedback> {
    Page<Feedback> findAll(Pageable pageable);

    Page<Feedback> findAllByUserId(String userId, Pageable pageable);

    Page<Feedback> findAllByMessageContainingIgnoreCase(String message, Pageable pageable);

    Page<Feedback> findAllByInsertDateAfter(long date, Pageable pageable);

    Page<Feedback> findAllByInsertDateBefore(long date, Pageable pageable);

    Page<Feedback> findAllByInsertDateBetween(long startDate, long endDate, Pageable pageable);

    Page<Feedback> findAllByStarsGreaterThanEqual(int stars, Pageable pageable);

    Page<Feedback> findAllByStarsIsLessThanEqual(int stars, Pageable pageable);

    Optional<Feedback> findByUserId(String userId);
}
