package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.configuration.DBConnect;
import com.model.StudentTest;



	public class StudentTestDaoImpl implements StudentTestDao {

		public boolean addStudentMarks(StudentTest st) {
			try(Connection con = DBConnect.getConnection();
					PreparedStatement pst = con.prepareStatement("insert into stud_test values(?,?,?)"))
			{
				pst.setInt(1, st.getStudid());
				pst.setInt(2, st.getTestid());
				pst.setInt(3, st.getMarks());
				
				pst.executeUpdate();
				return true;
			} catch (SQLException e) {

				System.out.println("Plz add sufficient data.....");
				e.printStackTrace();
			}

			return false;
		}
		//delete marks
		public boolean deleteStudentMarks(int id) {
		   try{
			 try(Connection con = DBConnect.getConnection();
			 PreparedStatement pst = con.prepareStatement("delete from stud_test where studid=?"))
		       {
				 pst.setInt(1, id);
				 pst.executeUpdate();
		    return true;
		      }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			return false;
	}
		// update marks
		@Override
		public boolean updateStudentMarks(StudentTest st) {
			try {
		    	Connection con = DBConnect.getConnection();
		        PreparedStatement pst = con.prepareStatement("UPDATE stud_test SET marks=? WHERE studid=? and testid=?");
		       
		        pst.setInt(2,st.getStudid());
				pst.setInt(3, st.getTestid());
		        pst.setInt(1, st.getMarks());
				
				 int recordUpdate = pst.executeUpdate();
			     if(recordUpdate > 0)
			    	 return true;
			    
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
				

		
			return false;
		}
		//get all student test
		public List<StudentTest> getAllStudentTest() {
			try(Connection con= DBConnect.getConnection();
					PreparedStatement pst = con.prepareStatement("select * from stud_test"))
			{
				ArrayList<StudentTest> studentTestlist = new ArrayList<>();
				ResultSet rest = pst.executeQuery();
				
				while(rest.next())
				{
					StudentTest test = new StudentTest();
					test.setStudid(rest.getInt(1));
					test.setTestid(rest.getInt(2));
					test.setMarks(rest.getInt(3));
					studentTestlist.add(test);
				}
				return studentTestlist;
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} 
			return null;
		
		}
		public Map <String,Integer> getBatchWiseTop()
		{
			HashMap<String,Integer> hm=new HashMap<>();
			try(Connection con=DBConnect.getConnection();
					Statement st=con.createStatement())
			{
				ResultSet rs=st.executeQuery("select sname,count(*) from student s inner join stud_test t on s.studentid=t.studid group by s.batchid");
					while(rs.next())
					{
						hm.put(rs.getString(1), rs.getInt(2));
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return hm; 
	}
		@Override
		public Map<String, Integer> getBatchwiseTop() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	