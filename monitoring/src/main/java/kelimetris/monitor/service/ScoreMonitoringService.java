package kelimetris.monitor.service;

import kelimetris.core.lib.model.Score;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScoreMonitoringService {

    ResponseEntity<List<Score>> getScores();

    ResponseEntity<List<Score>> getScoresByScoreGreaterThanAndLessThan(int upper, int lower);

    ResponseEntity<List<Score>> getScoresByScoreGreaterThan(int score);

    ResponseEntity<List<Score>> getScoresByScoreLessThan(int score);
}
