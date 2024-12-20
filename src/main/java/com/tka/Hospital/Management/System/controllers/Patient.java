package com.tka.Hospital.Management.System.controllers;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.Hospital.Management.System.repositry.PatientRepositry;

@RestController
@RequestMapping("/api/v1")
public class Patient {

	
	private PatientRepositry patientRepositry;

	public Patient(PatientRepositry patientRepositry) {
		super();
		this.patientRepositry = patientRepositry;
	}
	@PostMapping("/insert")
	public Patient createPatient(@RequestBody Patient patient) {
		
		return PatientRepositry.save(patient);
	}
	@GetMapping("/patients")
	public List<com.tka.Hospital.Management.System.controller.entity.Patient> getAllPatient(){
		
		return patientRepositry.findAll();
	}
	@GetMapping("patients/{id}")
	public ResponseEntity<com.tka.Hospital.Management.System.controller.entity.Patient> getPatientById(@PathVariable long id) throws AttributeNotFoundException{
		 com.tka.Hospital.Management.System.controller.entity.Patient patient=patientRepositry.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient not found with id:"+id));
		return ResponseEntity.ok(patient);
	}
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Map<String,Boolean>>deletePatient(@PathVariable long id){
		
		Patient patient=patientRepositry.findById(id).orElseThrow(()->new AttributeNotFoundException(("Patient not found with id:"+id));
				patientRepositry.delete(patient);
				Map<String,Boolean> response=new HashMap<String,Boolean>();
				response.put("Deleted",Boolean.TRUE);
				
				return ResponseEntity.ok(response);
	}
	@PutMapping("/patient/{id}")
	public ResponseEntity<Patient> updatePatientById( @PathVariable long id, @RequestBody Patient patientDetails){
		Patient patient=patientRepositry.findById(id).orElseThrow(()->new AttributeNotFoundException(("Patient not found with id:"+id));
	
		patient.setAge(patientDetails.getAge());
		patient.setName(patientDetails.getName());
		patient.setBlood(patientDetails.getBlood());
		patient.setDose(patientDetails.getDose());
		patient.setFees(patientDetails.getDose());
		patient.setPrescription(patientDetails.getPrescription());
		patient.setUrgency(patientDetails.getUrgency());
		
		
		Patient savedPatient=patientRepositry.save(patient);
		return ResponseEntity.ok(savedPatient);
	}
}
