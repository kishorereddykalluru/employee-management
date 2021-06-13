package io.villageminds.employeemanagement.persistence;

import io.villageminds.employeemanagement.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Slf4j
@Transactional
public class EmployeeRepository {

    private final EntityManager entityManager;

    public EmployeeRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Employee> findAllEmployees(){
        return entityManager.createQuery("Select * from Employee e", Employee.class).getResultList();
    }

    public Employee findById(Long id){
        Employee employee = entityManager.find(Employee.class, id);
        log.info("Employee -> {}", employee);
        return employee;
    }

    public void insert(){
        Employee employee = new Employee("John", "Doe", "jdoe@hotmail.com", "Test");
        entityManager.persist(employee);
        log.info("New employee -> {}", employee);
    }

    public void update(){
        Employee employee = findById(1L);
        employee.setFirstName("Jane");
        entityManager.merge(employee);

        log.info("Updated employee -> {}", employee);
    }

    public void delete(){
        Employee employee = findById(1L);
        entityManager.remove(employee);
    }

}
