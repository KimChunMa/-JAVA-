package 과제.과제10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		
		
		while(true) {
			System.out.println("1. DB연결 2.SQL구문 작성 3.매개변수 입력");
			
			try {
			int ch = sc.nextInt();
			
			if(ch==1) { 
				System.out.println("연동할 DB이름을 입력해주세요");
				String DBname = sc.next();
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +DBname,"root","1234"); 
				System.out.println( DBname +" 연결 성공");
			
			}else if (ch==2) {
				System.out.println("SQL구문을 입력해주세요.");
				sc.nextLine();
				String sql = sc.nextLine();
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.execute();
			}
			else if(ch==3) {
				System.out.println("번호 : ");		int pno = sc.nextInt();
				System.out.println("제품명 : ");		String pname = sc.next();
				System.out.println("제품설명 : ");	String pcontent = sc.next();
				System.out.println("제품가격 : ");	int pprice = sc.nextInt();
				
				
				String sql = "insert into product (pno,pname,pcontent,pprice) value(?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, pno);
				ps.setString(2, pname);
				ps.setString(3, pcontent);
				ps.setInt(4, pprice);
				ps.executeUpdate();
			}
			
			
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				sc = new Scanner(System.in);
			} catch(SQLException e) {
				System.out.println("SQL 오류 : "+e);
			}
			
			
			
			
		}
	}
}
