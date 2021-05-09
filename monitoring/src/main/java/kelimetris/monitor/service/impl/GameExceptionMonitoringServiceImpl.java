package kelimetris.monitor.service.impl;

import kelimetris.core.lib.model.GameExceptionMessage;
import kelimetris.core.lib.repository.GameExceptionMessageRepository;
import kelimetris.monitor.service.GameExceptionMonitoringService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameExceptionMonitoringServiceImpl implements GameExceptionMonitoringService {
    private final GameExceptionMessageRepository gameExceptionMessageRepository;

    public GameExceptionMonitoringServiceImpl(GameExceptionMessageRepository gameExceptionMessageRepository) {
        this.gameExceptionMessageRepository = gameExceptionMessageRepository;
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionMessages(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameExceptionMessage> exceptions = gameExceptionMessageRepository.findAll(pageable);
        return new ResponseEntity<>(exceptions.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByUserId(String userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameExceptionMessage> exceptions = gameExceptionMessageRepository.findAllByUserId(userId, pageable);
        return new ResponseEntity<>(exceptions.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateAfter(String date, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameExceptionMessage> exceptions = gameExceptionMessageRepository.findAllByInsertDateAfter(date, pageable);
        return new ResponseEntity<>(exceptions.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateBefore(String date, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameExceptionMessage> exceptions = gameExceptionMessageRepository.findAllByInsertDateBefore(date, pageable);
        return new ResponseEntity<>(exceptions.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateBetween(String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameExceptionMessage> exceptions = gameExceptionMessageRepository.findAllByInsertDateBetween(startDate, endDate, pageable);
        return new ResponseEntity<>(exceptions.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByExceptionMessage(String exceptionMessage, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameExceptionMessage> exceptions = gameExceptionMessageRepository.findAllByExceptionMessage(exceptionMessage, pageable);
        return new ResponseEntity<>(exceptions.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByGameLog(String gameLogId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameExceptionMessage> exceptions = gameExceptionMessageRepository.findAllByGameLogId(gameLogId, pageable);
        return new ResponseEntity<>(exceptions.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsBySearchString(String searchString, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameExceptionMessage> exceptions = gameExceptionMessageRepository.findAllByExceptionMessageContainingIgnoreCase(searchString, pageable);
        return new ResponseEntity<>(exceptions.getContent(), HttpStatus.OK);
    }
}
