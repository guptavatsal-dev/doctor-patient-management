package com.ducat.hospmntsystem.service;

import com.ducat.hospmntsystem.dto.DoctorInputDto;
import com.ducat.hospmntsystem.dto.DoctorOutputDto;
import com.ducat.hospmntsystem.entity.Doctor;
import com.ducat.hospmntsystem.enums.DoctorCity;
import com.ducat.hospmntsystem.enums.DoctorSpeciality;
import com.ducat.hospmntsystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<DoctorOutputDto> findBySpecialityAndExperience(DoctorSpeciality doctorSpeciality,int experience){
        List<Doctor> doctorList = doctorRepository.findBySpecialityAndExperience(doctorSpeciality,experience);

        List<DoctorOutputDto> doctorOutputDtoList = new ArrayList<>();

        for (Doctor doctor : doctorList) {
            DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

            doctorOutputDto.setId(doctor.getId());
            doctorOutputDto.setName(doctor.getName());
            doctorOutputDto.setCity(doctor.getCity());
            doctorOutputDto.setEmail(doctor.getEmail());
            doctorOutputDto.setPhone(doctor.getPhone());
            doctorOutputDto.setSpeciality(doctor.getSpeciality());
            doctorOutputDto.setExperience(doctor.getExperience());

            doctorOutputDtoList.add(doctorOutputDto);
        }

        return doctorOutputDtoList;
    }


    @Override
    public List<DoctorOutputDto> findByCityAndSpeciality(DoctorCity doctorCity, DoctorSpeciality doctorSpeciality) {
        List<Doctor> doctorList = doctorRepository.findByCityAndSpeciality(doctorCity,doctorSpeciality);

        List<DoctorOutputDto> doctorOutputDtoList = new ArrayList<>();

        for (Doctor doctor : doctorList) {
            DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

            doctorOutputDto.setId(doctor.getId());
            doctorOutputDto.setName(doctor.getName());
            doctorOutputDto.setCity(doctor.getCity());
            doctorOutputDto.setEmail(doctor.getEmail());
            doctorOutputDto.setPhone(doctor.getPhone());
            doctorOutputDto.setSpeciality(doctor.getSpeciality());

            doctorOutputDtoList.add(doctorOutputDto);
        }
        return doctorOutputDtoList;
    }


    @Override
    public DoctorOutputDto getDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);

        DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

        doctorOutputDto.setId(doctor.getId());
        doctorOutputDto.setName(doctor.getName());
        doctorOutputDto.setCity(doctor.getCity());
        doctorOutputDto.setEmail(doctor.getEmail());
        doctorOutputDto.setPhone(doctor.getPhone());
        doctorOutputDto.setSpeciality(doctor.getSpeciality());

        return doctorOutputDto;
    }

    @Override
    public List<DoctorOutputDto> getAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();

        List<DoctorOutputDto> doctorOutputDtoList = new ArrayList<>();

        for(Doctor doctor : doctorList) {
            DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

            doctorOutputDto.setId(doctor.getId());
            doctorOutputDto.setName(doctor.getName());
            doctorOutputDto.setCity(doctor.getCity());
            doctorOutputDto.setEmail(doctor.getEmail());
            doctorOutputDto.setPhone(doctor.getPhone());
            doctorOutputDto.setSpeciality(doctor.getSpeciality());

            doctorOutputDtoList.add(doctorOutputDto);
        }

        return doctorOutputDtoList;
    }

    @Override
    public DoctorOutputDto addDoctor(DoctorInputDto doctorInputDto) {
        Doctor doctor = new Doctor();

        doctor.setName(doctorInputDto.getName());
        doctor.setCity(doctorInputDto.getCity());
        doctor.setEmail(doctorInputDto.getEmail());
        doctor.setPhone(doctorInputDto.getPhone());
        doctor.setSpeciality(doctorInputDto.getSpeciality());

        doctor = doctorRepository.save(doctor);

        DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

        doctorOutputDto.setId(doctor.getId());
        doctorOutputDto.setName(doctor.getName());
        doctorOutputDto.setCity(doctor.getCity());
        doctorOutputDto.setEmail(doctor.getEmail());
        doctorOutputDto.setPhone(doctor.getPhone());
        doctorOutputDto.setSpeciality(doctor.getSpeciality());

        return doctorOutputDto;
    }

    @Override
    public DoctorOutputDto updateDoctor(Long id, DoctorInputDto doctorInputDto) {
        Doctor doctor = new Doctor();

        doctor.setId(id);
        doctor.setName(doctorInputDto.getName());
        doctor.setCity(doctorInputDto.getCity());
        doctor.setEmail(doctorInputDto.getEmail());
        doctor.setPhone(doctorInputDto.getPhone());
        doctor.setSpeciality(doctorInputDto.getSpeciality());

        doctor = doctorRepository.save(doctor);

        DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

        doctorOutputDto.setId(doctor.getId());
        doctorOutputDto.setName(doctor.getName());
        doctorOutputDto.setCity(doctor.getCity());
        doctorOutputDto.setEmail(doctor.getEmail());
        doctorOutputDto.setPhone(doctor.getPhone());
        doctorOutputDto.setSpeciality(doctor.getSpeciality());

        return doctorOutputDto;

    }

    @Override
    public String removeDoctor(Long id) {
        String name = doctorRepository.findById(id).orElse(null).getName();
        doctorRepository.deleteById(id);

        return "Doctor name: " + name + " and ID: " + id + " has been removed successfully!";
    }
}