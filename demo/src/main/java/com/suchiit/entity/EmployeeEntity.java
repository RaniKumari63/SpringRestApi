package com.suchiit.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.suchiit.model.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="emp")
public class EmployeeEntity {
	@Id
	@GenericGenerator(name="myGenerator", strategy="increment")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="myGenerator")
private long eid;
private String ename;
private String pname;
}