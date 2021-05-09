package kelimetris.monitor.controller;

import kelimetris.core.lib.model.Score;
import kelimetris.monitor.service.impl.ScoreMonitoringServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreMonitoringController {
    private final ScoreMonitoringServiceImpl scoreMonitoringService;

    public ScoreMonitoringController(ScoreMonitoringServiceImpl scoreMonitoringService) {
        this.scoreMonitoringService = scoreMonitoringService;
    }

    @RequestMapping(value = "/scores", method = RequestMethod.GET)
    public ResponseEntity<List<Score>> getScores(@RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                 @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return scoreMonitoringService.getScores(pageNumber, pageSize);
    }

    @RequestMapping(value = "/scores/{score}/higher", method = RequestMethod.GET)
    public ResponseEntity<List<Score>> getScoresGreaterThan(@PathVariable("score") int score,
                                                            @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                            @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return scoreMonitoringService.getScoresByScoreGreaterThan(score, pageNumber, pageSize);
    }

    @RequestMapping(value = "/scores/{score}/lower", method = RequestMethod.GET)
    public ResponseEntity<List<Score>> getScoresLessThan(@PathVariable("score") int score,
                                                         @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                         @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return scoreMonitoringService.getScoresByScoreLessThan(score, pageNumber, pageSize);
    }

    @RequestMapping(value = "/scores/{upper}&{lower}", method = RequestMethod.GET)
    public ResponseEntity<List<Score>> getScoresBetween(@PathVariable("upper") int upper,
                                                        @PathVariable("lower") int lower,
                                                        @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                        @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return scoreMonitoringService.getScoresByScoreGreaterThanAndLessThan(upper, lower, pageNumber, pageSize);
    }
}
