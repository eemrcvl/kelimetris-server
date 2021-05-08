package kelimetris.monitor.service;

import kelimetris.core.lib.model.GameLog;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GameLogMonitoringService {
    ResponseEntity<List<GameLog>> getGameLogs();

    ResponseEntity<List<GameLog>> getGameLogsOfUser(String userId);

    ResponseEntity<List<GameLog>> getGameLogsByDateAfter(String date);

    ResponseEntity<List<GameLog>> getGameLogsByDateBefore(String date);

    ResponseEntity<List<GameLog>> getGameLogsByDateBetween(String startDate, String endDate);
}
