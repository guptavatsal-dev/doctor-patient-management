package com.ducat.hospmntsystem.dto;

import com.ducat.hospmntsystem.enums.DoctorCity;
import com.ducat.hospmntsystem.enums.DoctorSpeciality;
import lombok.Data;

@Data
public class DoctorInputDto {
    private String name;
    private DoctorCity city;
    private String email;
    private String phone;
    private DoctorSpeciality speciality;
    private int experience;
}
