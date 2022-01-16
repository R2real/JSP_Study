package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Bank2 {
	
	private int bid;
	private String name;
	private int balance;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
		
	}
	@Override
	public String toString() {
		return "Bank2 [bid=" + bid + ", name=" + name + ", balance=" + balance + "]";
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;

	public void connect() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void select() {
		connect();
		try {
			pstmt = conn.prepareStatement("select * from bank2");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			balance = rs.getInt("balance");
			name = rs.getString("name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("select에서 문제발생");
			e.printStackTrace();
		}

	}

}
