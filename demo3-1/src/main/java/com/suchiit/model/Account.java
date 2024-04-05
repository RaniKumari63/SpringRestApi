package com.suchiit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="account99")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private long accno;
//@JsonProperty("full_name")
	@NotNull(message="Name should not be null")
private String accname;
	//@Email(message="Please enter the valid email.address")
	//private String email;
	
	private Long age=0L;
	@NotNull(message="department should not be null")
	private String department;
private String acctype;
//@JsonIgnore
@CreationTimestamp
@Column(updatable = false)
private Date createdBy;
@UpdateTimestamp
@Column(insertable = false)
private Date updatedBy;

}
