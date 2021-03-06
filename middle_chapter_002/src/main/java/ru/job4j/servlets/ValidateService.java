package ru.job4j.servlets;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ValidateService {
    //private final Store logic = MemoryStore.getInstance();
    private final Store logic = DbStore.getInstance();
    private static final ValidateService instance = new ValidateService();

    private ValidateService() {
    }

    public static ValidateService getInstance() {
        return instance;
    }

    public Function<User, Boolean> add() {
        return this.logic::add;
    }

    public Function<User, Boolean> update() {
        return this.logic::update;
    }

    public Function<User, Boolean> delete() {
        return this.logic::delete;
    }

    public List<User> users() {
        return this.logic.findAll();
    }

    public Optional<User> getUser(int id) {
        return this.logic.findById(id);
    }
}
