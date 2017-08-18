package br.com.time07.sevenfit.core.bases;

import java.util.UUID;

public abstract class IdBase {

    public IdBase() {
        this.id = UUID.randomUUID().toString();
    }
    private String id;

    public String getId() {
        return id;
    }
}
