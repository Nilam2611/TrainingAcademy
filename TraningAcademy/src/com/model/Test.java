package com.model;

public class Test {
public Test(int testid, String testname) {
		super();
		this.testid = testid;
		this.testname = testname;
	}
private int testid;
private String testname;
public int getTestid() {
	return testid;
}
public void setTestid(int testid) {
	this.testid = testid;
}
public String getTestname() {
	return testname;
}
public void setTestname(String testname) {
	this.testname = testname;
}
@Override
public String toString() {
	return "Test [testid=" + testid + ", testname=" + testname + "]";
}
}

