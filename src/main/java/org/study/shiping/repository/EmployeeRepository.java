package org.study.shiping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.shiping.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
