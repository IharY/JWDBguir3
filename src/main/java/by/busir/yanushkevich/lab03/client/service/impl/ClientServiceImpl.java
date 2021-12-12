package by.busir.yanushkevich.lab03.client.service.impl;

import by.busir.yanushkevich.lab03.client.service.ClientService;
import by.busir.yanushkevich.lab03.client.service.ServiceException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientServiceImpl implements ClientService {
    private static final String HOST_NAME = "localhost";
    private static final int PORT = 8080;

    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public ClientServiceImpl() {
    }

    @Override
    public boolean connect(String request) throws ServiceException {
        try {
            Socket socket = new Socket(HOST_NAME, PORT);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            return true;
        } catch (IOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void sendRequest(String request) throws ServiceException {
        try {
            outputStream.writeUTF(request);
        } catch (IOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public String getResponse() throws ServiceException {
        try {
            return inputStream.readUTF();
        } catch (IOException e) {
            throw new ServiceException();
        }
    }
}
