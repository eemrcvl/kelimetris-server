package kelimetris.monitor.service;

import kelimetris.core.lib.model.GameExceptionMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GameExceptionMonitoringService {
    ResponseEntity<List<GameExceptionMessage>> getGameExceptionMessages();

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByUserId(String userId);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateAfter(String date);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateBefore(String date);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateBetween(String startDate, String endDate);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByExceptionMessage(String exceptionMessage);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByGameLog(String gameLogId);

    ResponseEntity<List<GameExceptionMessage>> getGameExceptionsBySearchString(String searchString);
}
