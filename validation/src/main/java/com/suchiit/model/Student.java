package com.suchiit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value = {"createdAt","updatedAt"})
public class Student {
	
	@Id
	@GenericGenerator(name ="myGenerator",strategy = "increment")
	@GeneratedValue(generator = "myGenerator",strategy = GenerationType.AUTO)
	private int sid;
	
	@JsonProperty("fname")
	@NotNull
	@Size(min = 2,message = "First Name should have atleast 2 Characters")
	private String firstName;
	
	@NotNull
	@Size(min = 2,message = "Last Name should have atleast 2 Characters")
	@JsonProperty("lname")
	private String lastName;
	
	
	
//	@Pattern(regexp = "yyyy-mm-dd",message = "Date Formate Should be yyyy/mm/dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")
	@Temporal(TemporalType.DATE)
	private Date joiningDate;

	@Lob
	private String description;
	
	
	
	//  @Column(columnDefinition = "varchar(20) not null default 'PENDING'")
	  
	  @Enumerated(EnumType.STRING) 
	  private StudentTasks status;
	 
	  @Enumerated(EnumType.STRING)
	  private StudentGender gender;
	 	
	private String passPortNumber;
	
	@NotBlank(message = "Email is Mandatory")
	@Email
	private String email;
	
	
	@CreationTimestamp
	@Column(name = "created_at",updatable = false)
	private Date createdAt;
	@CreationTimestamp
	@Column(name = "updated_at",insertable= false)
	
	private Date updatedAt;
	
	private String filename;
	private String filetype;
	private String fileimagePath;
	
	

	
	
	

}
