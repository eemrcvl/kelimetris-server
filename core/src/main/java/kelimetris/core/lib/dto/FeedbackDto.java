package kelimetris.core.lib.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FeedbackDto {
    private String userId;
    private String message;
    private String insertDate;
    private String insertTime;
    private int stars;
}
