package by.busir.yanushkevich.lab03.server.dao;

import by.busir.yanushkevich.lab03.server.dao.impl.AccountDaoImpl;
import by.busir.yanushkevich.lab03.server.dao.impl.UniversityDaoImpl;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final UniversityDao universityDao = new UniversityDaoImpl();
    private final AccountDao accountDao = new AccountDaoImpl();

    private DaoFactory() {
    }

    public UniversityDao getUniversityDao() {
        return universityDao;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public static DaoFactory getInstance() {
        return instance;
    }

}
