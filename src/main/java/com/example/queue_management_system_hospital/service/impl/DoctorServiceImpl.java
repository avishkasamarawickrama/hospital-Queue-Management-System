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

    public void save(DoctorDTO doctorDTO) {
        if (doctorRepo.existsById(doctorDTO.getDoctor_id())) {

        throw new RuntimeException("doctor already exists");
    }
     doctorRepo.save(modelMapper.map(doctorDTO, Doctor.class));
    }
    @Override
    public DoctorDTO getById(int id){
        Optional<Doctor> optionalDoctor = doctorRepo.findById(id);
        if (optionalDoctor.isPresent()){
            return modelMapper.map(optionalDoctor.get(),DoctorDTO.class);

        }
        throw new RuntimeException("doctor not found ");
    }
    public List<DoctorDTO> getAll(){
        return modelMapper.map(
                doctorRepo.findAll(),
                new TypeToken<List<DoctorDTO>>(){}.getType()
        );
    }
    @Override
    public void update(DoctorDTO doctorDTO){
        if (!doctorRepo.existsById(doctorDTO.getDoctor_id())){

        throw new RuntimeException("doctor doesn't exists");
        }
        doctorRepo.save(modelMapper.map(doctorDTO, Doctor.class));

    }
    @Override
    public void delete(int id){
        if (!doctorRepo.existsById(id)){
            throw new RuntimeException("Doctor doesn't exist");
        }
        doctorRepo.deleteById(id);
    }

}
