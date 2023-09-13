package com.tdtu.lab07.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tdtu.lab07.entities.Student;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long>{
	List<Student> findStudentByAgeIsGreaterThanEqual(int x);
	
	int countStudentByIeltsScoreEquals(double ieltsScore);
	
	@Query("SELECT s FROM Student s WHERE s.age >= ?1")
	List<Student> getAllStudentsByAgeGreaterThanX(int x);

	@Query("SELECT s FROM Student s WHERE s.ieltsScore = ?1")
	int countAllStudentsByIeltsScoreEqualsX(double x);

	@Query("SELECT s FROM Student s where UPPER(s.name) like UPPER(concat('%'," +"?1,'%'))")
	List<Student> getAllStudentsByNameContainingIgnoreCase(String word);
}
