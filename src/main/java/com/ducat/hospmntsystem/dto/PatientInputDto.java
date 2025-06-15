package com.ducat.hospmntsystem.dto;

import com.ducat.hospmntsystem.enums.PatientSymptom;
import lombok.Data;

@Data
public class PatientInputDto {
    private String name;
    private String city;
    private String email;
    private String phone;
    private PatientSymptom symptom;
}
