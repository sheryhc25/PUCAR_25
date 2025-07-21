package net.myFirstprogram.ems.repository;

import net.myFirstprogram.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
