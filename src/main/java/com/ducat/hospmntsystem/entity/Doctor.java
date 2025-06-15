package com.ducat.hospmntsystem.entity;

import com.ducat.hospmntsystem.enums.DoctorCity;
import com.ducat.hospmntsystem.enums.DoctorSpeciality;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "doctor")
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private DoctorCity city;

    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private DoctorSpeciality speciality;

    private int experience;

}