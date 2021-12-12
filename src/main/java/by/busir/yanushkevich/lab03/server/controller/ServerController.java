package by.busir.yanushkevich.lab03.server.controller;

import by.busir.yanushkevich.lab03.server.bean.Account;

public interface ServerController {
    String executeRequest(String request, Account account);
}
