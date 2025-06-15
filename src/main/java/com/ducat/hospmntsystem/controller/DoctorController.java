package com.ducat.hospmntsystem.controller;


import com.ducat.hospmntsystem.dto.DoctorInputDto;
import com.ducat.hospmntsystem.dto.DoctorOutputDto;
import com.ducat.hospmntsystem.entity.Doctor;
import com.ducat.hospmntsystem.enums.DoctorCity;
import com.ducat.hospmntsystem.enums.DoctorSpeciality;
import com.ducat.hospmntsystem.repository.DoctorRepository;
import com.ducat.hospmntsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {



    @Autowired
    DoctorService doctorService;

    @GetMapping("/search")
    public ResponseEntity<?> searchDoctor(@RequestParam DoctorCity doctorCity, @RequestParam DoctorSpeciality doctorSpeciality){
        return new ResponseEntity<>(doctorService.findByCityAndSpeciality(doctorCity,doctorSpeciality),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/searchDoctors")
    public ResponseEntity<?> searchDoctors(@RequestParam DoctorSpeciality doctorSpeciality, @RequestParam int experience){
        return new ResponseEntity<>(doctorService.findBySpecialityAndExperience(doctorSpeciality,experience),HttpStatusCode.valueOf(200));
    }



    /*
    @GetMapping("/searchByCity")
    public ResponseEntity<?> searchDoctor(@RequestParam DoctorSpeciality doctorSpeciality){
        List<Doctor> doctor=doctorRepository.findBySpeciality(doctorSpeciality);
        if(!doctor.isEmpty()) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Not Found",HttpStatus.OK);
        }
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<DoctorOutputDto> getDoctor(@PathVariable Long id) {
        return new ResponseEntity<>(doctorService.getDoctor(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<DoctorOutputDto>> getAllDoctors() {
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<DoctorOutputDto> addDoctor(@RequestBody DoctorInputDto doctorInputDto) {
        return new ResponseEntity<>(doctorService.addDoctor(doctorInputDto), HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorOutputDto> updateDoctor(@PathVariable Long id, @RequestBody DoctorInputDto doctorInputDto) {
        return new ResponseEntity<>(doctorService.updateDoctor(id, doctorInputDto), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<String> removeDoctor(@RequestParam Long id) {
        return new ResponseEntity<>(doctorService.removeDoctor(id), HttpStatusCode.valueOf(200));
    }
}