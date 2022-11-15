package org.leftright.service;

import org.leftright.model.Employee;
import org.leftright.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    public String login(String userName, String password) {

        String ss = "";
        List<Employee> employeeList = employeeRepoImpl.findAll();

        for (Employee employee : employeeList)
        {
            if (employee.getEmpEmailId().equals(userName) && employee.getEmpPassword().equals(password)) {
                ss = "Logged in Sucessfully";
                break;
            } else {
                ss = "Invalid Credentials";
            }
        }
        return ss;
    }
}