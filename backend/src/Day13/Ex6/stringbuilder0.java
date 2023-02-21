package Day13.Ex6;

public class stringbuilder0 {
	public static void main(String[] args) {
		
		String data = "ABC";
			System.out.println(data.hashCode());
		data += "DEF"; // ABC객체는 버려지고 ABCDEF객체가 생성된다.
		System.out.println(data.hashCode());
		
		String data2 = new StringBuilder()
				.append("DEF")			//문자열 끝에 추가
				.insert(0,"ABC")		// 0 번째 인덱스에 추가
				.delete(3,4)			//3,4 인덱스 삭제
				.toString();			//문장ㄹ
		
		System.out.println(data2);
		System.out.println(data2.hashCode());
		
		StringBuilder data3 = new StringBuilder();
		data3.append("ABC"); data3.append("DEF");
		System.out.println(data3);
		System.out.println(data3.hashCode());
		
		
	}
}
