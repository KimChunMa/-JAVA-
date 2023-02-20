package Day12.Ex3_;

public class throws_ {
	static void findClass() throws Exception{
		Class.forName("java.lang.String2");
	}
	
	
	public static void main(String[] args) throws Exception  {
			
		try {
			findClass();
		}catch(Exception e) {
			System.out.println("확인");
		}
	}
}

/*
	예외 떠넘기기
		메소드 내부에서 예외발생시 메소드 호출된 곳으로 예외 떠넘기기
*/
