package com.controller;

import java.util.List;
import java.util.Scanner;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.dao.StudentTestDao;
import com.dao.StudentTestDaoImpl;
import com.model.Student;
import com.model.StudentTest;


public class MainEntry {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		StudentDao sdao = new StudentDaoImpl();
		StudentTestDao stdao = new StudentTestDaoImpl();
		
		
		do
		{
			System.out.println("--* Welcome Training Academy *--");
			System.out.println("1 - Add new Student");
			System.out.println("2 - Update Student Details");
			System.out.println("3 - Delete");
			System.out.println("4 - View All Students");
			System.out.println("**************************************************");
			System.out.println("5 - Add Marks Of Student");
			System.out.println("6 - Update Marks of Student");
			System.out.println("7 - Delete results of Student");
			System.out.println("8 - View Marks of Student ");
			System.out.println("9 - Report");
			System.out.println("0 - Exit");
			
			
			System.out.println("Enter your choice-");
			int choice=sc.nextInt();
			switch(choice)
			{
			
			//insert
			case 1:
				System.out.println("Enter Student id,Student name,mobile no,batchid");
			    int studentid=sc.nextInt();
			    String  sname=sc.next();
			    long mobileno=sc.nextLong();
			    int batchid = sc.nextInt();
			    Student s = new Student(studentid,sname,mobileno,batchid);
			    
			    boolean isinsert = sdao.addStudent(s);
			    if(isinsert)
			    	System.out.println("Record Added Successfully");
			    else
			    	System.out.println("Unsuccessful insertion");
			    break;
			    
			    
			   //update
			case 2:
				System.out.println("Updation");
				System.out.println("Enter ID to update");
				int Studentid = sc.nextInt();
				System.out.println("Enter new Student name");
				String Sname = sc.next();
				System.out.println("Enter new Mobile no");
				long Mobileno = sc.nextLong();
				System.out.println("Enter batchid");
				int Batchid=sc.nextInt();
				Student ob = new Student(Studentid,Sname,Mobileno,Batchid);
				
				boolean isupdated = sdao.updateStudent(ob);
				if(isupdated)
			    	System.out.println("Record updated Successfully");
			    else
			    	System.out.println("Unsuccessful updation");
			    break;
			    
			    //deletion
			case 3:
				System.out.println("Deletion");
				System.out.println("Enter ID to delete");
				int Studentid1 = sc.nextInt();
				boolean isdelete=sdao.deleteStudent(Studentid1);
				        System.out.println(" Student Detail Deleted");
				break;
				
				
			case 4:
				List<Student> list=sdao.getAllStudents();
			System.out.println("Studentid   | Studentname | Mobileno | Batchid");
		    for(Student rr:list)
		    {
		    	System.out.println(rr.getStudentid() + " | "+rr.getSname() + " | "+rr.getMobileno() + " | "+rr.getBatchid());
		    	
		    }
		    break;
			case 5:
				System.out.println("Enter Student_id , Test_id and Marks ");
				int Studid= sc.nextInt();
				int Testid = sc.nextInt();
				int marks = sc.nextInt();
				StudentTest st = new StudentTest(Studid,Testid,marks);
				
				boolean ismarksinsert = stdao.addStudentMarks(st);
				if(ismarksinsert)
					System.out.println("Record added successfully");
				else
					System.out.println("Unsuccessful insertion");
				break;	
				
			case 6:
				System.out.println("Modification");
				System.out.println("Enter student id to update");
				int Studid1 = sc.nextInt();
				System.out.println("Enter test_id to update");
				int Testid1 = sc.nextInt();
				System.out.println("Enter marks to update");
				int Marks = sc.nextInt();
				StudentTest stupdate = new StudentTest(Studid1,Testid1,Marks);
				
				boolean ismarksupdated = stdao.updateStudentMarks(stupdate);
				if(ismarksupdated)
					System.out.println("Record update successfully");
				else
					System.out.println("Unsuccessful Modification");
				break;
				
			case 7:
				System.out.println("enter student id to delete marks");
				int studid=sc.nextInt();
				boolean ismarksdelete = stdao.deleteStudentMarks(studid);
					System.out.println("Row deleted....");
					break;
			case 8:
				List<StudentTest> listmarks = stdao.getAllStudentTest();
				System.out.println("Studentid  | Testid | Marks ");
				for(StudentTest sstt : listmarks)
				{
					System.out.println(sstt.getStudid()+ " | " +sstt.getTestid() + " | "  +sstt.getMarks());
				}
				break;		
			
			case 9 :
				System.out.println("Reports");
				System.out.println("1 - Merit list of students for any given batch \n 2 - Merit list of students for all batches \n 3 - Show batch name and trainer name of the batch whose average percentage result is best  \n 4 - Show name of the batch where maximum students have failed. ");
				int ch = sc.nextInt();
				if(ch ==1)
				{
					
				}
			}	
			
			
			    
			
			if(choice==0)
				break;
		}while (true);
		System.out.println("** Thank you **");
	}
}
