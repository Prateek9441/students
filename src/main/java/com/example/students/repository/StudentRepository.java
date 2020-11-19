package com.example.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.students.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	
	@Query(value="SELECT * FROM Student s WHERE s.rollNumber = :rollNo", nativeQuery = true)
	public Student findByRollNumber(@Param("rollNo") int rollNo);
	
}
