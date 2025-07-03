package io.github.anaangelieri.userAuthComponent.provided;

import java.util.List;

import io.github.anaangelieri.userAuthComponent.internal.model.User;
import io.github.anaangelieri.userAuthComponent.internal.service.UserAuthService;
import io.github.anaangelieri.userAuthComponent.provided.interfaces.UserAuthInterface;
import io.github.lifveras.bredeco_pic_abstract.provided.InterfacePort;

public class UserAuthConcreteInterfacePort extends InterfacePort implements UserAuthInterface {

    private final UserAuthService authService;

    public UserAuthConcreteInterfacePort(UserAuthService authService) {
        this.id = "authPort";
        this.authService = authService;
    }

    @Override
    public User registerNewUser(String name, String email, String password) {
        return authService.register(name, email, password);
    }

    @Override
    public User authenticateUser(String email, String password) {
        return authService.authenticate(email, password);
    }

    @Override
    public List<User> getAllUsers() {
        return authService.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return authService.getUserById(id);
    }

    @Override
    public boolean deleteUser(int id) {
        return authService.delete(id);
    }

    @Override
    public void showSplashScreen() {
        authService.showSplashScreen();
    }

    @Override
    public void passOnboarding() {
        authService.passOnboarding();
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }
}
