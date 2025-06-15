package com.ducat.hospmntsystem.service;

import com.ducat.hospmntsystem.dto.DoctorOutputDto;
import com.ducat.hospmntsystem.dto.PatientInputDto;
import com.ducat.hospmntsystem.dto.PatientOutputDto;

import java.util.List;

public interface PatientService {
    public PatientOutputDto getPatient(Long id);
    public List<PatientOutputDto> getAllPatients();
    public PatientOutputDto addPatient(PatientInputDto patientInputDto);
    public PatientOutputDto updatePatient(Long id,PatientInputDto patientInputDto);
    public String removePatient(Long id);
    public List<DoctorOutputDto> suggestDoctor(Long id);

}
