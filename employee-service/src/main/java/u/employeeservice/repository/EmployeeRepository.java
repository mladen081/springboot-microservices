package u.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import u.employeeservice.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}
