package Day02;

public class Ex1_출력 {
	public static void main(String[] args) {
		/* 제어 문자\n, \t, \", \', \\ */
		/*
		 	println(내용) : 출력후 줄바꿈
		 	print(내용) : 출력
		 	printf(내용) : 형식 출력
		 */
		System.out.print('와'); System.out.print("우 \n");
		System.out.println("와우"); System.out.println("와\n우");
		
		System.out.println("와 \n 우 \t \" \' \\");
		
		int value = 123;
		System.out.println("숫자 "+value);
		System.out.printf("숫자 %d\n",value);
		System.out.printf("숫자 %6d입니다\n",value);
		System.out.printf("숫자 %-6d입니다\n",value);
		System.out.printf("숫자 %06d입니다\n",value);
		
		double area = 3.14159 ; 
		System.out.println(area);
		System.out.printf("%.1f \n" ,area);
		System.out.printf("%3.3f \n" ,area);
		System.out.printf("%2.3f \n" ,area);
		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s \n", 1,name,job);
	}
}


