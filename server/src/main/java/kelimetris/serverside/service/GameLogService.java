package kelimetris.serverside.service;

import kelimetris.core.lib.dto.GameLogDto;

public interface GameLogService {
    void receiveSaveLog(GameLogDto gameLogDto);
}
