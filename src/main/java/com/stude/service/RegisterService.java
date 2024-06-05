package com.stude.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stude.entity.Register;

@Service
public interface RegisterService {
	public String newRegister(Register register);

	public Register getRegister(Integer id) throws Exception;

	public List<Register> getAllRegisters();

	public String updateRegister(Register register, Integer id);

	public String deleteRegister(Integer id) throws Exception;

}
