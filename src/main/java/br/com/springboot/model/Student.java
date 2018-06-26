package br.com.springboot.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Student extends AbstractEntity {
	@NotEmpty(message = "O Campo Nome é Obrigatório!")
	private String name;
	@NotEmpty(message = "O Campo Email é Obrigatório!")
	@Email
	private String email;

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
