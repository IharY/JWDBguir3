package by.busir.yanushkevich.lab03.server.service;

import by.busir.yanushkevich.lab03.server.bean.Student;

import java.util.List;

public interface ServerUniversityService {
    void add(Student student) throws ServerServiceException;

    void edit(Student student) throws ServerServiceException;

    List<Student> getById(String id) throws ServerServiceException;
}
