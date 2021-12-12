package by.busir.yanushkevich.lab03.server.service;


import by.busir.yanushkevich.lab03.server.service.impl.ServerAccountServiceImpl;
import by.busir.yanushkevich.lab03.server.service.impl.ServerUniversityServiceImpl;

public class ServerServiceFactory {
    private static final ServerServiceFactory instance = new ServerServiceFactory();

    private final ServerUniversityService serverServiceUniversityService = new ServerUniversityServiceImpl();
    private final ServerAccountService serverAccountService = new ServerAccountServiceImpl();

    private ServerServiceFactory() {
    }


    public ServerUniversityService getServerServiceUniversityService() {
        return serverServiceUniversityService;
    }

    public ServerAccountService getServerAccountService() {
        return serverAccountService;
    }

    public static ServerServiceFactory getInstance() {
        return instance;
    }
}
