package net.myFirstprogram.ems.service;

import lombok.AllArgsConstructor;
import net.myFirstprogram.ems.dto.EmployeeDto;
import net.myFirstprogram.ems.entity.Employee;
import net.myFirstprogram.ems.mapper.EmployeeMapper;
import net.myFirstprogram.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeDto createNewEmployee(EmployeeDto employeeDto){
        Employee newEmployee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(newEmployee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
