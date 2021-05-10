package kelimetris.serverside.controller;

import kelimetris.core.lib.dto.ApiResponse;
import kelimetris.core.lib.dto.FeedbackDto;
import kelimetris.core.lib.dto.UserDto;
import kelimetris.serverside.service.impl.PingServiceImpl;
import kelimetris.serverside.service.impl.ScoreboardServiceImpl;
import kelimetris.serverside.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameOperationsController {
    private final UserServiceImpl userService;
    private final PingServiceImpl pingService;
    private final ScoreboardServiceImpl scoreboardService;

    public GameOperationsController(UserServiceImpl userService, PingServiceImpl pingService, ScoreboardServiceImpl scoreboardService) {
        this.userService = userService;
        this.pingService = pingService;
        this.scoreboardService = scoreboardService;
    }

    @RequestMapping(value = "/save-feedback", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> saveFeedback(@RequestBody FeedbackDto feedbackDto) {
        return userService.receiveFeedback(feedbackDto);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> register(@RequestBody UserDto userDto) {
        return userService.register(userDto);
    }

    @RequestMapping(value = "/update-username", method = RequestMethod.POST)
    public ResponseEntity<?> updateUsername(@RequestBody UserDto userDto) {
        return userService.updateUsername(userDto);
    }

    @RequestMapping(value = "/is-online", method = RequestMethod.GET)
    public ResponseEntity<?> isOnline() {
        return pingService.okService();
    }

    @RequestMapping(value = "/scoreboard/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getScoreboard(@PathVariable(value = "id") String userId) {
        return scoreboardService.returnScoreboard(userId);
    }
}
