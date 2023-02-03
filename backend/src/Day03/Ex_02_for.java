package Day03;

public class Ex_02_for {
	public static void main(String[] args) {
		int sum = 0;
		sum = sum +1;
		sum = sum +2;
		sum = sum +3;
		sum = sum +4;
		sum = sum +5;
		System.out.println(sum);
		
		int sum2=0;
		for(int i = 0 ; i <6 ; i++) {
			sum2 += i ;
		}
		System.out.println(sum2);
		
		int total = 0;
		for(int i = 1 ; i<= 100 ; i++) {
			System.out.print(i + " ");
			total += i;
		}
		System.out.println("\n"+total);
		
		for(float x = 0.1f; x <= 1.0f ; x+=0.1f){
			System.out.println(x);
		}
		
		for(int i = 2 ; i <=9 ; i++) {
			System.out.println("ㅡㅡㅡ"+i+"단ㅡㅡㅡ");
			for(int j = 1 ; j <=9 ; j++) {
				System.out.printf("%d * %d = %d \n",i,j,i*j );
			}
			System.out.println("ㅡㅡㅡ"+i+"단 끝ㅡㅡㅡ");
		}
		
		while(true) {
			int num = (int)(Math.random()*6) +1 ;
			System.out.println(num);
			if(num == 6) {
				System.out.println("탈출");
				break;
			}
		}
		
		for(char abc ='A' ; abc <= 'Z' ; abc++) {
			System.out.println(abc);
			
			for(char lower = 'a' ; lower <= 'z' ; lower++) {
				System.out.println(lower);
				
				if(lower == 'g') {
					System.out.println("탈출!");
					break; //가장가까운 for 
				}
			}
		}
		
		
		forname: for(int i = 1 ; i<= 10 ; i++) {
			if(i%2 != 0) {
				//continue 가장 가까운 반복문 이동
				continue forname; //특정 반복문 이동
			}
			System.out.println(i + " " );
		}
	}
}
