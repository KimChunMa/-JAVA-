package Day04;

import java.util.Random;
import java.util.Scanner;

public class Ex1_가위바위보 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int pwin = 0 ; int cwin = 0 ; int play = 0;
		
		while(true) {
			System.out.println("가위(0), 바위(1) , 보(2), 종료(3) : ");
			
			byte player = sc.nextByte();
			
			if(player == 3) {
				System.out.println("종료합니다");
				break;
			}
			
			Random ran = new Random();
			int com = ran.nextInt(3);
			System.out.println("컴퓨터 수 "+com);
			
			System.out.println("낸수 "+player);
			
			if((com == 0 && player == 1 )|| (com==1 && player == 2) || (com==2&&player==0)) {
				System.out.println("승리했습니다");	pwin++; play++;
			}else if ((com == 1 && player == 0 )|| (com==2 && player == 1) || (com==0&&player==2)) {
				System.out.println("패배했습니다");	cwin++; play++;
			}else {
				System.out.println("비겼습니다.");		play++;
			}
			
		}
		
		System.out.printf("이긴 횟수%d 진 횟수%d 총 %d판",pwin,cwin,play);
		

		
		
	}
}
