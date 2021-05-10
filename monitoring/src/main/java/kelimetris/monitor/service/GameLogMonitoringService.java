package kelimetris.monitor.service;

import kelimetris.core.lib.model.GameLog;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GameLogMonitoringService {
    ResponseEntity<List<GameLog>> getGameLogs(int page, int size);

    ResponseEntity<List<GameLog>> getGameLogsOfUser(String userId, int page, int size);

    ResponseEntity<List<GameLog>> getGameLogsByDateAfter(long date, int page, int size);

    ResponseEntity<List<GameLog>> getGameLogsByDateBefore(long date, int page, int size);

    ResponseEntity<List<GameLog>> getGameLogsByDateBetween(long startDate, long endDate, int page, int size);
}
