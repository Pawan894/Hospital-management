package com.tka.Hospital.Management.System.doclogin.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.Hospital.Management.System.doclogin.entity.Medicine;

@Repository
public interface MedicineRepositry extends JpaRepository<Medicine,Long>{

}
