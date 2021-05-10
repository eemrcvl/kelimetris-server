package kelimetris.monitor.service.impl;

import kelimetris.core.lib.model.GameLog;
import kelimetris.core.lib.repository.GameLogRepository;
import kelimetris.monitor.service.GameLogMonitoringService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameLogMonitoringServiceImpl implements GameLogMonitoringService {
    private final GameLogRepository gameLogRepository;

    public GameLogMonitoringServiceImpl(GameLogRepository gameLogRepository) {
        this.gameLogRepository = gameLogRepository;
    }

    @Override
    public ResponseEntity<List<GameLog>> getGameLogs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameLog> logs = gameLogRepository.findAll(pageable);
        return new ResponseEntity<>(logs.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GameLog>> getGameLogsOfUser(String userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameLog> logs = gameLogRepository.findAllByUserId(userId, pageable);
        return new ResponseEntity<>(logs.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GameLog>> getGameLogsByDateAfter(long date, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameLog> logs = gameLogRepository.findAllByInsertDateAfter(date, pageable);
        return new ResponseEntity<>(logs.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GameLog>> getGameLogsByDateBefore(long date, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameLog> logs = gameLogRepository.findAllByInsertDateBefore(date, pageable);
        return new ResponseEntity<>(logs.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GameLog>> getGameLogsByDateBetween(long startDate, long endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameLog> logs = gameLogRepository.findAllByInsertDateBetween(startDate, endDate, pageable);
        return new ResponseEntity<>(logs.getContent(), HttpStatus.OK);
    }
}
