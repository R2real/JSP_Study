package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Db_connection_1 {

	public static void main(String[] args) {

		String oracleD = "oracle.jdbc.driver.OracleDriver";
		String mysqlD = "com.mysql.driver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kang";
		String password = "1234";
		// 사용 DB 및 정보가 교체 됐을 경우 유지보수 효율적
		
		System.out.println("찾고싶은 번호 입력 : ");
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		String sql = "select * from test where a ="+num;

		/*
		 * 1.JDBC(OJDBC6.JAR) 드라이버를 JVM에 로드 
		 * 2.DB에 연결 
		 * 3.DBMS에 데이터를 READ,WRITE == SQL문을 수행
		 * 4.DB연결 해제
		 */

		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(oracleD);
			System.out.println("JDBC 드라이버 로드 성공!"); // 1.JDBC(OJDBC6.JAR) 드라이버를 JVM에 로드

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("오라클에 연결 성공!"); // 2.DB에 연결
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// 컬렉션들을 복사해서 이터레이터로 가져와서 사용
			// hasNext()-데이터가 있? next()
			
			int cnt = 0;
			
			while(rs.next()) {
				System.out.println(rs.getInt("a")+" : "+rs.getString("b"));
				cnt++;
			}
			if(cnt==0) {
				System.out.println("없는 데이터입니다.");
			}
			rs.close(); //3.DBMS에 데이터를 READ,WRITE == SQL문을 수행
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close(); // 4.DB연결 해제
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
