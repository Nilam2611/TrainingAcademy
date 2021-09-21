package com.model;

public class Trainer {
public Trainer(int trainerid, String name, long mobileno) {
		super();
		this.trainerid = trainerid;
		this.name = name;
		this.mobileno = mobileno;
	}
private int trainerid ;
private String name;
private long mobileno;
public int getTrainerid() {
	return trainerid;
}
public void setTrainerid(int trainerid) {
	this.trainerid = trainerid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getMobileno() {
	return mobileno;
}
public void setMobileno(long mobileno) {
	this.mobileno = mobileno;
}
@Override
public String toString() {
	return "Trainer [trainerid=" + trainerid + ", name=" + name + ", mobileno=" + mobileno + "]";
}
}
