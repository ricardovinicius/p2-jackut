package br.ufal.ic.p2.jackut.models;

import java.util.UUID;

public class Session {
    private String id;
    private String login;

    public Session(String login) {
        this.login = login;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
