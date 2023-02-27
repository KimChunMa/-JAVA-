package Day15.Ex6;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean musicState = false;
		boolean movieState = false;
		
		Music music = new Music(); 
		Movie movie = new Movie();
		
		while(true) {
			System.out.print("1.음악재생 2. 영화재생 : ");
			int ch = sc.nextInt();
			
			//1번 + 음악상태 끔 
			if(ch == 1 && musicState == false) {
				music.start();
				musicState = true;
				music.stop = true;
			}
			
			//1번 + 음악상태 킴
			else if( ch == 1 && musicState == true) {
				musicState = false;
				music.stop = false;
				music = new Music(); // 음악스레드 초기화
			}
			
			else if(ch == 2 && movieState == false) {
				movie.start();
				movieState = true;
				movie.stop = true;
			}
			
			else if(ch == 2 && movieState == true) {
				movieState = false;
				movie.stop = false;
				movie = new Movie();
			}
		}
	}
}
