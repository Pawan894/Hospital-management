package com.tka.Hospital.Management.System.doclogin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.Hospital.Management.System.doclogin.entity.Appointments;
import com.tka.Hospital.Management.System.doclogin.repositry.AppointmentRepositry;
@CrossOrigin(origins="https://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class AppointmentController {

	AppointmentRepositry appointmentRepositry;
	public AppointmentController (AppointmentRepositry appointmentRepositry) {
		super();
		this.appointmentRepositry=appointmentRepositry;
}
@PostMapping("/insert")
public Appointments createAppointments (@RequestBody Appointments appointment) {
	return appointmentRepositry.save(appointment);
}
@GetMapping
public List<Appointments> getAllAppointments(){
	return appointmentRepositry.findAll();
		
	}
@DeleteMapping("/appointments/{id}")
public ResponseEntity<Map<String,Boolean>>deleteAppointment(@PathVariable long  id){
	Appointments appointments=appointmentRepositry.findById(id).orElseThrow(()=> new AttributeNotFoundException("Appointment not found with id+"id));
	appointmentRepositry.delete(appointments);
	Map<String,Boolean> response=new HashMap<String,Boolean>();
	response.put("Deleted",Boolean.TRUE);
	
	return ResponseEntity.ok(response);
	
}
}

