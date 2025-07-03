package io.github.anaangelieri.bradeco_authenticationComponent.provided;

import io.github.anaangelieri.bradeco_authenticationComponent.internal.UserAuthService;
import io.github.lifveras.bredeco_pic_abstract.provided.ComponentInterface;

public class UserAuthConcreteInterface extends ComponentInterface {

    private UserAuthService authService;

    @Override
    public void initialize(){
        this.id = "authComponent";
        this.authService = new UserAuthService();

        UserAuthConcreteInterfacePort authPort = new UserAuthConcreteInterfacePort(authService);
        ports.add(authPort);
    }
}
