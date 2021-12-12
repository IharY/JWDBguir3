package by.busir.yanushkevich.lab03.server.dao;

import by.busir.yanushkevich.lab03.server.bean.Student;

import java.util.List;

public interface UniversityDao {
    List<Student> getById(String id) throws DaoException;

    void add(Student appliance) throws DaoException;

    void edit(Student student) throws DaoException;
}
