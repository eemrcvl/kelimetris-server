package kelimetris.core.lib.repository;

import kelimetris.core.lib.base.BaseRepository;
import kelimetris.core.lib.model.GameExceptionMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameExceptionMessageRepository extends BaseRepository<GameExceptionMessage> {
    Page<GameExceptionMessage> findAll(Pageable pageable);

    Page<GameExceptionMessage> findAllByUserId(String userId, Pageable pageable);

    Page<GameExceptionMessage> findAllByInsertDateAfter(long date, Pageable pageable);

    Page<GameExceptionMessage> findAllByInsertDateBefore(long date, Pageable pageable);

    Page<GameExceptionMessage> findAllByInsertDateBetween(long startDate, long endDate, Pageable pageable);

    Page<GameExceptionMessage> findAllByExceptionMessage(String exceptionMessage, Pageable pageable);

    Page<GameExceptionMessage> findAllByGameLogId(String gameLogId, Pageable pageable);

    Page<GameExceptionMessage> findAllByExceptionMessageContainingIgnoreCase(String exceptionMessage, Pageable pageable);
}
