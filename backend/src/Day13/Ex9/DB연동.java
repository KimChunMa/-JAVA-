package Day13.Ex9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.protocol.Resultset;

//1. DB서버 주소 [localhost , 개인ip (개인이 컴퓨터 켜둬야함 )vs AWS ],
//2. 해당 DB서버의 계정+비번
//	자바에서 DB조작하는 JDBC 



public class DB연동 {
	
		
		private Connection conn; 		//1. DB연결된 구현객체를 받아서 다양한 메소드를 제공
		private PreparedStatement ps; 	//2. 연결된 SQL 조작 메소드 제공 [?메소드 사용]
		private Resultset rs;			//3. sql 결과 조작 메소드
		
		
		public DB연동() {
			
			try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java" , "root" , "1234"
					);
			System.out.println("연동성공");
			} catch(Exception e) {System.out.println(e.getMessage());}
		}
		
		public static void main(String[] args) {
			DB연동 db연동 = new DB연동();
		}
		

}
