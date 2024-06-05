package com.stude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stude.entity.Student;
import com.stude.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/newStudent")
	public ResponseEntity<String> addStundnt(@RequestBody Student student) {
		String stundnt = studentService.addStundnt(student);
		return new ResponseEntity<String>(stundnt, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id) throws Exception {
		Student studentById = studentService.getStudentById(id);
		return new ResponseEntity<Student>(studentById, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> allStudents = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
	}

	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<String> updateStudentById(@RequestBody Student student, @PathVariable Integer id) {
		String updateStudentById = studentService.updateStudentById(student, id);
		return new ResponseEntity<String>(updateStudentById, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) throws Exception {
		String deleteStudent = studentService.deleteStudent(id);
		return new ResponseEntity<String>(deleteStudent, HttpStatus.ACCEPTED);
	}

}
