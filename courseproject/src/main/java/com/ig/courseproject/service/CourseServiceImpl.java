package com.ig.courseproject.service;

import java.util.List;

import com.ig.courseproject.dao.Coursedao;
import com.ig.courseproject.dao.Coursedaoimpl;
import com.ig.courseproject.model.Course;

public class CourseServiceImpl implements CourseService {

	Coursedao cd;
	@Override
	public void AddCourse(Course course) throws Exception{
		// TODO Auto-generated method stub
		cd = new Coursedaoimpl();
		cd.AddCourse(course);
		
		System.out.println("Course added successfully.");
		
	}

	@Override
	public List<Course> ListAllCourses() throws Exception {
		// TODO Auto-generated method stub
		cd=new Coursedaoimpl();
		return cd.ListAllCourses();
		
	}

	@Override
	public void UpdateCourseById(Integer cid, Course course) throws Exception {
		// TODO Auto-generated method stub
		
		cd=new Coursedaoimpl();
		cd.UpdateCourseById(cid, course);
		
	}

	@Override
	public void DeleteCourseById(Integer cid) throws Exception {
		// TODO Auto-generated method stub
		
		cd=new Coursedaoimpl();
		cd.DeleteCourseById(cid);
	}

	
}
