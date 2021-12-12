package by.busir.yanushkevich.lab03;

import by.busir.yanushkevich.lab03.client.Client;
import by.busir.yanushkevich.lab03.server.Server;

public class Main {
    public static void main(String[] args) {
        new Server().start();
        new Client().start();
    }
}
