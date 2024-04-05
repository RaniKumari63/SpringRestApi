package com.suchiit.entity;

import java.sql.Date;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.suchiit.model.Employee;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dsr")
public class DsrEntity {
	@Id
	@GenericGenerator(name = "MyGenerator", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MyGenerator")
	private int dsr_id;
	private String ename;

private String pname;
	private Date dsr_date;
	private String hrsworked;

	private String dsr_report;

	private Date submit_date;

	private boolean visibility;

}
