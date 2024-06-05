package com.stude.service;

import java.util.List;

import com.stude.entity.Department;

public interface DepartmentService {

	public String addDepartment(Department department);

	public Department getDepartmentById(Integer Id) throws Exception;

	public List<Department> getAllDepartmentsById();

	public String updateDepartmentById(Department department, Integer id);

	public String deleteDepartmentById(Integer id) throws Exception;
}
