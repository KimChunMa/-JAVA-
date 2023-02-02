package 과제.과제1;

import java.util.Scanner;

public class 과제1_연산자문제 {
	public static void main(String[] args) {
		//문제1
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		
		//문제2
		Scanner sc = new Scanner(System.in);
		
		
		  System.out.println("순번를 입력해주세요"); String 순번 = sc.nextLine();
		  
		  System.out.println("작성자를 입력해주세요"); String 작성자 = sc.nextLine();
		  System.out.println("내용를 입력해주세요"); String 내용 = sc.nextLine();
		  System.out.println("날짜를 입력해주세요"); String 날짜 = sc.nextLine();
		  
		  System.out.println("--------------방문록--------------------");
		  System.out.println(" | 순번  | 작성자  | 	내용 	    | 날짜      |");
		  System.out.printf(" | %s    | %s     | %10s 	    | %5s      |\n",순번,작성자,내용,날짜
		  ); System.out.println("----------------------------------------");
		  
		  //문제3
		  System.out.println("기본급을 입력해주세요 "); int 기본급 = sc.nextInt();
		  System.out.println("수당을 입력해주세요 "); int 수당 = sc.nextInt();
		 
		  int 실수령 = (기본급- (int)(기본급*0.1) + 수당); System.out.println("실수령 금액은"+실수령);
		 
		
		//문제 4
		System.out.println("금액을 입력해주세요 ");
		int 금액= sc.nextInt(); //예 356789
		System.out.println("십만원: "+ (금액/100000));
		금액%= 100000; //56789
		System.out.println("만원: "+ (금액/10000));
		금액%= 10000; //6789
		System.out.println("천원: "+ (금액/1000));
		금액%= 1000; //789
		System.out.println("백원: "+ (금액/100));
		
		//문제5
		System.out.println("7의배수를 입력해주세요");
		int 칠배수 = sc.nextInt();
		String 배수확인 = (칠배수%7==0) ? "O": "X";
		System.out.println("칠의 배수 " + 배수확인);
		
		//문제6
		System.out.println("홀수를 입력해주세요");
		int 홀수 = sc.nextInt();
		String 홀수확인 = (홀수%2==0) ? "O": "X";
		System.out.println("홀수 " + 홀수확인);
		
		//문제 7
		System.out.println("7의배수면서 짝수를 입력해주세요");
		int 칠짝배수 = sc.nextInt();
		String 칠짝확인 = (칠짝배수%7==0 && 칠짝배수%2==0) ? "O": "X";
		System.out.println("칠짝  " + 칠짝확인);
		
		//문제 8
		System.out.println("7의배수면서 홀수를 입력해주세요");
		int 칠홀배수 = sc.nextInt();
		String 칠홀확인 = (칠홀배수%7==0 && 칠짝배수%2==1) ? "O": "X";
		System.out.println("칠홀  " + 칠홀확인);
		
		//문제 9
		System.out.println("두개의 정수를 입력해주세요");
		int 정수1 = sc.nextInt();
		int 정수2 = sc.nextInt();
		int 결과 = (정수1 < 정수2 )? 정수1 : 정수2;
		System.out.println(정수1);
		
		//문제10
		System.out.println("반지름을 입력해주세요");
		int 반지름 = sc.nextInt();
		반지름 *= (반지름*3.14); 
		System.out.println(반지름);
		
		//문제 11
		System.out.println("두실수를 입력해주세요");
		float 실수1 = sc.nextFloat();
		float 실수2 = sc.nextFloat();
		System.out.println("두 실수의 %는"+(실수1/실수2)*100 +"%");
		
		//문제 12
		System.out.println("사다리꼴 윗면 아랫면 높이를(정수) 입력해주세요");
		int 윗면 = sc.nextInt();
		int 아래면 = sc.nextInt();
		int 높이 = sc.nextInt();
		System.out.println("사다리꼴 넓이는"+(윗면*아래면)*높이/2 );
		
		//문제 13~14
		System.out.println("키와 몸무게를(정수) 입력해주세요");
		int 키 = sc.nextInt();
		int 몸무게 = sc.nextInt();
		System.out.println("표준체중은"+(키-100)*0.9);
		System.out.println("BMI는"+ 몸무게/((키/100)*(키/100) ));
		
		//문제 15
		System.out.println("inch 입력해주세요");
		float inch = sc.nextInt(); inch*=2.54;
		System.out.println("cm는"+inch +"cm 입니다.");
		
		//문제 16
		System.out.println("중간,기말,수행평가 점수를 입력해주세요");
		float 중간 = sc.nextFloat(); 중간*=0.3;
		float 기말 = sc.nextFloat();	기말*=0.3;	
		float 수행 = sc.nextFloat();	수행*=0.4;
		System.out.printf("총 점수는 %.2f",(중간+기말+수행));
		
		//문제17
		int x = 10;
		int y = x-- + 5 + --x; 
		//x+5 15가된후 x--가실행되어 15+(--9) = 15+8 = 23 // x=8, y=23
		System.out.printf(" x의 값 : %d , y의값 :  %d ", x, y);
		
		//문제18
		System.out.println("나이를 입력해주세요");
		int 나이 = sc.nextInt();
		String 연령 = (나이>=40) ? "중년": ((나이>=20)? "성인" : ((나이>=10)? "학생" : "유치원") );
		System.err.println(연령);
		
		//문제19
		System.out.println("국어 영어 수학 점수를 입력하세요");
		float 국어 = sc.nextInt();
		float 영어 = sc.nextInt();
		float 수학 = sc.nextInt();
		System.out.printf("평균은 %.2f",(국어+영어+수학)/3);
		
		//문제 20
		System.out.println("아이디와 비밀번호를 입력하세요");
		String id = sc.nextLine();
		String pw = sc.nextLine();
		String 여부 = (id.equals("admin") && pw.equals("1234"))? "로그인 성공": "로그인 실패";
		System.out.println(여부);
		
		//문제 21
		System.out.println("세 정수를 입력하세요");
		int one = sc.nextInt();
		int two = sc.nextInt();
		int thr = sc.nextInt();
		
		int result = (one<two)? (two<thr? thr:two) : (one>thr ? one : thr);
		System.out.println(result);
		
		//문제 22
		System.out.println("두 플레이어의 묵찌빠중 하나를 선택해주세요");
		int play1 = sc.nextInt();
		int play2 = sc.nextInt();
		
		
		String win = (play1 == 0)? (play2 == 2 ? "플레이어1 승리": (play2 == 1? "플레이어2 승리":"무승부")): //가위일떄
					 (play1 == 1)? (play2 == 0 ? "플레이어1 승리": (play2 == 2? "플레이어2 승리":"무승부")):  //바위일떄
					 (play1 == 2)? (play2 == 1 ? "플레이어1 승리": (play2 == 0? "플레이어2 승리":"무승부")):"오류"	 ; // 보 일떄
		
	}
}
