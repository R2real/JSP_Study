package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.sql.DataSource;
import javax.naming.InitialContext;

public class Bank1 {
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
		return "Bank1 [bid=" + bid + ", name=" + name + ", balance=" + balance + "]";
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

	// bank1에서 bank2로 계좌이체하는 로직
	public boolean transfer(int balance) {
		connect(); // DB연결
		try {
			conn.setAutoCommit(false); // 자동커밋모드 해제

			// 66번~ 72번 라인까지 하나의 트랜잭션
			// 75번부터 82번 라인까지 메서드 수행 상태 확인
			pstmt = conn.prepareStatement("update bank1 set balance=(balance- ?) where bid= 11");
			pstmt.setInt(1, balance);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("update bank2 set balance=(balance + ?) where bid= 21");
			pstmt.setInt(1, balance);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select * from bank1 where bid=11");
			ResultSet rs = pstmt.executeQuery();
			rs.next();

			if (rs.getInt("balance") < 0) { // 11번 고객의 잔액이 0원 미만이 됐다면 !
				conn.rollback(); // rollback 진행
				return false;
			}
			conn.commit();

			conn.setAutoCommit(true); // 자동커밋모드 원상 복구
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("transfer에서 문제발생");
			return false;
		}
		return true;
	}

	public void select() {
		connect();
		try {
			pstmt = conn.prepareStatement("select * from bank1");
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
