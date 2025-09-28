package com.integradorii.gimnasiov1.repository;

import com.integradorii.gimnasiov1.entity.Employee;
import com.integradorii.gimnasiov1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
