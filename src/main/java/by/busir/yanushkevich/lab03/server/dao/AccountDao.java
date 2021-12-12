package by.busir.yanushkevich.lab03.server.dao;

import by.busir.yanushkevich.lab03.server.bean.Account;

public interface AccountDao {
    Account login(String login, String passwordHash) throws DaoException;
}
