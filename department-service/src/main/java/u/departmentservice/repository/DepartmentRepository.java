package u.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import u.departmentservice.entity.Department;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDepartmentCode(String departmentCode);
}
