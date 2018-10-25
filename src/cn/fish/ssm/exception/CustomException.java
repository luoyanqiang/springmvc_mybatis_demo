package cn.fish.ssm.exception;

public class CustomException extends Exception {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomException(String message) {
        this.message = message;
    }

}
