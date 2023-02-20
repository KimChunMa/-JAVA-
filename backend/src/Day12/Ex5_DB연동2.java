package Day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex5_DB연동2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		
		while (true) {
			
			try { //문자입력시 오류
				System.out.println("1.DB 연결 2. 테이블 생성 3.매개변수 구문 삽입");
				int ch = sc.nextInt();
				
				if(ch==1) {
					System.out.println(" 연동할 DB명 입력 : ");
					String dbname = sc.next();
					System.out.println(dbname+"에 연결합니다");
					
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,"root","1234");
				}
				else if(ch==2) {
					System.out.println(" --- SQL구문 입력 : ");
					sc.nextLine(); // 다른 next가 있을떄 오류 방지 spacebar 가져감
					String sql = sc.nextLine();
					
					PreparedStatement ps =  conn.prepareStatement(sql);
					
					//실행
					ps.execute();
				}
				
				else if(ch==3) {
					System.out.println("번호 : ");		int mno = sc.nextInt();
					System.out.println("아이디 : ");		String mid = sc.next();
					System.out.println("비밀번호 : ");	String mpw = sc.next();
					
					String sql = "insert into member value(?,?,?);";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, mno);		//? 첫번째 교체
					ps.setString(2, mid);	//? 두번째 교체
					ps.setString(3, mpw);	//? 세번째 교체
					
					ps.executeUpdate();
				}
				
				
				
				
			} catch(InputMismatchException e) {
				System.out.println("잘못된 번호 입니다. ");
				
				//기존에 입력된 데이터 제거
				sc = new Scanner(System.in);
			}catch(SQLException e) {
				System.out.println("SQL 오류"+e);
			}
			
		}//while e
	}
}
