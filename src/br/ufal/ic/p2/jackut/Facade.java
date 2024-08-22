package br.ufal.ic.p2.jackut;

import br.ufal.ic.p2.jackut.models.Session;
import br.ufal.ic.p2.jackut.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Facade {
    private List<User> users = new ArrayList<User>();
    private List<Session> sessions = new ArrayList<Session>();
    public void zerarSistema() {
        users = new ArrayList<User>();
    }
    public String getAtributoUsuario(String login, String atributo) {
        Optional<User> user_searched = users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
        if (user_searched.isEmpty()) {
            throw new RuntimeException("Usu�rio n�o cadastrado.");
        }

        User user = user_searched.get();

        if (atributo.equals("nome")) {
            return user.getName();
        }

        return "Bad request";
    }

    public void criarUsuario(String login, String senha, String nome) {
        if (login == null || login.isEmpty()) {
            throw new RuntimeException("Login inv�lido.");
        }

        if (senha == null || senha.isEmpty()) {
            throw new RuntimeException("Senha inv�lida.");
        }

        Optional<User> user_searched = users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
        if (user_searched.isPresent()) {
            throw new RuntimeException("Conta com esse nome j� existe.");
        }

        User new_user = new User(nome, login, senha);

        users.add(new_user);
    }

    public String abrirSessao(String login, String senha) {
        if (login == null || login.isEmpty()) {
            throw new RuntimeException("Login ou senha inv�lidos.");
        }

        if (senha == null || senha.isEmpty()) {
            throw new RuntimeException("Login ou senha inv�lidos.");
        }

        Optional<User> user_searched = users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
        if (user_searched.isEmpty()) {
            throw new RuntimeException("Login ou senha inv�lidos.");
        }

        User user = user_searched.get();

        if (user.validarSenha(senha)) {
            Session new_session = new Session(login);
            sessions.add(new_session);

            return new_session.getId();
        }

        throw new RuntimeException("Login ou senha inv�lidos.");
    }

    public void encerrarSistema() {}
}
