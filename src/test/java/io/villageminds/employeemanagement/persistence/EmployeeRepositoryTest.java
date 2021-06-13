package io.villageminds.employeemanagement.persistence;

import io.villageminds.employeemanagement.EmployeeManagementApplication;
import io.villageminds.employeemanagement.domain.Employee;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = EmployeeManagementApplication.class)
class EmployeeRepositoryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    void findAllEmployees() {
    }

    @Test
    void findByIdTest() {
        Employee employee = entityManager.find(Employee.class, 1L);
        assertEquals(1L, employee.getId());
    }

    @Test
    @Transactional
    //@DirtiesContext
    void insertTest() {
        Employee employee = new Employee("john", "doe", "jdoe@hotmail.com", "test");
        entityManager.persist(employee);
        assertNotNull(employee.getId());
    }

    @Test
    @Transactional
    void updateTest() {
        Employee employee = entityManager.find(Employee.class, 1L);
        employee.setFirstName("test");
        entityManager.merge(employee);

        Employee employeeUpdated = entityManager.find(Employee.class, 1L);
        assertEquals("test", employeeUpdated.getFirstName());
    }

    @Test
    void delete() {
    }
}