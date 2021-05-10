package kelimetris.core.lib.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GameLogDto {
    private String id;
    private long numberOfClicks;
    private long score;
    private long numberOfTetrominos;
    private List<String> exceptionMessages;
    private long wordCount;
    private String userId;
}
