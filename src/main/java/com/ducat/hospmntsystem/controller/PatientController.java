package com.ducat.hospmntsystem.controller;

import com.ducat.hospmntsystem.dto.DoctorOutputDto;
import com.ducat.hospmntsystem.dto.PatientInputDto;
import com.ducat.hospmntsystem.dto.PatientOutputDto;
import com.ducat.hospmntsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientOutputDto> getPatient(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.getPatient(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientOutputDto>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<PatientOutputDto> addPatient(@RequestBody PatientInputDto patientInputDto) {
        return new ResponseEntity<>(patientService.addPatient(patientInputDto), HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientOutputDto> updatePatient(@PathVariable Long id, @RequestBody PatientInputDto patientInputDto) {
        return new ResponseEntity<>(patientService.updatePatient(id, patientInputDto), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<String> removePatient(@RequestParam Long id) {
        return new ResponseEntity<>(patientService.removePatient(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/suggest-doctor/{id}")
    public ResponseEntity<List<DoctorOutputDto>> suggestDoctor(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.suggestDoctor(id), HttpStatusCode.valueOf(200));
    }

}