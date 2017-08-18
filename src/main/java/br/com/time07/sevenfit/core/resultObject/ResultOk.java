package br.com.time07.sevenfit.core.resultObject;

public class ResultOk extends Result {

    public ResultOk(Object data) {
        super(true);
        this.data = data;
    }

    private Object data;

    public Object getData() {
        return data;
    }
}
