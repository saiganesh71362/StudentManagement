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

import com.stude.entity.Department;
import com.stude.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/newDepartment")
	public ResponseEntity<String> addDepartment(@RequestBody Department department) {
		String department2 = departmentService.addDepartment(department);
		return new ResponseEntity<String>(department2, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) throws Exception {
		Department departmentById = departmentService.getDepartmentById(id);

		return new ResponseEntity<Department>(departmentById, HttpStatus.OK);
	}

	@GetMapping("/getAllDepartments")
	public ResponseEntity<List<Department>> getAllDepartmentsById() {
		List<Department> allDepartmentsById = departmentService.getAllDepartmentsById();
		return new ResponseEntity<List<Department>>(allDepartmentsById, HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateDepartmentById(@RequestBody Department department,
			@PathVariable Integer id) {
		String updateDepartmentById = departmentService.updateDepartmentById(department, id);
		return new ResponseEntity<String>(updateDepartmentById, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartmentById(@PathVariable Integer id) throws Exception {
		String deleteDepartmentById = departmentService.deleteDepartmentById(id);

		return new ResponseEntity<String>(deleteDepartmentById, HttpStatus.OK);
	}

}
