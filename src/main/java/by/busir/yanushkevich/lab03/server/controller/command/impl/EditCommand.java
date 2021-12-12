package by.busir.yanushkevich.lab03.server.controller.command.impl;

import by.busir.yanushkevich.lab03.server.bean.Account;
import by.busir.yanushkevich.lab03.server.bean.Role;
import by.busir.yanushkevich.lab03.server.bean.Student;
import by.busir.yanushkevich.lab03.server.controller.command.ServerCommand;
import by.busir.yanushkevich.lab03.server.service.ServerServiceException;
import by.busir.yanushkevich.lab03.server.service.ServerServiceFactory;
import by.busir.yanushkevich.lab03.server.service.ServerUniversityService;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class EditCommand implements ServerCommand {
    @Override
    public String execute(String request, Account account) {
        if (account.getRole() == Role.GUEST) {
            return "Not authorized";
        } else if (account.getRole() != Role.ADMIN) {
            return "Not enough rights";
        }

        ServerServiceFactory serviceFactory = ServerServiceFactory.getInstance();
        ServerUniversityService serverService = serviceFactory.getServerServiceUniversityService();

        Map<String, String> params = new HashMap<>();
        for (String param : request.split("\\s+")) {
            String[] keyValue = param.split("=");
            if (keyValue.length == 2) {
                params.put(keyValue[0], keyValue[1].replaceAll("\"", ""));
            }
        }

        StringBuilder response = new StringBuilder();

        try {
            serverService.edit(new Student(params));
            return "Student edited\n";
        } catch (ServerServiceException | ParseException e) {
            response.append(e.getMessage()).append("\n");
        }

        return response.toString();
    }
}
