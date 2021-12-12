package by.busir.yanushkevich.lab03.client.service;

import by.busir.yanushkevich.lab03.client.service.impl.ClientServiceImpl;

public final class ClientServiceFactory {
    private static final ClientServiceFactory instance = new ClientServiceFactory();

    private final ClientService clientService = new ClientServiceImpl();

    private ClientServiceFactory() {
    }

    public ClientService getClientService() {
        return clientService;
    }

    public static ClientServiceFactory getInstance() {
        return instance;
    }
}
