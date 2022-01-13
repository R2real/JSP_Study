package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	String sql_selectAll="select * from board order by bid desc";
	String sql_selectOne="select * from board where bid=?";
	String sql_insert="insert into board values((select nvl(max(bid),0)+1 from board),?,?,?)";
	String sql_delete="delete from board where bid=?";
	String sql_update="update board set title=?,writer=?,content=? where bid=?";
	
	public ArrayList<BoardVO> selectAll(){
		conn=JDBCUtil.connect();
		ArrayList<BoardVO> datas=new ArrayList<BoardVO>();
		try {
			pstmt=conn.prepareStatement(sql_selectAll); 
			
			ResultSet rs=pstmt.executeQuery();
		
			while(rs.next()) {
				BoardVO vo=new BoardVO();
				
				vo.setBid(rs.getInt("bid"));
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
			
				datas.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt,conn);
		}
		return datas;
	}
	public BoardVO selectOne(BoardVO vo) {
				// 인자를 int타입으로 고정 -> 유지보수 불리
				// title,content,writer,... -> VO를 인자로설정!
		conn=JDBCUtil.connect();
		BoardVO data=null;
		try {
			pstmt=conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getBid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new BoardVO();
				data.setBid(rs.getInt("bid"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public boolean insert(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean update(BoardVO vo){
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_update);
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getWriter());
			pstmt.setString(3,vo.getContent());
			pstmt.setInt(4,vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			JDBCUtil.disconnect(pstmt,conn);
		}
		return true;
	}
	public boolean delete(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete);
			pstmt.setInt(1,vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			
		}
		return true;
	}
	

}
