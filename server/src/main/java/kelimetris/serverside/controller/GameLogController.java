package kelimetris.serverside.controller;

import kelimetris.core.lib.dto.GameLogDto;
import kelimetris.serverside.service.impl.GameLogServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameLogController {
    private final GameLogServiceImpl gameLogService;

    public GameLogController(GameLogServiceImpl gameLogService) {
        this.gameLogService = gameLogService;
    }

    @RequestMapping(value = "/post-log", method = RequestMethod.POST)
    public void getGameLog(@RequestBody GameLogDto gameLogDto) {
        gameLogService.receiveSaveLog(gameLogDto);
    }
}
