package com.ig.courseproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ig.courseproject.Util.DbUtil;
import com.ig.courseproject.model.Course;

public class Coursedaoimpl  implements Coursedao{

	
	Connection con;
	@Override
	public void AddCourse(Course course) throws Exception {
		// TODO Auto-generated method stub
		con=DbUtil.getConnection();
		PreparedStatement pst=con.prepareStatement("insert into course values(?,?,?)");
		pst.setInt(1, course.getId());
		pst.setString(2, course.getName());
		pst.setDouble(3, course.getFee());
		pst.execute();
		
		
	}

	@Override
	public List<Course> ListAllCourses() throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<Course> courseList=new ArrayList<>();
		con=DbUtil.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from course");
		while(rs.next())
		{
			Course course=new Course();
			course.setId(rs.getInt(1));
			course.setName(rs.getString(2));
			course.setFee(rs.getDouble(3));
			
			courseList.add(course);
		}
		return courseList;
	}

	@Override
	public void UpdateCourseById(Integer cid, Course course) throws Exception {
		// TODO Auto-generated method stub
		con=DbUtil.getConnection();
		PreparedStatement pst=con.prepareStatement("update course set name=?, fee=? where id=?");
		pst.setString(1, course.getName());
		pst.setDouble(2, course.getFee());
		pst.setInt(3, cid);
		int ru = pst.executeUpdate();
        if (ru > 0) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("No record found with the given ID.");
        }
	}

	@Override
	public void DeleteCourseById(Integer cid) throws Exception {
		// TODO Auto-generated method stub
		
		con=DbUtil.getConnection();
		PreparedStatement pst=con.prepareStatement("delete from course where id=?");
		pst.setInt(1, cid);
		int rd=pst.executeUpdate();
		if (rd > 0) {
            System.out.println("Record Deleted successfully.");
        } else {
            System.out.println("No record found with the given ID.");
        }
		
	}

	
}
