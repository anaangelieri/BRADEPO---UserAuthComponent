package io.github.anaangelieri.userAuthComponent.provided;

import io.github.anaangelieri.userAuthComponent.internal.service.UserAuthService;
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
