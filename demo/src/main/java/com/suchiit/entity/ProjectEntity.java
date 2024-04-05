package com.suchiit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="project65")
public class ProjectEntity {
	@Id
	@GenericGenerator(name="myGenerator", strategy="increment")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="myGenerator")
	@Column(name="pid")
	private long pid;
	@Column(name="pname")
	private String pname;

}
