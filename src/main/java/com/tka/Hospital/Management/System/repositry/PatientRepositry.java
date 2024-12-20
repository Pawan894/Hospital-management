package com.tka.Hospital.Management.System.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.Hospital.Management.System.controller.entity.Patient;

@Repository
public interface PatientRepositry extends JpaRepository<Patient, Long>{

	static com.tka.Hospital.Management.System.controllers.Patient save(
			com.tka.Hospital.Management.System.controllers.Patient patient) {
		
		return null;
	}

}
