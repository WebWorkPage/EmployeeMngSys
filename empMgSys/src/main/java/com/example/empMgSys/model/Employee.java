package com.example.empMgSys.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@AllArgsConstructor

@Entity
@Table(name="employees")

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email", nullable=false, unique=true)
	private String emailId;
	
	public Employee() {
	}
	
	 public Employee(String emailId, String firstName, String lastName) {
		    this.emailId = emailId;
	        this.firstName = firstName;
	        this.lastName = lastName;
	    }
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setEmailId(String email) {
		this.emailId = email;
	}
	
	public String getEmailId() {
		return emailId;
	}
}
