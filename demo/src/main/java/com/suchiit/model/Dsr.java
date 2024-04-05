package com.suchiit.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dsr {
	private int dsr_id;
	private String ename;
private String pname;
	private Date dsr_date;
	private String hrsworked;
	private String dsr_report;
	

	private Date submit_date;
	private boolean visibility;
}
