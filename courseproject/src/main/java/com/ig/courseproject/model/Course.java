package com.ig.courseproject.model;

public class Course {

	Integer id;
	String name;
	Double fee;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", fee=" + fee + "]";
	}
	
	
}
