package Day14;

import java.util.Calendar;
import java.util.Scanner;

public class Ex03달력 {
	public static void main(String[] args) {
		//static은 인스턴스 멤버 호출 불가능.
		//1.[해당 멤버[메소드/필드]가 static(정적멤버)] 되기
		//2.[해당 멤버[메소드/필드]가 인스턴스 멤버]객체만들어서 메소드 호출
		
		Ex03달력 달력 = new Ex03달력();
		달력.Run();
		Ex03달력.run();
		
		
		
		
	}
	
	//달력함수
	static void run() {}
	void Run() {
		Calendar cal = Calendar.getInstance(); // 현재날짜
		int year = cal.get(1);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(3);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.printf("===========================%d-%d===========================\n",year,month);
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			
			cal.set(year, month-1,1); // 캘린더 날짜 수정 현재연도/월의 1일 날짜 형식으로 변경
			
			
			int sweek = cal.get(Calendar.DAY_OF_WEEK); //2023-02-01의 요일 구하기
			//System.out.println(sweek);//4
			
			for(int i= 1 ; i < sweek; i++) {
				System.out.print("\t");
			}
			
			int eday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 2023-02 월의 일수의 최대수
			
			
			for(int i = 1 ; i <= eday ; i++) {
				System.out.printf("%2d\t",i);
				if(sweek%7==0)System.out.println();
				sweek++;
			}
			
			System.out.println("\n===================");
			System.out.println("\n1. 이전달 2. 다음달 3.검색"); int ch = sc.nextInt();
			
			if(ch==1) {month--;
				if(month<1) {
					month=12; year--;
				}
			}
			else if(ch==2) {month++;
				if(month>12) {
					month=1; year++;
				}
			}
			
			else if (ch==3) {
				System.out.println("연도"); int inputY = sc.nextInt();
				System.out.println("월:"); int inputM = sc.nextInt();
				if(inputY<1900 || inputY > 9999 || inputM <1 || inputM >12) {
					System.out.println("잘못된 입력입니다.");
				}else {
					year = inputY;
					month = inputM;
				}
			}
		}//while e
	}
}
