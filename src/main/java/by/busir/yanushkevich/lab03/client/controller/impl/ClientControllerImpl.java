package by.busir.yanushkevich.lab03.client.controller.impl;

import by.busir.yanushkevich.lab03.client.controller.ClientController;
import by.busir.yanushkevich.lab03.client.controller.command.ClientCommand;
import by.busir.yanushkevich.lab03.client.controller.command.ClientCommandProvider;
import by.busir.yanushkevich.lab03.client.controller.constant.ClientControllerConstant;

public class ClientControllerImpl implements ClientController {
    @Override
    public String executeRequest(String request) {
        String commandName;
        commandName = request.split("\\s+")[0];

        ClientCommand command = ClientCommandProvider.getCommandByName(commandName);

        if (command == null) {
            return ClientControllerConstant.INVALID_COMMAND_RESPONSE;
        } else {
            return command.execute(request);
        }
    }
}
