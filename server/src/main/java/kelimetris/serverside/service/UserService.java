package kelimetris.serverside.service;

import kelimetris.core.lib.dto.ApiResponse;
import kelimetris.core.lib.dto.FeedbackDto;
import kelimetris.core.lib.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<ApiResponse> register(UserDto userDto);
    ResponseEntity<ApiResponse> receiveFeedback(FeedbackDto feedbackDto);
}
