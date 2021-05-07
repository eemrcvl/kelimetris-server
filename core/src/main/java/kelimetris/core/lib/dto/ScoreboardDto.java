package kelimetris.core.lib.dto;

import kelimetris.core.lib.model.Score;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class ScoreboardDto {
    private Page<Score> scores;
}
