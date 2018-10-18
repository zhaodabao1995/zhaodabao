package light;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JTable;

 

public class UserModel
{
 
 Connection connection = null;
 Statement statement = null;
 ResultSet resultSet = null;
 PreparedStatement pstmt = null;

 JTable jtable = null;
 Vector rowDate = null;
 Vector columnNames = null;
 public void conn(String name,String pwd,String ip ,String port,String dbname){
	 String password = "1";
 }

 public boolean connect(String name,String pwd,String ip ,String port,String dbname)
 {
	 String dbUrl = "jdbc:sqlserver://"+ip+":"+port+";DatabaseName="+dbname;
	 String user = name;
	 String password = pwd;
	 System.out.println(dbUrl);
	 System.out.println(user);
	 System.out.println(password);
	 
  try
  {
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
   connection = DriverManager.getConnection(dbUrl, user, password);
   System.out.println("连接数据库成功");
   statement = connection.createStatement();
   return true;
  } catch (Exception e)
  {
   e.printStackTrace();
   return false;
  }
 }

 public boolean close()
 {
  try
  {
   resultSet.close();
   statement.close();
   connection.close();
   pstmt.close();
   return true;
  } catch (Exception e)
  {
   e.printStackTrace();
   return false;
  }
 }

 public JTable executeQuery()
 {
  this.jtable = jtable;
  String sql = "select bak3,bak2 from c_stall_backup group by bak3,bak2 order by bak3,bak2";
  try
  {
   resultSet = statement.executeQuery(sql);

   columnNames = new Vector();
   columnNames.add("枪号");
   columnNames.add("灯号");
  

   rowDate = new Vector();

   while (resultSet.next())
   {
   
     Vector row = new Vector();
     row.add(resultSet.getString(1));
     row.add(resultSet.getString(2));
    
     rowDate.add(row);
     jtable = new JTable(rowDate, columnNames);
    }
  } catch (SQLException e)
  {
   e.printStackTrace();
  }
  return jtable;
 }

/* public Vector executeQuery(Vector vector, String str)
 {
  String sql = "select bak3,bak2 from c_stall_backup group by bak3,bak2 order by bak3,bak2";
  vector = new Vector();
  try
  {
   resultSet = statement.executeQuery(sql);
   while (resultSet.next())
   {
    if (str.equals(resultSet.getString(1)))
    {
     vector.add(resultSet.getString(1));
     vector.add(resultSet.getString(2));
    
    }
   }
  } catch (SQLException e)
  {
   e.printStackTrace();
  }
  return vector;
 }*/

 

 public void executeUpdate(String bak3,String bak2){
	
	 
	String sql="update c_stall_backup set bak3="+bak3+"where bak2="+bak2+"";
	  try {
		statement.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  System.out.println(bak2);
   /*pstmt = connection.prepareStatement("update c_stall_backup set bak3 = ?where bak 2 = ?");
   
   pstmt.setString(1, bak3);
   pstmt.setString(2, bak2);
   System.out.println(bak3);
  
   pstmt.execute();*/
  
  
 }


}