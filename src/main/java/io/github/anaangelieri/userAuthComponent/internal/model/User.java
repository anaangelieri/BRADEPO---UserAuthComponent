package io.github.anaangelieri.userAuthComponent.internal.model;

public class User {

    private Integer id;
    private String email;
    private String nome;
    private String password;

    public User(String email, Integer id, String nome, String password) {
        this.email = email;
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
