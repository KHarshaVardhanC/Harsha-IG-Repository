package com.ig.courseproject.UI;

import java.util.List;
import java.util.Scanner;

import com.ig.courseproject.model.Course;
import com.ig.courseproject.service.CourseService;
import com.ig.courseproject.service.CourseServiceImpl;

public class courseUi {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		CourseService cs=new CourseServiceImpl();
		
		while(true)
		{
			System.out.print("\n1. Add Course\n2. List all Courses\n3. To Update Name, Fee of Course\n4. TO Delete Record by Id\n6. To exit\n Enter your choice:");
			
			int ch=sc.nextInt();
			if(ch == 1)
			{
				System.out.println("Enter Id  Name  fees");
				int cid=sc.nextInt();
				String cname=sc.next();
				Double cfee=sc.nextDouble();
				Course course=new Course();
				course.setId(cid);
				course.setName(cname);
				course.setFee(cfee);
				cs.AddCourse(course);
			}
			else if(ch == 2)
			{
				cs.ListAllCourses().forEach(x-> System.out.println(x));
				
				
			}
			else if(ch ==3)
			{
				System.out.print("\nEnter Id to Update: ");
				Integer cid=sc.nextInt();
				System.out.print("\n Enter Name fee to Update: ");
				String name=sc.next();
				Double fee=sc.nextDouble();
				Course course=new Course();
				course.setName(name);
				course.setFee(fee);
				cs.UpdateCourseById(cid, course);
				
			}
			else if(ch == 4)
			{
				System.out.print("\nEnter Id to Delete : ");
				Integer cid=sc.nextInt();
				cs.DeleteCourseById(cid);
			}
			else
			{
				System.out.println("-----------Break----------");
				break;
			}
			
		}
	}
}
