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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table()
public class Account {

	@Id
	@GenericGenerator(name ="myGenerator",strategy = "increment")
	@GeneratedValue(generator = "myGenerator",strategy = GenerationType.AUTO)
	private int accid;
	@JsonProperty("accfname")
	@NonNull
	@Size(min = 2,message = "First Name should have atleast 2 Characters")
	private String accfname;
@JsonProperty("acclname")
@NotNull
@Size(min=2,message="Last Name should have atleast 2 Characters")
	private String acclname;
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")
@Temporal(TemporalType.DATE)
	private Date joiningDate;
@Lob
	private String description;
	private String passPortNumber;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	@Enumerated(EnumType.STRING)
	private AccountGender gender;
	
	
	@NotBlank(message = "Email is Mandatory")
	@Email
	private String email;
	@CreationTimestamp
	@Column(name = "created_at",updatable = false)
	private Date createdAt;
	@CreationTimestamp
	@Column(name = "updated_at",insertable= false)
	
	private Date updatedAt;
	
	
}
