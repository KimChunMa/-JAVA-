package Day06;

public class Ex2_문자열 {
	public static void main(String[] args) {
		//1.
		
		//1 char[]
		char[] 문자열1 = new char[]{'안','녕'};
		System.out.println(문자열1);
		
		//2 new String
		String 문자열2 = new String("안녕");
		System.out.println(문자열2);
		
		//3 String
		String 문자열3 = "안녕";
		System.out.println(문자열3);
		
		
		//2.
		String strVar1 = "홍길동"; //10번지
		String strVar2 = "홍길동"; //10번지
		
		if(strVar1 == strVar2) {System.out.println("참조[주소] 같음");}
		else {System.out.println("참조[주소] 다름");}
		
		if(strVar1.equals(strVar2)) {System.out.println("참조[주소] 같음");}
		else {System.out.println("참조[주소] 다름");}
		
		String strVar3 = new String("홍길동"); //12번지
		String strVar4 = new String("홍길동"); //11번지
		
		if(strVar3 == strVar4) {System.out.println("참조[주소] 같음");}
		else {System.out.println("참조[주소] 다름");}
		
		if(strVar3.equals(strVar4)) {System.out.println("참조[주소] 같음");}
		else {System.out.println("참조[주소] 다름");}
		
		
		//3.
		String hobby = ""; // "" vs null
		if(hobby.equals("")) {System.out.println("빈문자열");}
		
		String hobby2 = null; // "" vs null
		//if(hobby2.equals(null)) {System.out.println("빈문자열");} 오류\
		if(hobby2 == null) {System.out.println("null확인");};
		
		//4
		String ssn = "9506241229410";
		char sex = ssn.charAt(6); System.out.println(sex);
		if(sex=='1' || sex == '3') {System.out.println("남자");}
		else {System.out.println("여자");}
		
		int length = ssn.length();
		if(length == 13) {System.out.println("주민등록번호입니다.");}
		else {System.out.println("아닙니다");}
		
		//5
		String oldStr = "자바는 String입니다.";
		String newStr = oldStr.replace("자바","JAVA");
		
		System.out.println(oldStr);
		System.out.println(newStr);
		
		
		//6 161 subString(인덱스) vs split(인덱스)
		String ssn2 = "880815-1234567";
		System.out.println(ssn2.substring(7)); //7인덱스 전 
		System.out.println(ssn2.substring(0,6)); // 0~6인덱스전
		System.out.println(ssn2.split("-"));	//2조각
		System.out.println(ssn2.split("-")[0]);	//1번째 -조각
		System.out.println(ssn2.split("-")[1]);	//2번째 조각
		
		String board = "1,자바 학습, 참조타입 String , 홍길동";
		String[] tokens = board.split(","); //4조각
		System.out.println("번호 "+tokens[0]);	//1조각
		System.out.println("제목 "+tokens[1]);	//2조각
		System.out.println("내용 "+tokens[2]);	//3조각
		System.out.println("저자 "+tokens[3]);	//4조각
		
		//7 indexOf(찾을문자) vs contains(찾을문자)
		String subject = "자바 프로그래밍";
		System.out.println(subject.indexOf("자바")); // 찾으면 0~인덱스
		System.out.println(subject.indexOf("파이썬")); // -1
		
		System.out.println(subject.contains("자바")); // 찾으면 true
		System.out.println(subject.contains("파이썬")); // false
		
	}
}
/*
	자바 문자열 사용 방법
	1. 배열, 클래스 , 문자리터널
	
	2.클래스
				-new 연산자 [ 객체 메모리 생성 ==불가능]
				문자"리터럴"이 동일한 경우 객체 공유 [주소 같다 ==]
				String 문자열3 =new String("안녕");
				String 문자열4 =new String("안녕");
				문자열3 == 문자열4; X
				문자열3.equals(문자열4);
				
				
	3. 문자"리터럴"
		문자"리터럴"이 동일한 경우 객체 공유 [주소 같다 ==]
		String 문자열3 ="안녕";
		String 문자열4 ="안녕";
		문자열3 == 문자열4;
		문자열3.equals(문자열4);
		
	4. 문자열함수
		.charAt(인덱스) 				:인덱스 위치의 문자 1개 추가
		.length()	 				:문자열 길이
		.replace("기존문자",새로운 문자) :문자 교체
		.subString(인덱스);  			:0~인덱스-1 자르기
		.subString(인덱스,인덱스);		:인덱스~인덱스 자르기
		.indexOf("찾을문자");			:찾을 문자의 찾은 인덱스번호 반환
		.split("자를기준");			:기준문자 기준으로 자르기
		.contains("찾을문자");		:찾을문자가 존재하면 true/false
		.getBytes() 				:
*/