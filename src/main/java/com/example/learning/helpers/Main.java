package com.example.learning.helpers;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = JdbcConnectionUtil.getConnection();
        EmployeeJdbcDao employeeDao = new EmployeeJdbcDao(con);
        Employee emp = new Employee(1, "john");
        employeeDao.createTable();
        employeeDao.add(emp);

    }
}
