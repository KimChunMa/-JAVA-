package Day09.Ex10_게시판;

import Day09.Ex10_게시판.view.Front;

/*
	- 1. start[main함수] 클래스가 front 클래스를 호출 
	- 2. front 클래스에서 사용자로부터 입·출력 받기 
	- 3. Bcontroller 클래스에서 front로부터 전달받은 데이터를 처리/로직 
	- 4. Board 클래스에서 게시물의 모델링	
*/
public class Start {
	public static void main(String[] args) {
		 Front.getInstance().index();
	}
}
