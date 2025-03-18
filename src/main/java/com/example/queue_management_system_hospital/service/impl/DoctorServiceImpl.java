package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.DoctorDTO;
import com.example.queue_management_system_hospital.entity.Doctor;

import com.example.queue_management_system_hospital.repo.DoctorRepo;
import com.example.queue_management_system_hospital.repo.UserRepo;
import com.example.queue_management_system_hospital.service.DoctorService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addDoctor(DoctorDTO doctorDTO) {
        if (doctorRepo.existsById(doctorDTO.getDoctor_id())) {
            throw new RuntimeException("Doctor already exists");
        }
        doctorRepo.save(modelMapper.map(doctorDTO, Doctor.class));
    }


    @Override
    public void updateDoctor(DoctorDTO doctorDTO) {
        if (!doctorRepo.existsById(doctorDTO.getDoctor_id())) {
            throw new RuntimeException("Doctor does not exist");
        }
        doctorRepo.save(modelMapper.map(doctorDTO, Doctor.class));
    }



    @Override
    public void deleteDoctor(int id) {
        doctorRepo.deleteById(id);
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return modelMapper.map(doctorRepo.findAll(),
                new TypeToken<List<DoctorDTO>>() {}.getType());
    }

    @Override
    public List<Integer> getDoctorsId() {
        return doctorRepo.getDoctorsId();
    }

   /* @Override
    public CustomerDTO getCustomerById(String id) {
        return customerRepo.findNameById(id);
    }*/

    @Override
    public DoctorDTO getDoctorById(int id) {
        Doctor doctor = doctorRepo.findById(id).orElseThrow(() ->
                new RuntimeException("doctor does not exist")
        );
        return modelMapper.map(doctor, DoctorDTO.class);
    }


}
