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
	
	public Register() {}
	public Register(Integer id,
			@NotNull(message = "First Name Mandatory") @Size(min = 1, max = 20, message = "Fisrt name lessthan 20 characters bellow") String firstName,
			@NotNull(message = "Last Name Mandatory") @Size(min = 1, max = 20, message = "Last name lessthan 20 characters bellow") String lastName,
			@NotNull @Size(min = 1, max = 10, message = "Contact Details Must And Shouuld Be 10 Digits") Long contactDetails,
			@NotNull @Size(min = 1, max = 20, message = "Email Length should be 20") @Email String email,
			@NotNull @Size(min = 1, max = 20, message = "Using Password All Reqirements (a-z,A-Z,1-9,@#) also") String passwaord) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactDetails = contactDetails;
		this.email = email;
		this.passwaord = passwaord;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(Long contactDetails) {
		this.contactDetails = contactDetails;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswaord() {
		return passwaord;
	}
	public void setPasswaord(String passwaord) {
		this.passwaord = passwaord;
	}
	
	
	
	
	

}
