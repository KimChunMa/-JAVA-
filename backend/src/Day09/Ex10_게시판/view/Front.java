package Day09.Ex10_게시판.view;

import java.util.Scanner;

public class Front {
	//싱글톤 
	private static Front fr = new Front();
	private Front() {};
	public static Front getInstance() {return fr;}
	
	//필드
	private Scanner sc = new Scanner(System.in);
	
	
	//index 함수
	public void index() {
		while(true) {
		System.out.println("1. 쓰기 : "); int ch = sc.nextInt();
		if(ch == 1) {writer_page();}
		}//while e
	}
	
	//쓰기 페이지 함수
	private void writer_page() {
		System.out.println("쓰기");
	}
	
	//출력 페이지 함수
	private void print_page() {
		
	}
	
	
}
