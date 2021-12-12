package by.busir.yanushkevich.lab03.client.service;

public interface ClientService {

    boolean connect(String request) throws ServiceException;

    void sendRequest(String request) throws ServiceException;

    String getResponse() throws ServiceException;
}
