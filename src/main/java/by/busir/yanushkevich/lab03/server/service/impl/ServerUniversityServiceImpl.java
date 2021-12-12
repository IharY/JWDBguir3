package by.busir.yanushkevich.lab03.server.service.impl;

import by.busir.yanushkevich.lab03.server.bean.Student;
import by.busir.yanushkevich.lab03.server.dao.DaoException;
import by.busir.yanushkevich.lab03.server.dao.DaoFactory;
import by.busir.yanushkevich.lab03.server.service.ServerServiceException;
import by.busir.yanushkevich.lab03.server.service.ServerUniversityService;

import java.util.List;

public class ServerUniversityServiceImpl implements ServerUniversityService {
    public ServerUniversityServiceImpl() {
    }

    @Override
    public void add(Student student) throws ServerServiceException {
        try {
            DaoFactory.getInstance().getUniversityDao().add(student);
        } catch (DaoException e) {
            throw new ServerServiceException(e);
        }
    }

    @Override
    public void edit(Student student) throws ServerServiceException {
        try {
            DaoFactory.getInstance().getUniversityDao().edit(student);
        } catch (DaoException e) {
            throw new ServerServiceException(e);
        }
    }

    @Override
    public List<Student> getById(String id) throws ServerServiceException {
        try {
            return DaoFactory.getInstance().getUniversityDao().getById(id);
        } catch (DaoException e) {
            throw new ServerServiceException(e);
        }
    }
}
