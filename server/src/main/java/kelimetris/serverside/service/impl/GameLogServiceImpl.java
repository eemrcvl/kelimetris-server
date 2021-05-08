package kelimetris.serverside.service.impl;

import kelimetris.core.lib.dto.GameLogDto;
import kelimetris.core.lib.model.GameExceptionMessage;
import kelimetris.core.lib.model.GameLog;
import kelimetris.core.lib.model.Score;
import kelimetris.core.lib.repository.GameExceptionMessageRepository;
import kelimetris.core.lib.repository.GameLogRepository;
import kelimetris.core.lib.repository.ScoreboardRepository;
import kelimetris.core.lib.repository.UserRepository;
import kelimetris.serverside.service.GameLogService;
import org.springframework.stereotype.Service;

@Service
public class GameLogServiceImpl implements GameLogService {

    private final GameLogRepository gameLogRepository;
    private final GameExceptionMessageRepository gameExceptionMessageRepository;
    private final ScoreboardRepository scoreboardRepository;
    private final UserRepository userRepository;

    public GameLogServiceImpl(GameLogRepository gameLogRepository, GameExceptionMessageRepository gameExceptionMessageRepository, ScoreboardRepository scoreboardRepository, UserRepository userRepository) {
        this.gameLogRepository = gameLogRepository;
        this.gameExceptionMessageRepository = gameExceptionMessageRepository;
        this.scoreboardRepository = scoreboardRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void receiveSaveLog(GameLogDto gameLogDto) {
        // TODO: Might change the necessity of already registered user when saving game logs.
        if (userRepository.findUserById(gameLogDto.getUserId()).isPresent()) {
            var gameLog = processGameLogObject(gameLogDto);
            gameLogRepository.save(gameLog);
        }
    }

    private GameLog processGameLogObject(GameLogDto gameLogDto) {
        var gameLog = GameLog.builder()
                .id(gameLogDto.getId())
                .insertDate(gameLogDto.getInsertDate())
                .insertTime(gameLogDto.getInsertTime())
                .numberOfClicks(gameLogDto.getNumberOfClicks())
                .numberOfTetrominos(gameLogDto.getNumberOfTetrominos())
                .score(gameLogDto.getScore())
                .wordCount(gameLogDto.getWordCount())
                .userId(gameLogDto.getUserId())
                .build();

        if (gameLogDto.getExceptionMessages().size() > 0) {
            processExceptionLogs(gameLogDto);
        }
        processScoreLog(gameLogDto);

        return gameLog;
    }

    private void processScoreLog(GameLogDto gameLogDto) {

        if (scoreboardRepository.getScoreByUserId(gameLogDto.getUserId()).isPresent()) {
            var scoreToUpdate = scoreboardRepository.getScoreByUserId(gameLogDto.getUserId()).get();
            scoreToUpdate.setScore(scoreToUpdate.getScore() + gameLogDto.getScore());
            scoreboardRepository.save(scoreToUpdate);
        } else {
            if (userRepository.findUserById(gameLogDto.getUserId()).isPresent()) {
                var user = userRepository.findUserById(gameLogDto.getUserId()).get();
                var newScore = Score.builder()
                        .score(gameLogDto.getScore())
                        .userId(gameLogDto.getUserId())
                        .username(user.getUsername())
                        .build();
                scoreboardRepository.save(newScore);
            }
        }
    }

    private void processExceptionLogs(GameLogDto gameLogDto) {
        for (String message :
                gameLogDto.getExceptionMessages()) {
            var gameExceptionMessage = GameExceptionMessage.builder()
                    .gameLogId(gameLogDto.getId())
                    .exceptionMessage(message)
                    .insertDate(gameLogDto.getInsertDate())
                    .insertTime(gameLogDto.getInsertTime())
                    .userId(gameLogDto.getUserId())
                    .build();
            gameExceptionMessageRepository.save(gameExceptionMessage);
        }
    }
}
