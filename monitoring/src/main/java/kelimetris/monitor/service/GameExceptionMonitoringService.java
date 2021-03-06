package kelimetris.monitor.service;

import kelimetris.core.lib.model.GameExceptionMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GameExceptionMonitoringService {
    ResponseEntity<List<GameExceptionMessage>> getGameExceptionMessages(int page, int size);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByUserId(String userId, int page, int size);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateAfter(long date, int page, int size);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateBefore(long date, int page, int size);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateBetween(long startDate, long endDate, int page, int size);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByExceptionMessage(String exceptionMessage, int page, int size);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByGameLog(String gameLogId, int page, int size);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsBySearchString(String searchString, int page, int size);
}
