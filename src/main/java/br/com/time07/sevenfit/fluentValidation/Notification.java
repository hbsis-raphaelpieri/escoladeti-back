package br.com.time07.sevenfit.fluentValidation;

public class Notification {
    public Notification(String property, String message) {
        this.property = property;
        this.message = message;
    }

    private String property;
    private String message;


    public String getProperty() {
        return property;
    }
    public String getMessage() {
        return message;
    }
}
