package com.dbtable;
import java.sql.*;
public class CrudOperation
{
		private static Connection cn;
		public static Connection createConnection()
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");//driver class object
				//factory method- use to create object of a class forclass is factory method
			cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/transportation","root","root");//connection string or connection url
			System.out.println("connected");
				
			}
			catch(SQLException|ClassNotFoundException cse)
			{
				System.out.println(cse);
			}
		return  cn;
		}

	}

