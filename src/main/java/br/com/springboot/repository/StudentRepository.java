package br.com.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.springboot.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	List<Student> findByNameIgnoreCaseContaining(String name);
}
