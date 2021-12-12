package by.busir.yanushkevich.lab03.server.controller.command;

import by.busir.yanushkevich.lab03.server.bean.Account;

public interface ServerCommand {
    String execute(String request, Account account);
}
