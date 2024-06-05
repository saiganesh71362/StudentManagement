package com.stude.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RegisterInfo")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Register
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull(message = "First Name Mandatory")
	@Size(min = 1, max=20,message = "Fisrt name lessthan 20 characters bellow")
	private String firstName;
	@NotNull(message = "Last Name Mandatory")
	@Size(min = 1, max =20, message =  "Last name lessthan 20 characters bellow")
	private String lastName;
	@NotNull
	@Size(min = 1,max = 10,message = "Contact Details Must And Shouuld Be 10 Digits")
	private Long contactDetails;
	@NotNull
	@Size(min = 1, max = 20, message = "Email Length should be 20")
	@Email
	private String email;
	@NotNull
	@Size(min = 1,max = 20,message = "Using Password All Reqirements (a-z,A-Z,1-9,@#) also")
	private String passwaord;
	

}
