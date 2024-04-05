package com.suchiit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


import lombok.Data;

@Data
@Entity

public class Tutorial {
	@Id
	@GenericGenerator(name="myGenerator",strategy="increment")
	@GeneratedValue(generator="myGenerator",strategy = GenerationType.AUTO)
private long id;
private String title;
private String description;
private boolean published;
}
