package br.com.springboot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.springboot.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	User findByUsername(String username);
}
