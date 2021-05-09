package kelimetris.monitor.service;

import kelimetris.core.lib.model.Score;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScoreMonitoringService {

    ResponseEntity<List<Score>> getScores(int page, int size);

    ResponseEntity<List<Score>> getScoresByScoreGreaterThanAndLessThan(int upper, int lower, int page, int size);

    ResponseEntity<List<Score>> getScoresByScoreGreaterThan(int score, int page, int size);

    ResponseEntity<List<Score>> getScoresByScoreLessThan(int score, int page, int size);
}
