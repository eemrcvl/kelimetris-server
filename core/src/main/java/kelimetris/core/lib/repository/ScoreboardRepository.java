package kelimetris.core.lib.repository;

import kelimetris.core.lib.base.BaseRepository;
import kelimetris.core.lib.model.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScoreboardRepository extends BaseRepository<Score> {
    Page<Score> findAll(Pageable pageable);

    Optional<Score> getScoreByUserId(String userId);

    Page<Score> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int upper, int lower, Pageable pageable);

    Page<Score> findAllByScoreGreaterThan(int score, Pageable pageable);

    Page<Score> findAllByScoreLessThan(int score, Pageable pageable);
}
