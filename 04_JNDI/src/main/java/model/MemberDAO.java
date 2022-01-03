package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_insert="insert into member values(?,?,?)";
	String sql_select="select * from member";
	
	public boolean insert(MemberVO vo) {
		conn=JNDI.getConnection();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("MemberDAO insert()에서 문제발생!");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ArrayList<MemberVO> select(MemberVO vo){
		conn=JNDI.getConnection();
		ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
		
		try {
			pstmt=conn.prepareStatement(sql_select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data = new MemberVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				datas.add(data);
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO select()에서 문제발생!");
			e.printStackTrace();
		}
		return datas;
	}
}
