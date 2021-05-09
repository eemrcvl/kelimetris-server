package kelimetris.monitor.controller;

import kelimetris.core.lib.model.GameLog;
import kelimetris.monitor.service.impl.GameLogMonitoringServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameLogMonitoringController {
    private GameLogMonitoringServiceImpl gameLogMonitoringService;

    public GameLogMonitoringController(GameLogMonitoringServiceImpl gameLogMonitoringService) {
        this.gameLogMonitoringService = gameLogMonitoringService;
    }

    @RequestMapping(value = "/logs", method = RequestMethod.GET)
    public ResponseEntity<List<GameLog>> getGameLogs(@RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                     @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameLogMonitoringService.getGameLogs(pageNumber, pageSize);
    }

    @RequestMapping(value = "/logs/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<GameLog>> getGameLogsOfUser(@PathVariable("userId") String userId,
                                                           @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                           @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameLogMonitoringService.getGameLogsOfUser(userId, pageNumber, pageSize);
    }

    @RequestMapping(value = "/logs_after/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<GameLog>> getGameLogsByDateAfter(@PathVariable("date") String date,
                                                                @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameLogMonitoringService.getGameLogsByDateAfter(date, pageNumber, pageSize);
    }

    @RequestMapping(value = "/logs_before/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<GameLog>> getGameLogsByDateBefore(@PathVariable("date") String date,
                                                                 @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                 @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameLogMonitoringService.getGameLogsByDateBefore(date, pageNumber, pageSize);
    }

    @RequestMapping(value = "/logs_between/{start}/{end}", method = RequestMethod.GET)
    public ResponseEntity<List<GameLog>> getGameLogsByDateBetween(@PathVariable("start") String startDate,
                                                                  @PathVariable("end") String endDate,
                                                                  @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                  @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameLogMonitoringService.getGameLogsByDateBetween(startDate, endDate, pageNumber, pageSize);
    }
}
