package com.ig.courseproject.dao;

import java.util.List;

import com.ig.courseproject.model.Course;

public interface Coursedao {

	public void AddCourse(Course course) throws Exception;
	public List<Course> ListAllCourses() throws Exception;
	public void UpdateCourseById(Integer cid, Course course) throws Exception;
	public void DeleteCourseById(Integer cid) throws Exception;
	
	
}
