package com.farukgenc.boilerplate.springboot.service;

import com.farukgenc.boilerplate.springboot.dto.AppointRequest;
import com.farukgenc.boilerplate.springboot.dto.AppointResponse;
import com.farukgenc.boilerplate.springboot.dto.DoctorResponse;
import com.farukgenc.boilerplate.springboot.model.AppointmentRecord;
import com.farukgenc.boilerplate.springboot.model.Doctor;
import com.farukgenc.boilerplate.springboot.model.Hospital;
import com.farukgenc.boilerplate.springboot.repository.AppointmenRepository;
import com.farukgenc.boilerplate.springboot.repository.DoctorRepository;
import com.farukgenc.boilerplate.springboot.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MedicalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmenRepository appointmenRepository;

    public List<Hospital> queryHospital(){

        return hospitalRepository.findAll();
    }

    public List<DoctorResponse> queryDoctor(int id){

        List<Doctor> list = doctorRepository.findByHospitalId(id);
        List<DoctorResponse> responseList = new ArrayList<>();
        for(Doctor doctor : list){
            DoctorResponse dr = new DoctorResponse();
            dr.setId(doctor.getId());
            dr.setDoctorName(doctor.getDoctorName());
            List<String> times = List.of(doctor.getAvTime().split(","));
            dr.setTimes(times);
            responseList.add(dr);
        }
        return responseList;
    }

    public AppointResponse appointMedical(int hospitalId, int doctorId, LocalDateTime appointDatetime, String username){

        AppointmentRecord ar = new AppointmentRecord();
        ar.setDoctorId((long) doctorId);
        ar.setHospitalId((long) hospitalId);
        ar.setAppointmentDatetime(appointDatetime);
        ar.setCreateTime(LocalDateTime.now());
        ar.setUsername(username);
        appointmenRepository.save(ar);
        return new AppointResponse("1");
    }

}
