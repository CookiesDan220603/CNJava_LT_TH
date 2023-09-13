package com.tdtu.lab07.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tdtu.lab07.entities.Student;

@Repository
public interface IStudentRepositoryPagination extends PagingAndSortingRepository<Student, Long> {
	List<Student> findAllByOrderByAgeDescIeltsScoreAsc();
}
