package corejava.chapter5.additional.withoutExceptions;

public enum CustomError {
    FILE_NOT_FOUND(-1, "File not found."),
    INCORRECT_SYMBOL(-2, "Format number isn't correct."),
    TECHNICAL_ERROR(-3, "Technical problem.");

    final int code;
    final String message;

    CustomError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorCode: " + code + "\n" +
                "Message: '" + message + "'\n";
    }
}
