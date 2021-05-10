package kelimetris.core.lib.repository;

import kelimetris.core.lib.base.BaseRepository;
import kelimetris.core.lib.model.GameLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface GameLogRepository extends BaseRepository<GameLog> {
    Page<GameLog> findAll(Pageable pageable);

    Page<GameLog> findAllByUserId(String userId, Pageable pageable);

    Page<GameLog> findAllByInsertDateAfter(long date, Pageable pageable);

    Page<GameLog> findAllByInsertDateBefore(long date, Pageable pageable);

    Page<GameLog> findAllByInsertDateBetween(long startDate, long endDate, Pageable pageable);

}
