package com.farukgenc.boilerplate.springboot.repository;

import com.farukgenc.boilerplate.springboot.model.AppointmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmenRepository extends JpaRepository<AppointmentRecord, Long> {

}
