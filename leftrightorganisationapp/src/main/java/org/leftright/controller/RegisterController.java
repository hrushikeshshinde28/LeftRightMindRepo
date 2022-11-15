package org.leftright.controller;

import org.leftright.model.Employee;
import org.leftright.model.TaskDetailsModel;
import org.leftright.service.EmployeeService;
import org.leftright.service.TaskDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RegisterController {

    @Autowired
    EmployeeService employeeServiceImpl;

    @Autowired
    TaskDetailsService taskDetailsServiceImpl;

    @PostMapping("/registeremployee")
    public ResponseEntity<String> register(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeServiceImpl.register(employee));
    }

}
