package com.stude.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stude.entity.Student;

@Service
public interface StudentService {

	public String addStundnt(Student student);

	public Student getStudentById(Integer Id) throws Exception;

	public List<Student> getAllStudents();

	public String updateStudentById(Student student, Integer id);

	public String deleteStudent(Integer Id) throws Exception;
}
