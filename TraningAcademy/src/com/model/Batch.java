package com.model;

public class Batch {
public Batch(int batchid, String batchname, int trainerid) {
		super();
		this.batchid = batchid;
		this.batchname = batchname;
		this.trainerid = trainerid;
	}
private int batchid;
private String batchname;
private int trainerid;
public int getBatchid() {
	return batchid;
}
public void setBatchid(int batchid) {
	this.batchid = batchid;
}
public String getBatchname() {
	return batchname;
}
public void setBatchname(String batchname) {
	this.batchname = batchname;
}
public int getTrainerid() {
	return trainerid;
}
public void setTrainerid(int trainerid) {
	this.trainerid = trainerid;
}
@Override
public String toString() {
	return "Batch [batchid=" + batchid + ", batchname=" + batchname + ", trainerid=" + trainerid + "]";
}

}

