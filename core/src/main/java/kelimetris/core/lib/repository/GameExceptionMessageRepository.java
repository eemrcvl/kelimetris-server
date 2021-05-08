package kelimetris.core.lib.repository;

import kelimetris.core.lib.base.BaseRepository;
import kelimetris.core.lib.model.GameExceptionMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameExceptionMessageRepository extends BaseRepository<GameExceptionMessage> {
    List<GameExceptionMessage> findAll();

    List<GameExceptionMessage> findAllByUserId(String userId);

    List<GameExceptionMessage> findAllByInsertDateAfter(String date);

    List<GameExceptionMessage> findAllByInsertDateBefore(String date);

    List<GameExceptionMessage> findAllByInsertDateBetween(String startDate, String endDate);

    List<GameExceptionMessage> findAllByExceptionMessage(String exceptionMessage);

    List<GameExceptionMessage> findAllByGameLogId(String gameLogId);

    List<GameExceptionMessage> findAllByExceptionMessageContainingIgnoreCase(String exceptionMessage);
}
