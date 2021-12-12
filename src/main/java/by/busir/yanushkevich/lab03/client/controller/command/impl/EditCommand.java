package by.busir.yanushkevich.lab03.client.controller.command.impl;

import by.busir.yanushkevich.lab03.client.controller.command.ClientCommand;
import by.busir.yanushkevich.lab03.client.service.ClientService;
import by.busir.yanushkevich.lab03.client.service.ClientServiceFactory;
import by.busir.yanushkevich.lab03.client.service.ServiceException;

public class EditCommand implements ClientCommand {

    @Override
    public String execute(String request) {
        ClientServiceFactory serviceFactory = ClientServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();

        String response;

        try {
            clientService.sendRequest(request);
            response = clientService.getResponse();
        } catch (ServiceException e) {
            response = e.getMessage();
        }
        return response;
    }
}
