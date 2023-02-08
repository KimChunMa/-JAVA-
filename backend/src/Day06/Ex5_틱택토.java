package Day06;

import java.util.Random;
import java.util.Scanner;

public class Ex5_틱택토 {
	public static void main(String[] args) {
		String[] game = {"[ ]","[ ]","[ ]",
						 "[ ]","[ ]","[ ]",
						 "[ ]","[ ]","[ ]" };
		
		Scanner sc = new Scanner(System.in);
		
		Random ran = new Random();
		
		while(true) {
			//게임판 출력
			for(int i = 0 ; i<game.length ; i++) {
				System.out.print(game[i]);
				
				if(i%3 == 2) {System.out.println();}
			}
			
			System.out.println("위치는 0~8입니다.");
			int 위치 = sc.nextInt();
			
			//유효성 (사람턴)
			if(game[위치].equals("[O]") || game[위치].equals("[X]") || 위치<0 || 위치>8) 
			{System.out.println("오류발생"); continue;}
			else {game[위치] = "[O]";}
			
			/*승리*/
		if(   ( (game[0].equals("[O]") && game[1].equals("[O]") &&  game[2].equals("[O]")) ||
				(game[3].equals("[O]") && game[4].equals("[O]") &&  game[5].equals("[O]")) ||
				(game[6].equals("[O]") && game[7].equals("[O]") &&  game[8].equals("[O]")) ||   
				
				(game[0].equals("[O]") && game[3].equals("[O]") &&  game[6].equals("[O]")) ||
				(game[1].equals("[O]") && game[4].equals("[O]") &&  game[7].equals("[O]")) ||
				(game[2].equals("[O]") && game[7].equals("[O]") &&  game[8].equals("[O]")) ||   
					
				(game[0].equals("[O]") && game[4].equals("[O]") &&  game[8].equals("[O]")) ||
				(game[2].equals("[O]") && game[4].equals("[O]") &&  game[6].equals("[O]")) 
				)
		  ) {for(int i = 0 ; i<game.length ; i++) {
				System.out.print(game[i]);
				
				if(i%3 == 2) {System.out.println();}
			};
			System.out.println("이기셨습니다!"); break;}
		
		/*무승부*/
		boolean bool = true; 
		
		for(int i = 0 ; i<game.length ; i++) {
			
			if( game[i] =="[ ]") {bool = false;}
		
		}
		
		if(bool) {for(int i = 0 ; i<game.length ; i++) {
						System.out.print(game[i]);
						
						if(i%3 == 2) {System.out.println();};
					System.out.println("무승부입니다"); break;}
		
		//컴퓨터턴
		while(true) {
			int computer = ran.nextInt(8)+1; // 0~8
			if(game[computer].equals("[O]")|| game[computer].equals("[X]") ) {continue; }
			else {game[computer] = "[X]"; break;}
		}
		
		/*패배*/
	       if(( (game[0].equals("[X]") && game[1].equals("[X]") &&  game[2].equals("[X]")) ||
				(game[3].equals("[X]") && game[4].equals("[X]") &&  game[5].equals("[X]")) ||
				(game[6].equals("[X]") && game[7].equals("[X]") &&  game[8].equals("[X]")) ||   
				
				(game[0].equals("[X]") && game[3].equals("[X]") &&  game[6].equals("[X]")) ||
				(game[1].equals("[X]") && game[4].equals("[X]") &&  game[7].equals("[X]")) ||
				(game[2].equals("[X]") && game[7].equals("[X]") &&  game[8].equals("[X]")) ||   
				
				
				(game[0].equals("[X]") && game[4].equals("[X]") &&  game[8].equals("[X]")) ||
				(game[2].equals("[X]") && game[4].equals("[X]") &&  game[6].equals("[X]")) 
				)
		  ) {for(int i = 0 ; i<game.length ; i++) {
				System.out.print(game[i]);
				
				if(i%3 == 2) {System.out.println();};
	    	   System.out.println("패배했습니다!"); break;}	
	       }
		
		
		

		
			
		} // while e
		
	}
}
