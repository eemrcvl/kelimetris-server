package kelimetris.core.lib.utility.handlers;

import kelimetris.core.lib.base.KelimetrisConstants;
import kelimetris.core.lib.dto.ApiResponse;
import kelimetris.core.lib.utility.enums.UserOperationsEnum;
import kelimetris.core.lib.utility.exceptions.FeedbackException;
import kelimetris.core.lib.utility.exceptions.RegistrationException;
import kelimetris.core.lib.utility.exceptions.ScoreboardException;
import kelimetris.core.lib.utility.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    /**
     * For exceptions which occur during transactions between the  server and client side.
     */
    @ExceptionHandler(FeedbackException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiResponse handleFeedbackException(FeedbackException feedbackException) {
        return new ApiResponse(KelimetrisConstants.FEEDBACK_FAIL_MESSAGE);
    }

    @ExceptionHandler(RegistrationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiResponse handleRegistrationException(RegistrationException registrationException) {
        return new ApiResponse(UserOperationsEnum.REGISTRATION_FAIL_MESSAGE.getMessage());
    }

    @ExceptionHandler(ScoreboardException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiResponse handleScoreboardException(ScoreboardException scoreboardException) {
        return new ApiResponse(KelimetrisConstants.SCOREBOARD_RETRIEVAL_ERROR_MESSAGE);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiResponse handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        return new ApiResponse(UserOperationsEnum.USER_NOT_FOUND_MESSAGE.getMessage());
    }
}
