package kelimetris.core.lib.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FeedbackDto {
    private String userId;
    private String message;
    private int stars;
}
