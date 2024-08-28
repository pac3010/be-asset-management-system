package com.example.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.handler.Utils;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.dto.RegistrationDTO;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmailService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("api/account")
public class AccountRestController {
   @Autowired
   private EmployeeService employeeService;

   @Autowired
   private RoleService roleService;

   @Autowired
   private DepartmentService departmentService;

   @Autowired
   private UserService userService;

   @Autowired
   private EmailService emailService;

   @Autowired
   private PasswordEncoder passwordEncoder;

   @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegistrationDTO registrationDTO) {
        try {
            Role defaultRole = roleService.getRoleWithLowestLevel();
            Department department = departmentService.get(registrationDTO.getDepartment_id());
            Employee employee = new Employee(null, department, defaultRole, null, registrationDTO.getFirstname(), registrationDTO.getMiddlename(), registrationDTO.getLastname(), registrationDTO.getDob(), registrationDTO.getGender(), registrationDTO.getEmail(), registrationDTO.getPhone(), registrationDTO.getAddress());
            employeeService.save(employee);

            String guid = UUID.randomUUID().toString();
            String username = registrationDTO.getFirstname().toLowerCase() + "." + registrationDTO.getLastname().toLowerCase();
            User user = new User(null, employee, username, passwordEncoder.encode(registrationDTO.getPassword()), guid, false);
            userService.save(user);

            String subject = "Email Verification";
            String confirmationUrl = "http://localhost:8080/api/account/verify/" + user.getGuid();
            String message = "Click the link to verify your email: \n" + confirmationUrl;
            emailService.sendEmail(employee.getEmail(), subject, message);

            return Utils.generateResponseEntity(HttpStatus.OK,
                    "Registration Successful. A verification email has been sent to your email address.");
        } catch (Exception e) {
            return Utils.generateResponseEntity(HttpStatus.OK,
                    "Registration Failed: " + e.getMessage());
        }
    }

    @PostMapping("/verify/{guid}")
    public ResponseEntity<Object> verifyEmail(@PathVariable String guid) {
        User user = userService.verifyUser(guid);
        if (user != null) {
            user.setIsVerified(true);
            user.setGuid(null);
            userService.save(user);
            return Utils.generateResponseEntity(HttpStatus.OK, "Verification Account successfully");
        }
        return Utils.generateResponseEntity(HttpStatus.OK, "Verification Failed");
    }
}
