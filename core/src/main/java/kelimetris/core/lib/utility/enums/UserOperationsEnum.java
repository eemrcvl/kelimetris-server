package kelimetris.core.lib.utility.enums;

public enum UserOperationsEnum {
    REGISTRATION_SUCCESS_MESSAGE("User registration is successful."),
    REGISTRATION_FAIL_MESSAGE("User registration failed. Please try again now or later."),
    UPDATE_USERNAME_SUCCESS_MESSAGE("Username has been updated successfully."),
    UPDATE_USERNAME_FAIL_MESSAGE("Username was not updated. Please try again now or later."),
    USER_NOT_FOUND_MESSAGE("User not found.")
    ;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    UserOperationsEnum(String message) {
        this.message = message;
    }
}
