package com.stude.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stude.appconstants.AppConstants;
import com.stude.entity.Department;
import com.stude.entity.Student;
import com.stude.globalexceptionhandle.IdNotFoundException;
import com.stude.globalexceptionhandle.NotFoundException;
import com.stude.repository.DepartmentRepository;
import com.stude.repository.StudentRepository;
import com.stude.service.StudentService;

import jakarta.transaction.Transactional;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	@Transactional
    public String addStundnt(Student student) {
        Department department = student.getDepartment();
        if (department.getId() == null) {
            // Save the department if it is not already saved
            department = departmentRepository.save(department);
        }
        student.setDepartment(department); // Set the persisted department back to the student
        Student newStudent = studentRepository.save(student);

        if (newStudent != null && newStudent.getId() != null) {
            return AppConstants.RECORDCREATED_SUCCESSFULLY + newStudent.getId();
        } else {
            return AppConstants.RECORDCREATION_FAILD;
        }
    }



	@Override
	@Transactional
	public Student getStudentById(Integer id) throws Exception {
	    Optional<Student> byId = studentRepository.findById(id);
	    if (byId.isPresent()) {
	        return byId.get();
	    } else {
	        throw new IdNotFoundException(AppConstants.ID_NOTFOUND + id); // Id Not Found Exception
	    }
	}
	
//	NotFoundException

	@Override
	public List<Student> getAllStudents()
	{
		List<Student> all = studentRepository.findAll();
		
		return all;
	}

    @Transactional
    @Override
    public String updateStudentById(Student student, Integer id) {
        Student existingRecord = studentRepository.findById(id).orElse(null);
        if (existingRecord != null) {
            existingRecord.setName(student.getName());
            existingRecord.setEmail(student.getEmail());
            existingRecord.setContact(student.getContact());
            existingRecord.setDepartment(student.getDepartment());
            existingRecord.setAddress(student.getAddress());

            studentRepository.save(existingRecord);
            return AppConstants.RECORD_UPDATE_SUCCESS_FULLY + id;
        }

        return AppConstants.RECORD_UPDATE_FAILD+id;
    }

	@Override
	public String deleteStudent(Integer Id) throws Exception 
	{
		if(studentRepository.existsById(Id))
		{
		  studentRepository.deleteById(Id);
		  return AppConstants.RECORD_DELETE+Id;
		}
		else {
		 throw new NotFoundException(AppConstants.ID_NOTFOUND+Id); }  // Id Not Found Exception
	}

}
