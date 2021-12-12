package by.busir.yanushkevich.lab03.server.controller.impl;

import by.busir.yanushkevich.lab03.server.bean.Account;
import by.busir.yanushkevich.lab03.server.controller.ServerController;
import by.busir.yanushkevich.lab03.server.controller.command.ServerCommand;
import by.busir.yanushkevich.lab03.server.controller.command.ServerCommandProvider;

public class ServerControllerImpl implements ServerController {
    @Override
    public String executeRequest(String request, Account account) {
        String commandName;
        commandName = request.split("\\s+")[0];
        ServerCommand command = ServerCommandProvider.getServerCommandByName(commandName);
        return command.execute(request, account);
    }
}
