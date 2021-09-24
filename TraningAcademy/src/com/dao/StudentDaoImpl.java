package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.configuration.DBConnect;
import com.model.Student;
	

		public class StudentDaoImpl implements StudentDao {

			
			public boolean addStudent(Student s)   {
			try(Connection con = DBConnect.getConnection();
					PreparedStatement pst =con.prepareStatement("insert into student  values(?,?,?,?) "))
						{
				    pst.setInt(1, s.getStudentid());
					pst.setString(2, s.getSname());
					pst.setLong(3, s.getMobileno());
					pst.setInt(4, s.getBatchid());
					pst.executeUpdate();
				return true;
				}
				catch(SQLException e)
				{
					System.out.println("Please add sufficent data");
					e.printStackTrace();
					
				}
			
				return false;
			}

			
			public boolean deleteStudent(int id) {
				try {
				try(Connection con=DBConnect.getConnection();
						PreparedStatement pst = con.prepareStatement("delete from student where studentid=?"))
				{
					pst.setInt(1, id);
				    pst.executeUpdate();
				    return true;
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
				return false;
			}

			
			public boolean updateStudent(Student s) {
				try(Connection con = DBConnect.getConnection();
						PreparedStatement pst = con.prepareStatement("UPDATE student SET sname=? where mobile=? and batchid=?  and studentid=?"))
				{
					
					pst.setString(2, s.getSname());
					pst.setLong(3, s.getMobileno());
					pst.setInt(4, s.getBatchid());
					pst.setInt(1, s.getStudentid());
					int recordUpdate = pst.executeUpdate();
					
					if(recordUpdate > 0)
						return true;
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					
				}
				return false;
				
			}

		
          //get all Student
			public List<Student> getAllStudents() {
				ArrayList<Student> Studentlist= new ArrayList<>();
				try(Connection con=DBConnect.getConnection();
						PreparedStatement pst = con.prepareStatement("Select * from Student "))
				{
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						Student s = new Student();
						s.setStudentid(rs.getInt(1));
						s.setSname(rs.getString(2));
						s.setMobileno(rs.getLong(3));
						s.setBatchid(rs.getInt(4));
						Studentlist.add(s);
						
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return Studentlist;
			}

			
	}


