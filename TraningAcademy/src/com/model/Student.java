package com.model;

public class Student {
public Student(int studentid, String sname, long mobileno, int batchid) {
		super();
		this.studentid = studentid;
		this.sname = sname;
		this.mobileno = mobileno;
		this.batchid = batchid;
	}
private int studentid ;
private String sname ;
private long mobileno;
private int batchid;
public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public long getMobileno() {
	return mobileno;
}
public void setMobileno(long mobileno) {
	this.mobileno = mobileno;
}
public int getBatchid() {
	return batchid;
}
public void setBatchid(int batchid) {
	this.batchid = batchid;
}
@Override
public String toString() {
	return "Student [studentid=" + studentid + ", sname=" + sname + ", mobileno=" + mobileno + ", batchid=" + batchid
			+ "]";
}
}
