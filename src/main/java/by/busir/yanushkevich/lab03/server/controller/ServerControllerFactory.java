package by.busir.yanushkevich.lab03.server.controller;

import by.busir.yanushkevich.lab03.server.controller.impl.ServerControllerImpl;

public class ServerControllerFactory {
    private static final ServerControllerFactory instance = new ServerControllerFactory();

    private final ServerController serverController = new ServerControllerImpl();

    private ServerControllerFactory() {
    }

    public ServerController getServerController() {
        return serverController;
    }

    public static ServerControllerFactory getInstance() {
        return instance;
    }
}
