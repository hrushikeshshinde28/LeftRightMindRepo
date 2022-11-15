package org.leftright.service;

import org.leftright.model.Employee;
import org.leftright.model.TaskDetailsModel;
import org.leftright.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepoImpl;
    public String register(Employee employee) {

        String ss="";
        Employee employee1=    employeeRepoImpl.save(employee);
        if(employee1 != null )
        {
            ss="Regsiterd Successully";
        }else {
            ss="Failed to Regsiter Please try Again";
        }
        return ss;
    }


}
