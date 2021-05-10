package kelimetris.serverside.service.impl;

import kelimetris.core.lib.base.KelimetrisConstants;
import kelimetris.core.lib.dto.ApiResponse;
import kelimetris.core.lib.dto.FeedbackDto;
import kelimetris.core.lib.dto.UserDto;
import kelimetris.core.lib.model.Feedback;
import kelimetris.core.lib.model.User;
import kelimetris.core.lib.repository.FeedbackRepository;
import kelimetris.core.lib.repository.UserRepository;
import kelimetris.core.lib.utility.enums.UserOperationsEnum;
import kelimetris.core.lib.utility.exceptions.FeedbackException;
import kelimetris.core.lib.utility.exceptions.RegistrationException;
import kelimetris.core.lib.utility.exceptions.UserNotFoundException;
import kelimetris.core.lib.utility.handlers.ApiExceptionHandler;
import kelimetris.core.lib.utility.methods.UtilityMethods;
import kelimetris.serverside.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;
    private final ApiExceptionHandler apiExceptionHandler;

    public UserServiceImpl(FeedbackRepository feedbackRepository, UserRepository userRepository, ApiExceptionHandler apiExceptionHandler) {
        this.feedbackRepository = feedbackRepository;
        this.userRepository = userRepository;
        this.apiExceptionHandler = apiExceptionHandler;
    }

    @Override
    public ResponseEntity<ApiResponse> register(UserDto userDto) {
        try {
            if (userRepository.findUserById(userDto.getId()).isEmpty()) {
                var user = User.builder()
                        .id(userDto.getId())
                        .username(userDto.getUsername())
                        .insertDate(UtilityMethods.getCurrentDate())
                        .insertTime(UtilityMethods.getCurrentTime())
                        .lastUpdated(UtilityMethods.getLastUpdated())
                        .build();
                userRepository.save(user);
                return new ResponseEntity<>(new ApiResponse(UserOperationsEnum.REGISTRATION_SUCCESS_MESSAGE.getMessage()), HttpStatus.OK);
            }
            return new ResponseEntity<>(new ApiResponse(UserOperationsEnum.REGISTRATION_FAIL_MESSAGE.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RegistrationException exception) {
            //TODO Logging of exception
            return new ResponseEntity<>(apiExceptionHandler.handleRegistrationException(exception), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<ApiResponse> receiveFeedback(FeedbackDto feedbackDto) {
        try {
            //TODO: Feedback check
            var feedback = Feedback.builder()
                    .userId(feedbackDto.getUserId())
                    .message(feedbackDto.getMessage())
                    .stars(feedbackDto.getStars())
                    .insertDate(UtilityMethods.getCurrentDate())
                    .insertTime(UtilityMethods.getCurrentTime())
                    .build();

            feedbackRepository.save(feedback);
            return new ResponseEntity<>(new ApiResponse(KelimetrisConstants.FEEDBACK_SUCCESS_MESSAGE), HttpStatus.OK);
        } catch (FeedbackException exception) {
            //TODO Logging of exception
            return new ResponseEntity<>(apiExceptionHandler.handleFeedbackException(exception), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ApiResponse> updateUsername(UserDto userDto) {
        try {
            if (userRepository.findUserById(userDto.getId()).isPresent()) {
                // Username update
                var user = userRepository.findUserById(userDto.getId()).get();
                user.setUsername(userDto.getUsername());
                userRepository.save(user);
                return new ResponseEntity<>(new ApiResponse(UserOperationsEnum.UPDATE_USERNAME_SUCCESS_MESSAGE.getMessage()), HttpStatus.OK);
            }
            return new ResponseEntity<>(new ApiResponse(UserOperationsEnum.USER_NOT_FOUND_MESSAGE.getMessage()), HttpStatus.NOT_FOUND);
        } catch (UserNotFoundException userNotFoundException) {
            return new ResponseEntity<>(apiExceptionHandler.handleUserNotFoundException(userNotFoundException), HttpStatus.NOT_FOUND);
        }
    }
}
