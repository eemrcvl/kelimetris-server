package kelimetris.serverside.service.impl;

import kelimetris.core.lib.base.KelimetrisConstants;
import kelimetris.core.lib.dto.ApiResponse;
import kelimetris.core.lib.dto.FeedbackDto;
import kelimetris.core.lib.dto.UserDto;
import kelimetris.core.lib.model.Feedback;
import kelimetris.core.lib.model.User;
import kelimetris.core.lib.repository.FeedbackRepository;
import kelimetris.core.lib.repository.UserRepository;
import kelimetris.core.lib.utility.exceptions.FeedbackException;
import kelimetris.core.lib.utility.exceptions.RegistrationException;
import kelimetris.core.lib.utility.handlers.ApiExceptionHandler;
import kelimetris.serverside.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;
    private final ApiExceptionHandler apiExceptionHandler;

    public UserServiceImpl(ModelMapper modelMapper, FeedbackRepository feedbackRepository, UserRepository userRepository, ApiExceptionHandler apiExceptionHandler) {
        this.modelMapper = modelMapper;
        this.feedbackRepository = feedbackRepository;
        this.userRepository = userRepository;
        this.apiExceptionHandler = apiExceptionHandler;
    }

    @Override
    public ResponseEntity<ApiResponse> register(UserDto userDto) {
        try {
            var user = modelMapper.map(userDto, User.class);
            userRepository.save(user);
            return new ResponseEntity<>(new ApiResponse(KelimetrisConstants.REGISTRATION_SUCCESS_MESSAGE), HttpStatus.OK);
        } catch (RegistrationException exception) {
            //TODO Logging of exception
            return new ResponseEntity<>(apiExceptionHandler.handleRegistrationException(exception), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<ApiResponse> receiveFeedback(FeedbackDto feedbackDto) {
        try {
            var feedback = modelMapper.map(feedbackDto, Feedback.class);
            feedbackRepository.save(feedback);
            return new ResponseEntity<>(new ApiResponse(KelimetrisConstants.FEEDBACK_SUCCESS_MESSAGE), HttpStatus.OK);
        } catch (FeedbackException exception) {
            //TODO Logging of exception
            return new ResponseEntity<>(apiExceptionHandler.handleFeedbackException(exception), HttpStatus.BAD_REQUEST);
        }
    }
}
