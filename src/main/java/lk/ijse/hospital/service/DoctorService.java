package lk.ijse.hospital.service;

import lk.ijse.hospital.dto.DoctorDTO;
import java.util.List;

public interface DoctorService {
    void addDoctor(DoctorDTO doctorDTO);
    void updateDoctor(DoctorDTO doctorDTO);
    void deleteDoctor(int id);
    List<DoctorDTO> getAllDoctors();
    List<Integer> getDoctorIds();
    DoctorDTO getDoctorById(int id);
    String generateNextUserId();
}