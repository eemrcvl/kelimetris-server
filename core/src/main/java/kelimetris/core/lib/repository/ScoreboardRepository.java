package kelimetris.core.lib.repository;

import kelimetris.core.lib.base.BaseRepository;
import kelimetris.core.lib.model.Score;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScoreboardRepository extends BaseRepository<Score> {
    Optional<Score> getScoreByUserId(String userId);
}
