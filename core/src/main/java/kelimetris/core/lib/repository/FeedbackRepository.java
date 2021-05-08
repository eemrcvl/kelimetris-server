package kelimetris.core.lib.repository;

import kelimetris.core.lib.base.BaseRepository;
import kelimetris.core.lib.model.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends BaseRepository<Feedback> {
    List<Feedback> findAll();

    List<Feedback> findAllByUserId(String userId);

    List<Feedback> findAllByMessageContainingIgnoreCase(String message);

    List<Feedback> findAllByInsertDateAfter(String date);

    List<Feedback> findAllByInsertDateBefore(String date);

    List<Feedback> findAllByInsertDateBetween(String startDate, String endDate);

    List<Feedback> findAllByStarsGreaterThanEqual(int stars);

    List<Feedback> findAllByStarsIsLessThanEqual(int stars);

    Optional<Feedback> findByUserId(String userId);
}
