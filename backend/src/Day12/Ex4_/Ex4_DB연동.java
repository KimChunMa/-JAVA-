package Day12.Ex4_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.PreparedQuery;

public class Ex4_DB연동 {
	public static void main(String[] args) {
			try {
				//연결 인터페이스
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/java", // 자바는 db생성 불가능
						"root", //계정명
						"1234" //비밀번호
						);
				System.out.println(" [DB연동 성공 ]");
				
				// table 생성 하는 sql 구문을 문자열 변수에 저장
				String sql = "create table member(mno int, mid varchar(20) , mpw varchar(20) )";
				
				//3.DML DDL 조작 인터페이스에 연결된 db연결구현객체에 sql 대입
				PreparedStatement ps = con.prepareStatement(sql);
				
				//4. sql 실행
				ps.execute();
			
				
				
			} catch (Exception e) {
				System.out.println("[ DB 연동 실패 사유] :" + e);
			}
			
			
					
	}
}

/*
 	JDBC : 자바와 DB연결 드라이브
 		- 해당 DBMS 마다 라이브러리 [.jar] 파일필요
 		- 보관장소 ㅣ C://mysql-connector-java-8.0.XX
 	라이브러리 추가
 		1. 프로젝트 오른쪽 클릭 -> build path -> Configure bulid path 
 		
 		
 */
