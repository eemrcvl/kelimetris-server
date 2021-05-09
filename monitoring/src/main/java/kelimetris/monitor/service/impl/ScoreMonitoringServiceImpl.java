package kelimetris.monitor.service.impl;

import kelimetris.core.lib.model.GameLog;
import kelimetris.core.lib.model.Score;
import kelimetris.core.lib.repository.ScoreboardRepository;
import kelimetris.monitor.service.ScoreMonitoringService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreMonitoringServiceImpl implements ScoreMonitoringService {
    private final ScoreboardRepository scoreboardRepository;

    public ScoreMonitoringServiceImpl(ScoreboardRepository scoreboardRepository) {
        this.scoreboardRepository = scoreboardRepository;
    }

    @Override
    public ResponseEntity<List<Score>> getScores(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Score> scores = scoreboardRepository.findAll(pageable);
        return new ResponseEntity<>(scores.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Score>> getScoresByScoreGreaterThanAndLessThan(int upper, int lower, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Score> scores = scoreboardRepository.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(upper, lower, pageable);
        return new ResponseEntity<>(scores.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Score>> getScoresByScoreGreaterThan(int score, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Score> scores = scoreboardRepository.findAllByScoreGreaterThan(score, pageable);
        return new ResponseEntity<>(scores.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Score>> getScoresByScoreLessThan(int score, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Score> scores = scoreboardRepository.findAllByScoreLessThan(score, pageable);
        return new ResponseEntity<>(scores.getContent(), HttpStatus.OK);
    }
}
