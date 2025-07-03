package io.github.anaangelieri.userAuthComponent;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.anaangelieri.userAuthComponent.internal.model.User;
import io.github.anaangelieri.userAuthComponent.internal.service.UserAuthService;
import io.github.anaangelieri.userAuthComponent.provided.UserAuthConcreteInterfacePort;

public class UserAuthComponentTest {

    private UserAuthConcreteInterfacePort authPort;

    @BeforeEach
    public void setup() {
        UserAuthService authService = new UserAuthService();
        authPort = new UserAuthConcreteInterfacePort(authService);
    }

    // Teste para registrar usuário
    @Test
    public void testRegisterUser() {
        String name = "Ana";
        String email = "ana@examplo.com";
        String password = "senha123";
        User user = authPort.registerNewUser(name, email, password);
        assertNotNull(user);
        assertEquals(name, user.getNome());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(1, user.getId());
    }

    // Teste para autenticar usuário (sucesso)
    @Test
    public void testAuthenticateUserSuccess() {
        String name = "Ana";
        String email = "ana@examplo.com";
        String password = "senha123";
        authPort.registerNewUser(name, email, password);
        User authenticatedUser = authPort.authenticateUser(email, password);
        assertNotNull(authenticatedUser);
        assertEquals(email, authenticatedUser.getEmail());
        assertEquals(name, authenticatedUser.getNome());
    }

    // Teste para autenticar o usuário (email errado)
    @Test
    public void testAuthenticateUserFailure() {
        String email = "email@examplo.com";
        String password = "senha123";
        User authenticatedUser = authPort.authenticateUser(email, password);
        assertNull(authenticatedUser);
    }

    // Teste para autenticar o usuário (senha errada)
    @Test
    public void testAuthenticateUserWrongPassword() {
        String name = "Ana";
        String email = "ana@examplo.com";
        String password = "senha1234";
        authPort.registerNewUser(name, email, password);
        User authenticatedUser = authPort.authenticateUser(email, "senhaerrada");
        assertNull(authenticatedUser);
    }

    // teste para obter todos os usuários
    @Test
    public void testGetAllUsers() {
        authPort.registerNewUser("Ana", "ana@examplo.com", "senha123");
        authPort.registerNewUser("Carlos", "carlos@examplo.com", "senha456");
        List<User> users = authPort.getAllUsers();
        assertEquals(2, users.size());
    }

    // teste para obter usuário por ID
    @Test
    public void testGetUserById() {
        User user = authPort.registerNewUser("Ana", "ana@examplo.com", "senha123");
        int id = user.getId();
        User retrieved = authPort.getUserById(id);
        assertNotNull(retrieved);
        assertEquals(user.getEmail(), retrieved.getEmail());
    }

    // Teste para deletar usuário
    @Test
    public void testDeleteUser() {
        User user = authPort.registerNewUser("Ana", "ana@examplo.com", "senha123");
        int id = user.getId();
        boolean deleted = authPort.deleteUser(id);
        assertTrue(deleted);
        assertNull(authPort.getUserById(id));
    }

    // Teste para mostrar a splashScreen
    @Test
    public void testShowSplashScreen() {
        authPort.showSplashScreen();
    }

    // Teste para mostrar o OnBoarding
    @Test
    public void testPassOnboarding() {
        authPort.passOnboarding();
    }
}
