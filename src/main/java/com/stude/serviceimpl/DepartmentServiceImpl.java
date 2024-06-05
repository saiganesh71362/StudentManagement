package com.stude.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stude.appconstants.AppConstants;
import com.stude.entity.Department;
import com.stude.globalexceptionhandle.IdNotFoundException;
import com.stude.globalexceptionhandle.NotFoundException;
import com.stude.repository.DepartmentRepository;
import com.stude.service.DepartmentService;

import jakarta.transaction.Transactional;
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	@Transactional
	public String addDepartment(Department department) {
	    Integer id = department.getId();
	    
	    if (id == null) {
	        // New department, save it
	        Department newDepartment = departmentRepository.save(department);
	        if (newDepartment != null && newDepartment.getId() != null) {
	            return AppConstants.RECORDCREATED_SUCCESSFULLY + newDepartment.getId();
	        } else {
	            return AppConstants.RECORDCREATION_FAILD;
	        }
	    } else {
	        // Existing department, check if it already exists
	        Optional<Department> existingDepartment = departmentRepository.findById(id);
	        if (existingDepartment.isPresent()) {
	            return AppConstants.RECORD_ALRADY_EXISTS + id;
	        } else {
	            // This case is unlikely if id was null initially but handling just in case
	            Department newDepartment = departmentRepository.save(department);
	            if (newDepartment != null && newDepartment.getId() != null) {
	                return AppConstants.RECORDCREATED_SUCCESSFULLY + newDepartment.getId();
	            } else {
	                return AppConstants.RECORDCREATION_FAILD;
	            }
	        }
	    }
	}

	@Override
	@Transactional
	public Department getDepartmentById(Integer Id) throws Exception {
		Optional<Department> byId = departmentRepository.findById(Id);
		if (byId.isPresent()) {
			return byId.get();
		} else {
			throw new IdNotFoundException(AppConstants.ID_NOTFOUND + byId);
		}
	}

	@Override
	@Transactional
	public List<Department> getAllDepartmentsById() {
		List<Department> all = departmentRepository.findAll();
		return all;
	}

	@Override
	@Transactional
    public String updateDepartmentById(Department department, Integer id) {
        Department existing = departmentRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(department.getName());
            departmentRepository.save(existing);
            return AppConstants.RECORD_UPDATE_SUCCESS_FULLY + id;
        }

        return AppConstants.RECORD_UPDATE_FAILD+id;
    }

	@Override
	@Transactional
	public String deleteDepartmentById(Integer id) throws Exception {
		if (departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
			return AppConstants.RECORD_DELETE + id;
		} else {
			throw new NotFoundException(AppConstants.ID_NOTFOUND + id);

		}
	}

}
