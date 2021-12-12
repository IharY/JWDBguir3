package by.busir.yanushkevich.lab03.server.service.impl;

import by.busir.yanushkevich.lab03.server.bean.Account;
import by.busir.yanushkevich.lab03.server.dao.DaoException;
import by.busir.yanushkevich.lab03.server.dao.DaoFactory;
import by.busir.yanushkevich.lab03.server.service.ServerAccountService;
import by.busir.yanushkevich.lab03.server.service.ServerServiceException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ServerAccountServiceImpl implements ServerAccountService {
    @Override
    public Account login(String login, String password) throws ServerServiceException {
        try {
            return DaoFactory.getInstance().getAccountDao().login(login, getHash(password));
        } catch (DaoException | NoSuchAlgorithmException e) {
            throw new ServerServiceException(e);
        }
    }

    public static String getHash(String password) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        final StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            final String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
