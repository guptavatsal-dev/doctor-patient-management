package com.ducat.hospmntsystem.repository;

import com.ducat.hospmntsystem.dto.DoctorOutputDto;
import com.ducat.hospmntsystem.entity.Patient;
import com.ducat.hospmntsystem.enums.DoctorSpeciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
