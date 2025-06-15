package com.ducat.hospmntsystem.repository;

import com.ducat.hospmntsystem.dto.DoctorOutputDto;
import com.ducat.hospmntsystem.entity.Doctor;
import com.ducat.hospmntsystem.enums.DoctorCity;
import com.ducat.hospmntsystem.enums.DoctorSpeciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    //DERIVED QUERY
    List<Doctor> findByCityAndSpeciality(DoctorCity doctorCity, DoctorSpeciality doctorSpeciality);

    List<Doctor> findBySpecialityAndExperience(DoctorSpeciality doctorSpeciality,int experience);


    //List<Doctor> findBySpeciality(DoctorSpeciality doctorSpeciality);


    //JPQL
    //@Query("SELECT d FROM Doctor d WHERE d.email = :email")
    //Doctor findByEmail(@Param("email") String email);

    //Native SQL Query
    //@Query(value = "SELECT * FROM doctor WHERE name LIKE %:name%", nativeQuery = true)
    //List<Doctor> findByNameLike(@Param("name") String name);

    //JPQL(Java persistence query language)
    //@Query("SELECT d from Doctor d where d.speciality=:speciality")
    //public List<Doctor> findBySpeciality(@Param("speciality") DoctorSpeciality doctorSpeciality);
}