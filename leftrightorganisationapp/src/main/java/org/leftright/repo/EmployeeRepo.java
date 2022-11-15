package org.leftright.repo;

import org.leftright.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    //custom methods
}
