package net.myFirstprogram.ems.controller;

import lombok.AllArgsConstructor;
import net.myFirstprogram.ems.dto.EmployeeDto;
import net.myFirstprogram.ems.service.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeServiceImpl employeeService;

    public ResponseEntity<EmployeeDto> createNewEmployee (@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createNewEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
}
