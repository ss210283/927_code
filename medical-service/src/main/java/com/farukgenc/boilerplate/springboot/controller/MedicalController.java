package com.farukgenc.boilerplate.springboot.controller;

import com.farukgenc.boilerplate.springboot.dto.AppointRequest;
import com.farukgenc.boilerplate.springboot.dto.AppointResponse;
import com.farukgenc.boilerplate.springboot.dto.DoctorResponse;
import com.farukgenc.boilerplate.springboot.model.Hospital;
import com.farukgenc.boilerplate.springboot.service.MedicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medical")
public class MedicalController {

    @Autowired
    private MedicalService medicalService;

    @GetMapping("/queryHospital")
    public ResponseEntity<List<Hospital>> queryHospital() {

        List<Hospital> list = medicalService.queryHospital();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/queryDoctor")
    public ResponseEntity<List<DoctorResponse>> queryDoctor(@RequestParam("id") int id) {

        List<DoctorResponse> list = medicalService.queryDoctor(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/appointMedical")
    public ResponseEntity<AppointResponse> appointMedical(@RequestParam("hospitalId") int hospitalId,
                                                          @RequestParam("doctorId") int doctorId,
                                                          @RequestParam("appointDatetime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime appointDatetime,
                                                          @RequestParam("username") String username) {

        AppointResponse appointResponse = medicalService.appointMedical(hospitalId,doctorId,appointDatetime,username);
        return ResponseEntity.ok(appointResponse);
    }
}

