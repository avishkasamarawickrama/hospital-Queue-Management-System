package lk.ijse.hospital.service.impl;

import lk.ijse.hospital.dto.PatientDTO;
import lk.ijse.hospital.entity.Patient;
import lk.ijse.hospital.repo.PatientRepo;
import lk.ijse.hospital.repo.UserRepository;
import lk.ijse.hospital.service.PatientService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addPatient(PatientDTO patientDTO) {
        if (patientDTO.getFullName() == null || patientDTO.getFullName().trim().isEmpty()) {
            throw new IllegalArgumentException("Full name is required");
        }

        Patient patient = modelMapper.map(patientDTO, Patient.class);
        patientRepo.save(patient);
    }

    @Override
    public void updatePatient(PatientDTO patientDTO) {
        if (!patientRepo.existsById(patientDTO.getPatientId())) {
            throw new RuntimeException("Patient does not exist");
        }

        Patient patient = modelMapper.map(patientDTO, Patient.class);
        patientRepo.save(patient);
    }

    @Override
    public void deletePatient(String id) {
        patientRepo.deleteById(id);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return modelMapper.map(patientRepo.findAll(),
                new TypeToken<List<PatientDTO>>() {}.getType());
    }

    @Override
    public PatientDTO getPatientById(String id) {
        Patient patient = patientRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Patient does not exist")
        );
        return modelMapper.map(patient, PatientDTO.class);
    }

    @Override
    public String generateNextPatientId() {
        Patient lastPatient = patientRepo.findTopByOrderByPatientIdDesc();
        if (lastPatient == null) {
            return "PAT001"; // Initial ID if no patients exist
        }

        String lastId = lastPatient.getPatientId();
        String numericPart = lastId.replaceAll("\\D+", "");
        int nextNum = Integer.parseInt(numericPart) + 1;
        return String.format("PAT%03d", nextNum);
    }

    @Override
    public String generateNextUserId() {
        String lastUserId = patientRepo.getLastUserId();
        if (lastUserId == null) {
            return "USR001";
        }

        String numericPart = lastUserId.replaceAll("\\D+", "");
        int nextNum = Integer.parseInt(numericPart) + 1;
        return String.format("USR%03d", nextNum);
    }
}