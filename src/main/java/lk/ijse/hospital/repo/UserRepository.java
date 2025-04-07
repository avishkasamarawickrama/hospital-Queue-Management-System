package lk.ijse.hospital.repo;


import lk.ijse.hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,String> {

    User findByEmail(String userName);
    boolean existsByEmail(String userName);
    int deleteByEmail(String userName);


    @Query(value = "SELECT uid FROM systemuser ORDER BY CAST(SUBSTRING(uid, 4) AS UNSIGNED) DESC LIMIT 1", nativeQuery = true)
    String getLastUserId();

    @Query("SELECT MAX(CAST(SUBSTRING(u.uid, 4) AS int)) FROM User u WHERE u.uid LIKE 'USR%'")
    Integer findMaxNumericUserId();

    // Add this if you need to find max ID
    @Query(value = "SELECT MAX(CAST(SUBSTRING(uid, 4) AS int)) FROM systemuser WHERE uid LIKE 'USR%'", nativeQuery = true)
    Integer findMaxUserId();
}