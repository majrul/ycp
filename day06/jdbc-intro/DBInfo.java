package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 * This java program will attempt connecting to the database
 * Before you run this example, please make sure
 * you have the jdbc driver for oracle(ojdbc6/7.jar)
 * In Eclipse->Right Click on the Project
 * ->Build Path->Configure BuildPath->
 * Libraries->Add External Jars
 * Then select the driver jar file wherever it has been copied
 * @author majrul
 *
 */
public class DBInfo {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			
			//Step 1. Load the JDBC Driver
			//This is optional in recent versions of Java(6+)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Step 2. Obtain Connection to the database
			//To connect, we need to know:
			String url = "jdbc:oracle:thin:@ipaddress:1521:xe";
			String username = "shyamdada";
			String password = "radha";
			conn = DriverManager.getConnection(url, username, password);
			
			//For completing this example, let's print some info
			//about the database we are connecting to
			DatabaseMetaData dbms = conn.getMetaData();
			System.out.println("DB Name : " + dbms.getDatabaseProductName());
			System.out.println("DB Version : " + dbms.getDatabaseProductVersion());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
