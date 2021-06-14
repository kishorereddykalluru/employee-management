package io.villageminds.employeemanagement.persistence;

import io.villageminds.employeemanagement.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
