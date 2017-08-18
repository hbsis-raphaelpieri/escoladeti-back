package br.com.time07.sevenfit.core.resultObject;

import br.com.time07.sevenfit.fluentValidation.Notification;

import java.util.Collection;

public class ResultNotification extends Result {

    public ResultNotification(Collection<Notification> errors) {
        super(false);
        this.errors = errors;
    }

    private Collection<Notification> errors;
}
