package com.suchiit.model;

public class Student {
private int Sno;
private String sadd;
private String sname;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int sno, String sadd, String sname) {
	super();
	Sno = sno;
	this.sadd = sadd;
	this.sname = sname;
}
public int getSno() {
	return Sno;
}
public void setSno(int sno) {
	Sno = sno;
}
public String getSadd() {
	return sadd;
}
public void setSadd(String sadd) {
	this.sadd = sadd;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}

}
