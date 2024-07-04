package com.batch.dto;

import com.opencsv.bean.CsvBindByName;

import lombok.Builder;

@Builder
public class StudentDto {
@CsvBindByName(column = "fname")
 private String fname;
@CsvBindByName(column = "lname")
 private String lname;
@CsvBindByName(column = "age")
 private int age;
public StudentDto() {
	super();
	// TODO Auto-generated constructor stub
}
public StudentDto(String fname, String lname, int age) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.age = age;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "StudentDto [fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
}
 
 
}
