package ru.job4j.servlets;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String login;
    private String email;
    private String createDate;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(login, user.login) &&
                Objects.equals(email, user.email) &&
                Objects.equals(createDate, user.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, email, createDate);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("---------------------------------------")
                .append(System.lineSeparator())
                .append("id = ")
                .append(this.id)
                .append(System.lineSeparator())
                .append("name = ")
                .append(this.name)
                .append(System.lineSeparator())
                .append("login = ")
                .append(this.login)
                .append(System.lineSeparator())
                .append("email = ")
                .append(this.email)
                .append(System.lineSeparator())
                .append("createDate = ")
                .append(this.createDate)
                .append(System.lineSeparator()).toString();
    }
}
