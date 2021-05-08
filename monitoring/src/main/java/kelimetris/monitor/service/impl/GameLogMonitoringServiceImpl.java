package kelimetris.monitor.service.impl;

import kelimetris.core.lib.model.GameLog;
import kelimetris.monitor.service.GameLogMonitoringService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GameLogMonitoringServiceImpl implements GameLogMonitoringService {
    @Override
    public ResponseEntity<List<GameLog>> getGameLogs() {
        return null;
    }

    @Override
    public ResponseEntity<List<GameLog>> getGameLogsOfUser(String userId) {
        return null;
    }

    @Override
    public ResponseEntity<List<GameLog>> getGameLogsByDateAfter(String date) {
        return null;
    }

    @Override
    public ResponseEntity<List<GameLog>> getGameLogsByDateBefore(String date) {
        return null;
    }

    @Override
    public ResponseEntity<List<GameLog>> getGameLogsByDateBetween(String startDate, String endDate) {
        return null;
    }
}
