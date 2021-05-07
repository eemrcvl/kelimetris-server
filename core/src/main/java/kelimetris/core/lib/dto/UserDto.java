package kelimetris.core.lib.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    private String id;
    private String username;
}
