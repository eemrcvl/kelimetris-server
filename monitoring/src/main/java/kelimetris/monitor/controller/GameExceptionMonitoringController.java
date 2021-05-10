package kelimetris.monitor.controller;

import kelimetris.core.lib.model.GameExceptionMessage;
import kelimetris.monitor.service.GameExceptionMonitoringService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameExceptionMonitoringController {
    private final GameExceptionMonitoringService gameExceptionMonitoringService;

    public GameExceptionMonitoringController(GameExceptionMonitoringService gameExceptionMonitoringService) {
        this.gameExceptionMonitoringService = gameExceptionMonitoringService;
    }

    @RequestMapping(value = "/exceptions", method = RequestMethod.GET)
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptions(@RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                        @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameExceptionMonitoringService.getGameExceptionMessages(pageNumber, pageSize);
    }

    @RequestMapping(value = "/exceptions/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsOfUser(@PathVariable("userId") String userId,
                                                                              @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                              @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameExceptionMonitoringService.getGameExceptionsByUserId(userId, pageNumber, pageSize);
    }

    @RequestMapping(value = "/exceptions/log/{gameLogId}", method = RequestMethod.GET)
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByLog(@PathVariable("gameLogId") String gameLogId,
                                                                             @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                             @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameExceptionMonitoringService.getGameExceptionsByGameLog(gameLogId, pageNumber, pageSize);
    }

    @RequestMapping(value = "/exceptions/search/{query}", method = RequestMethod.GET)
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsBySearchQuery(@PathVariable("query") String query,
                                                                                     @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                                     @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameExceptionMonitoringService.getGameExceptionsBySearchString(query, pageNumber, pageSize);
    }

    @RequestMapping(value = "/exceptions/exception/{message}", method = RequestMethod.GET)
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByExceptionMessage(@PathVariable("message") String message,
                                                                                          @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                                          @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameExceptionMonitoringService.getGameExceptionsByExceptionMessage(message, pageNumber, pageSize);
    }

    @RequestMapping(value = "/exceptions_after/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateAfter(@PathVariable("date") long date,
                                                                                   @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                                   @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameExceptionMonitoringService.getGameExceptionsByDateAfter(date, pageNumber, pageSize);
    }

    @RequestMapping(value = "/exceptions_before/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateBefore(@PathVariable("date") long date,
                                                                                    @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                                    @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameExceptionMonitoringService.getGameExceptionsByDateBefore(date, pageNumber, pageSize);
    }

    @RequestMapping(value = "/exceptions_between/{start}/{end}", method = RequestMethod.GET)
    public ResponseEntity<List<GameExceptionMessage>> getGameExceptionsByDateBetween(@PathVariable("start") long startDate,
                                                                                     @PathVariable("end") long endDate,
                                                                                     @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                                     @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return gameExceptionMonitoringService.getGameExceptionsByDateBetween(startDate, endDate, pageNumber, pageSize);
    }
}
