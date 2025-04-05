package lk.ijse.hospital.repo;

import lk.ijse.hospital.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, String> {
    @Query("SELECT d.departmentId FROM Department d")
    List<String> getAllDepartmentIds();

    @Query("SELECT d FROM Department d WHERE d.departmentId = :id")
    Department findDepartmentById(@Param("id") String id);

    @Query(value = "SELECT department_id FROM department ORDER BY department_id DESC LIMIT 1", nativeQuery = true)
    String getLastDepartmentId();
}