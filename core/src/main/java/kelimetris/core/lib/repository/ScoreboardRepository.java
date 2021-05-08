package kelimetris.core.lib.repository;

import kelimetris.core.lib.base.BaseRepository;
import kelimetris.core.lib.model.Score;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScoreboardRepository extends BaseRepository<Score> {
    List<Score> findAll();

    Optional<Score> getScoreByUserId(String userId);

    List<Score> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int upper, int lower);

    List<Score> findAllByScoreGreaterThan(int score);

    List<Score> findAllByScoreLessThan(int score);
}
