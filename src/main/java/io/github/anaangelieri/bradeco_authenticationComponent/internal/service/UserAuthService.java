package io.github.anaangelieri.bradeco_authenticationComponent.internal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.anaangelieri.bradeco_authenticationComponent.internal.model.User;

public class UserAuthService {

    private final Map<String, User> users = new HashMap<>();
    private int nextId = 1;

    public User register(String name, String email, String password) {
        for (User u : users.values()) {
            if (u.getEmail().equals(email)) {
                return null; 
            }
        }
        User user = new User(email, nextId++, name, password);
        users.put(email, user);
        return user;
    }

    public User authenticate(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(int id) {
        for (User user : users.values()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; 
    }

    public boolean delete(int id) {
        User user = getUserById(id);
        if (user != null) {
            users.remove(user.getEmail());
            return true;
        }
        return false;
    }

    public void showSplashScreen() {
        System.out.println("==== Splash Screen ====");
        System.out.println("Bem-vindo à Splash Screen do Bazar Books!");
        System.out.println("Iniciando aplicação...");
    }

    public void passOnboarding() {
        System.out.println("==== Onboarding ====");
        System.out.println("Bem-vindo ao Bazar Books!");
        System.out.println("Leia, descubra, compartilhe.");
    }

}
