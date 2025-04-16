package lk.ijse.hospital.repo;

import lk.ijse.hospital.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    List<Payment> findByAppointmentAppointmentId(Long appointmentId);
}