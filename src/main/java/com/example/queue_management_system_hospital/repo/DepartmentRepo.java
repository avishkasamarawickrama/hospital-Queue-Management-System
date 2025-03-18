package com.example.queue_management_system_hospital.repo;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    @Query("SELECT d.department_id From Department d")
    List<Integer> getDepartmentsId();
    @Query("SELECT d.department_id FROM Department d") // Corrected JPQL query
    List<Integer> findAllDepartmentsIds();

    //    @Query("SELECT i.name,i.price,i.quantity FROM Item i WHERE i.code = :code")
//    ItemDTO findItemByCode(String code);
    @Query("SELECT new com.example.queue_management_system_hospital.dto.DepartmentDTO(d.department_id, d.department_name) FROM Department d WHERE d.department_id = :id") // Corrected JPQL query.code, i.name, i.price, i.qty) FROM Item i WHERE i.code = :code")
    DepartmentDTO findDepartmentsByIds(int id);


}
