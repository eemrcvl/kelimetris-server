package kelimetris.serverside.service;

import org.springframework.http.ResponseEntity;

public interface ScoreboardService {
    ResponseEntity returnScoreboard(String userId);
}
