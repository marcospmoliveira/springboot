package br.com.springboot.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.springboot.model.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
	List<Student> findByNameIgnoreCaseContaining(String name);
}
