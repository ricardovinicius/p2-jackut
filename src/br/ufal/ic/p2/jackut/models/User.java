package br.ufal.ic.p2.jackut.models;

public class User {
    private String name;
    private String login;
    private String password;

    public User() {}
    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean validarSenha(String senha) {
        return senha.equals(password);
    }
}
