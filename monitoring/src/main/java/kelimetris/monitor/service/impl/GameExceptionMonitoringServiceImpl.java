package kelimetris.monitor.service.impl;

import kelimetris.core.lib.model.GameExceptionMessage;
import kelimetris.monitor.service.GameExceptionMonitoringService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GameExceptionMonitoringServiceImpl implements GameExceptionMonitoringService {
    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionMessages() {
        return null;
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByUserId(String userId) {
        return null;
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateAfter(String date) {
        return null;
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateBefore(String date) {
        return null;
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateBetween(String startDate, String endDate) {
        return null;
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByExceptionMessage(String exceptionMessage) {
        return null;
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByGameLog(String gameLogId) {
        return null;
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsBySearchString(String searchString) {
        return null;
    }
}
