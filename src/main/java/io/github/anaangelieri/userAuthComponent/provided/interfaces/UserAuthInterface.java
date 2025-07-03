package io.github.anaangelieri.userAuthComponent.provided.interfaces;

import java.util.List;

import io.github.anaangelieri.userAuthComponent.internal.model.User;


public interface UserAuthInterface {
    User registerNewUser(String name, String email, String password);
    User authenticateUser(String email, String password);
    List<User> getAllUsers();
    User getUserById(int id);
    boolean deleteUser(int id);
    void showSplashScreen();
    void passOnboarding();
}
