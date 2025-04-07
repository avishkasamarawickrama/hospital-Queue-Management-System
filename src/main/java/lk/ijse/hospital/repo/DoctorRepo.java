package lk.ijse.hospital.repo;

import lk.ijse.hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    @Query("SELECT d.doctorId FROM Doctor d")
    List<Integer> getDoctorIds();

    @Query(value = "SELECT uid FROM systemuser ORDER BY uid DESC LIMIT 1", nativeQuery = true)
    String getLastUserId();
    boolean existsByFullName(String fullName);

    @Query("SELECT d FROM Doctor d ORDER BY d.doctorId DESC LIMIT 1")
    Doctor findTopByOrderByDoctorIdDesc();


}