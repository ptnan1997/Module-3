package Bai1.ra.dao;

import Bai1.ra.entity.Students;

import java.sql.SQLException;

public interface IManager {
    void addStudents (Students student) throws SQLException;
}
