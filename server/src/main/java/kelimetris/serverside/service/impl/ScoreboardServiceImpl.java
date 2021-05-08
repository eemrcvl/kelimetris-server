package kelimetris.serverside.service.impl;

import kelimetris.core.lib.model.Score;
import kelimetris.core.lib.repository.ScoreboardRepository;
import kelimetris.core.lib.utility.exceptions.ScoreboardException;
import kelimetris.core.lib.utility.handlers.ApiExceptionHandler;
import kelimetris.serverside.service.ScoreboardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreboardServiceImpl implements ScoreboardService {
    private final ScoreboardRepository scoreboardRepository;
    private final ApiExceptionHandler apiExceptionHandler;
    public ScoreboardServiceImpl(ScoreboardRepository scoreboardRepository, ApiExceptionHandler apiExceptionHandler) {
        this.scoreboardRepository = scoreboardRepository;
        this.apiExceptionHandler = apiExceptionHandler;
    }

    @Override
    public ResponseEntity returnScoreboard(String userId) {
        try {
            Page<Score> scores = scoreboardRepository.findAll(PageRequest.of(0, 50, Sort.by(Sort.Direction.DESC, "score")));
            List<Score> scoreboard = new ArrayList<>(scores.getContent());

            if(scoreboard.size() == 50 && scoreboardRepository.getScoreByUserId(userId).isPresent()) {
                var user = scoreboardRepository.getScoreByUserId(userId);
                var score = Score.builder()
                        .username(user.get().getUsername())
                        .score(user.get().getScore())
                        .build();
                scoreboard.add(score);
                scoreboard = scoreboard.stream()
                        .sorted(Comparator.comparing(Score::getScore))
                        .collect(Collectors.toList());
            }
            return new ResponseEntity<>(scoreboard, HttpStatus.OK);
        } catch (ScoreboardException exception) {
            return new ResponseEntity<>(apiExceptionHandler.handleScoreboardException(exception), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
