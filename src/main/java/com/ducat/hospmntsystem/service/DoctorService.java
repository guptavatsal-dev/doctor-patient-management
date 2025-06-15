package com.ducat.hospmntsystem.service;

import com.ducat.hospmntsystem.dto.DoctorInputDto;
import com.ducat.hospmntsystem.dto.DoctorOutputDto;
import com.ducat.hospmntsystem.enums.DoctorCity;
import com.ducat.hospmntsystem.enums.DoctorSpeciality;

import java.util.List;

public interface DoctorService {

    //Finding Doctor acc. to city and speciality
    List<DoctorOutputDto> findByCityAndSpeciality(DoctorCity doctorCity, DoctorSpeciality doctorSpeciality);
    public  List<DoctorOutputDto> findBySpecialityAndExperience(DoctorSpeciality doctorSpeciality,int experience);
    public DoctorOutputDto getDoctor(Long id);
    public List<DoctorOutputDto> getAllDoctors();
    public DoctorOutputDto addDoctor(DoctorInputDto doctorInputDto);
    public DoctorOutputDto updateDoctor(Long id, DoctorInputDto doctorInputDto);
    public String removeDoctor(Long id);
}
