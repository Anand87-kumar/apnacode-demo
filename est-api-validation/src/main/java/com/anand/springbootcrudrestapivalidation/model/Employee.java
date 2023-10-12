	package com.anand.springbootcrudrestapivalidation.model;
	
	import jakarta.persistence.*;
	import jakarta.validation.constraints.Email;
	import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
	import jakarta.validation.constraints.Size;
	
	@Entity
	@Table(name = "employees")
	public class Employee {
	
		private long id;
	
		@NotEmpty
		@Size(min = 4, message = "Username must be min of 4 characters")
		private String firstName;
		
		@NotNull
		@Size(min = 4, message = "Last Name should have atleast 4 characters")
		private String lastName;
		
		@Email(message = "Email address is not valid!!")
		@NotBlank
		private String emailId;
		
		@NotNull
		@Size(min = 3, max= 10, message = "Passport should have atleast 8 characters")
		private String passportNumber;
	
		public Employee() {
	
		}
	
		public Employee(String firstName, String lastName, String emailId) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailId = emailId;
		}
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public long getId() {
			return id;
		}
	
		public void setId(long id) {
			this.id = id;
		}
	
		@Column(name = "first_name", nullable = false)
		public String getFirstName() {
			return firstName;
		}
	
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
	
		@Column(name = "last_name", nullable = false)
		public String getLastName() {
			return lastName;
		}
	
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	
		@Column(name = "email_address", nullable = false)
		public String getEmailId() {
			return emailId;
		}
	
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
	
		@Column(name = "passport_number", nullable = false)
		public String getPassportNumber() {
			return passportNumber;
		}
	
		public void setPassportNumber(String passportNumber) {
			this.passportNumber = passportNumber;
		}
	
	}
