package kelimetris.serverside.service;

import kelimetris.core.lib.model.Score;

import java.util.List;

public interface ScoreboardService {
    List<Score> returnScoreboard(String userId);
}
