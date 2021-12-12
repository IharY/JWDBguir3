package by.busir.yanushkevich.lab03.client.controller;

import by.busir.yanushkevich.lab03.client.controller.impl.ClientControllerImpl;

public class ClientControllerFactory {
    private static final ClientControllerFactory instance = new ClientControllerFactory();
    private final ClientController clientController = new ClientControllerImpl();

    private ClientControllerFactory() {
    }

    public static ClientControllerFactory getInstance() {
        return instance;
    }

    public ClientController getClientController() {
        return getClientController();
    }

}
