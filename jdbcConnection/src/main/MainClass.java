package main;

import jdbc.JdbcConnect;

public class MainClass {
	public static void main(String[] args) {
		/*
		   JDBC
		   
		   java DataBase Connectivity
		   
		 */
		JdbcConnect jc = new JdbcConnect();
		
		jc.getConnection();
		
	}
}
