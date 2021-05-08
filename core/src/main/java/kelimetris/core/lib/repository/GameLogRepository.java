package kelimetris.core.lib.repository;

import kelimetris.core.lib.base.BaseRepository;
import kelimetris.core.lib.model.GameLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameLogRepository extends BaseRepository<GameLog> {
    List<GameLog> findAll();

    List<GameLog> findAllByUserId(String userId);

    List<GameLog> findAllByInsertDateAfter(String date);

    List<GameLog> findAllByInsertDateBefore(String date);

    List<GameLog> findAllByInsertDateBetween(String startDate, String endDate);

}
