package kelimetris.core.lib.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GameLogDto {
    private String id;
    private long numberOfClicks;
    private int score;
    private int numberOfTetrominos;
    private List<String> exceptionMessages;
    private int wordCount;
    private String insertDate;
    private String insertTime;
    private String userId;
}
