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

import com.stude.entity.Register;
import com.stude.service.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	@PostMapping("/newRegister")
	public ResponseEntity<String> newRegister(@RequestBody Register register) {
		String newRegister = registerService.newRegister(register);
		return new ResponseEntity<String>(newRegister, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Register> getRegister(@PathVariable Integer id) throws Exception {
		Register register = registerService.getRegister(id);
		return new ResponseEntity<Register>(register, HttpStatus.OK);
	}

	@GetMapping("/allRegisters")
	public ResponseEntity<List<Register>> getAllRegisters() {

		List<Register> allRegisters = registerService.getAllRegisters();

		return new ResponseEntity<List<Register>>(allRegisters, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateRegister(@RequestBody Register register, @PathVariable Integer id) {
		String updateRegister = registerService.updateRegister(register, id);
		return new ResponseEntity<String>(updateRegister, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRegister(@PathVariable Integer id) throws Exception {
		String deleteRegister = registerService.deleteRegister(id);
		return new ResponseEntity<String>(deleteRegister, HttpStatus.OK);

	}

}
