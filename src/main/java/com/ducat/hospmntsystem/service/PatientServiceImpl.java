package com.ducat.hospmntsystem.service;

import com.ducat.hospmntsystem.dto.DoctorOutputDto;
import com.ducat.hospmntsystem.dto.PatientInputDto;
import com.ducat.hospmntsystem.dto.PatientOutputDto;
import com.ducat.hospmntsystem.entity.Bill;
import com.ducat.hospmntsystem.entity.Doctor;
import com.ducat.hospmntsystem.entity.Patient;
import com.ducat.hospmntsystem.enums.DoctorCity;
import com.ducat.hospmntsystem.enums.DoctorSpeciality;
import com.ducat.hospmntsystem.enums.PatientSymptom;
import com.ducat.hospmntsystem.repository.BillRepository;
import com.ducat.hospmntsystem.repository.DoctorRepository;
import com.ducat.hospmntsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    BillRepository billRepository;

    @Override
    public PatientOutputDto getPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setCity(patient.getCity());
        patientOutputDto.setEmail(patient.getEmail());
        patientOutputDto.setPhone(patient.getPhone());
        patientOutputDto.setSymptom(patient.getSymptom());

        return patientOutputDto;
    }

    @Override
    public List<PatientOutputDto> getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();

        List<PatientOutputDto> patientOutputDtoList = new ArrayList<>();

        for(Patient patient : patientList) {
            PatientOutputDto patientOutputDto = new PatientOutputDto();

            patientOutputDto.setId(patient.getId());
            patientOutputDto.setName(patient.getName());
            patientOutputDto.setCity(patient.getCity());
            patientOutputDto.setEmail(patient.getEmail());
            patientOutputDto.setPhone(patient.getPhone());
            patientOutputDto.setSymptom(patient.getSymptom());

            patientOutputDtoList.add(patientOutputDto);
        }

        return patientOutputDtoList;
    }

    @Override
    public PatientOutputDto addPatient(PatientInputDto patientInputDto) {
        Patient patient = new Patient();

        patient.setName(patientInputDto.getName());
        patient.setCity(patientInputDto.getCity());
        patient.setEmail(patientInputDto.getEmail());
        patient.setPhone(patientInputDto.getPhone());
        patient.setSymptom(patientInputDto.getSymptom());

        Bill bill = new Bill();
        bill.setAmount(1000D);

        bill.setPatient(patient);

        patient.setBill(bill);

        patient = patientRepository.save(patient);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setCity(patient.getCity());
        patientOutputDto.setEmail(patient.getEmail());
        patientOutputDto.setPhone(patient.getPhone());
        patientOutputDto.setSymptom(patient.getSymptom());
        patientOutputDto.setBill(patient.getBill());

        return patientOutputDto;
    }

    @Override
    public PatientOutputDto updatePatient(Long id, PatientInputDto patientInputDto) {
        Patient patient = new Patient();

        patient.setId(id);
        patient.setName(patientInputDto.getName());
        patient.setCity(patientInputDto.getCity());
        patient.setEmail(patientInputDto.getEmail());
        patient.setPhone(patientInputDto.getPhone());
        patient.setSymptom(patientInputDto.getSymptom());

        patient = patientRepository.save(patient);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setCity(patient.getCity());
        patientOutputDto.setEmail(patient.getEmail());
        patientOutputDto.setPhone(patient.getPhone());
        patientOutputDto.setSymptom(patient.getSymptom());

        return patientOutputDto;
    }

    @Override
    public String removePatient(Long id) {
        String name = patientRepository.findById(id).orElse(null).getName();
        patientRepository.deleteById(id);

        return "Patient name: " + name + " and ID: " + id + " has been removed successfully!";
    }

    @Override
    public List<DoctorOutputDto> suggestDoctor(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) {
            throw new RuntimeException("Patient not found for ID: " + patientId);
        }

        PatientSymptom patientSymptom = patient.getSymptom();
        DoctorSpeciality doctorSpeciality = getSpeciality(patientSymptom);
        DoctorCity doctorCity = DoctorCity.valueOf(patient.getCity().toUpperCase());

        List<Doctor> doctorList = doctorRepository.findByCityAndSpeciality(doctorCity, doctorSpeciality);

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

    public DoctorSpeciality getSpeciality(PatientSymptom patientSymptom) {
        return switch(patientSymptom) {
            case ARTHRITIS, BACK_PAIN, TISSUE_INJURIES -> DoctorSpeciality.ORTHOPEDIC;
            case DYSMENORRHEA -> DoctorSpeciality.GYNECOLOGY;
            case SKIN_INFECTION, SKIN_BURN -> DoctorSpeciality.DERMATOLOGY;
            case EAR_PAIN -> DoctorSpeciality.ENT;
            default -> null;
        };
    }
}