package lk.ijse.hospital.service.impl;

import lk.ijse.hospital.dto.DoctorDTO;
import lk.ijse.hospital.entity.Doctor;
import lk.ijse.hospital.repo.DoctorRepo;
import lk.ijse.hospital.repo.UserRepository;
import lk.ijse.hospital.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addDoctor(DoctorDTO doctorDTO) {
        if (doctorDTO.getFullName() == null || doctorDTO.getFullName().trim().isEmpty()) {
            throw new IllegalArgumentException("Full name is required");
        }

        Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
        // No need for UUID conversion anymore
        doctorRepo.save(doctor);
    }

    @Override
    public void updateDoctor(DoctorDTO doctorDTO) {
        if (!doctorRepo.existsById(doctorDTO.getDoctorId())) {
            throw new RuntimeException("Doctor does not exist");
        }

        Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
        doctor.setUserIdFromString(doctorDTO.getUserId());
        doctorRepo.save(doctor);
    }

    @Override
    public void deleteDoctor(int id) {
        doctorRepo.deleteById(id);
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return modelMapper.map(doctorRepo.findAll(),
                new TypeToken<List<DoctorDTO>>() {
                }.getType());
    }

    @Override
    public List<Integer> getDoctorIds() {
        return doctorRepo.getDoctorIds();
    }

    @Override
    public DoctorDTO getDoctorById(int id) {
        Doctor doctor = doctorRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Doctor does not exist")
        );
        return modelMapper.map(doctor, DoctorDTO.class);
    }

    @Override
    public String generateNextUserId() {
        // Get the last doctor to determine next ID
        Doctor lastDoctor = doctorRepo.findTopByOrderByDoctorIdDesc();
        if (lastDoctor == null) {
            return "USR001"; // Initial ID if no doctors exist
        }

        // Extract numeric part and increment
        String lastId = lastDoctor.getUserId();
        String numericPart = lastId.replaceAll("\\D+", "");
        int nextNum = Integer.parseInt(numericPart) + 1;

        // Format with leading zeros
        return String.format("USR%03d", nextNum);
    }
}