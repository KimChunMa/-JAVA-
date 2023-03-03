package Day01.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	Connection con ;
	PreparedStatement ps;
	ResultSet rs;
	
	
	private static Dao dao = new Dao();
	public static Dao getInstance() {return dao;}
	private Dao() {
		try {
			// 웹 서버 : 해당 MYSOQ 드라이버[라이브러리] 찾기
			Class.forName("com.mysql.cj.jdbc.Driver"); //  
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb",
					"root",
					"1234"
					);
			System.out.println("연동 성공");
		} catch (Exception e) {System.out.println(e);}
		
	}
	
	public boolean setData(String data) {
		//sql 작성 대입 조각 결과 응답
		String sql = "insert into ex1 values(?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
			return true;
		}
		catch(Exception e) {System.err.println(e);}
		
		
		return false;
	}
	
	//데이터들 호출
	public ArrayList<String> getData(){
		ArrayList<String> list = new ArrayList<>();
		
		String sql = "select * from ex1";
		
		try {
			ps = con.prepareStatement(sql);			// 2. 연결된 JDBC에 SQL 대입
			rs = ps.executeQuery();					// 3. SQL 조작 X / // 4. SQL 실행 --> 5. SQL 결과[rs]
			while( rs.next() ){ // 레코드1개 if / 레코드 여러개 while 
				list.add( rs.getString( 1 ) );	// 해당 레코드의 첫번째 필드를 리스트에 저장 
			} 
		}catch(Exception e) {System.err.println(e + "sql오류");}
		 return list;
	}
}
