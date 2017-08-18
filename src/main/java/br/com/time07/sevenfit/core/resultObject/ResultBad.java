package br.com.time07.sevenfit.core.resultObject;

public class ResultBad extends Result {
    public ResultBad(String error) {
        super(false);
        this.error = error;
    }

    private String error;

    public String getError() {
        return error;
    }
}
