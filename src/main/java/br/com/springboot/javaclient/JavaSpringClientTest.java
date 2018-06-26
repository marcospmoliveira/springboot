package br.com.springboot.javaclient;

import java.util.List;

import br.com.springboot.model.Student;

public class JavaSpringClientTest {
	public static void main(String[] args) {
		
		Student studentPost = new Student();
		studentPost.setName("John Wick");
		studentPost.setEmail("john@pencil.com");
		JavaClientDAO dao = new JavaClientDAO();
//		System.out.println(dao.findById(9));
//		System.out.println(dao.listAll());
		List<Student> students = dao.listAll();
		System.out.println(students);
//		System.out.println(dao.save(studentPost));
	}
	
}
