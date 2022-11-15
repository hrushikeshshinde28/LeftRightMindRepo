package org.leftright.controller;

import lombok.extern.slf4j.XSlf4j;
import org.leftright.model.Login;
import org.leftright.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@XSlf4j
public class LoginController {

    @Autowired
    LoginService loginServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login)
    {
        String ss = "";
        String role = login.getRole();

        if (role.equals("Manager")) {
            ss = role + " " + loginServiceImpl.login(login.getUserName(), login.getPassword()) + " Please assign Task to Employee/TeamMember";
        } else if (role.equalsIgnoreCase("Employee") || role.equalsIgnoreCase("Team Member")) {
            ss = role + " " + loginServiceImpl.login(login.getUserName(), login.getPassword()) + " Please check your assigned Task";
        } else {
            ss = role + ": You enter wrong Role Please choose From Manager| Employee ";
        }
        return ResponseEntity.ok(ss);
    }
}
