package co.com.bancopichincha.mambu.exceptions;

public class TestFailure extends AssertionError {
    public TestFailure(String message, Throwable cause) {
        super(message, cause);
    }

    public TestFailure(String message) {
        super(message);
    }
}
