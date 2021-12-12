package by.busir.yanushkevich.lab03.server.service;

import by.busir.yanushkevich.lab03.server.bean.Account;

public interface ServerAccountService {
    Account login(String login, String password) throws ServerServiceException;
}
