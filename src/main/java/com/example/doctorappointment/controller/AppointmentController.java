package com.example.doctorappointment.controller;

import com.example.doctorappointment.model.Appointment;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final List<Appointment> appointments = new ArrayList<>();

    // Book an appointment
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment bookAppointment(@Valid @RequestBody Appointment appointment) {

        appointment.setId((long) (appointments.size() + 1));
        appointments.add(appointment);

        return appointment;
    }

    // View all appointments
    @GetMapping
    public List<Appointment> getAppointments() {
        return appointments;
    }
}