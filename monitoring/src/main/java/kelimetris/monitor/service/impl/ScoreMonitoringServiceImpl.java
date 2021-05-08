package kelimetris.monitor.service.impl;

import kelimetris.core.lib.model.Score;
import kelimetris.monitor.service.ScoreMonitoringService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ScoreMonitoringServiceImpl implements ScoreMonitoringService {
    @Override
    public ResponseEntity<List<Score>> getScores() {
        return null;
    }

    @Override
    public ResponseEntity<List<Score>> getScoresByScoreGreaterThanAndLessThan(int upper, int lower) {
        return null;
    }

    @Override
    public ResponseEntity<List<Score>> getScoresByScoreGreaterThan(int score) {
        return null;
    }

    @Override
    public ResponseEntity<List<Score>> getScoresByScoreLessThan(int score) {
        return null;
    }
}
