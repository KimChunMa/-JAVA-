package Day06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex3_문자열2 {
	public static void main(String[] args) throws Exception {
		
		while(true) {
		System.out.print("입력하시오:");
		//스택     <=                 힙
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine()+'\n';
		System.out.println(input);
		
		//2 문자열 파일 저장 [자바와 키보드/ 파일/ 네트워크 등 통신할때 무조건 바이트단위]
		//자바에 나가서 파일을 씀 .write메소드 제공
		//문자열.getBytes(): 해당 문자열을 바이트배열로 반환
		
		//FileOutputStream fout = new FileOutputStream("c:/java/test.txt"); 
		//FileOutputStream fout = new FileOutputStream("c:/java/test.txt", true); 
		//트루가 없으면 덮어쓰기, 있으면 이어쓰기 
		
		
		
		FileOutputStream fout = new FileOutputStream("c:/java/test.txt",true); 
		
		
		
		fout.write(input.getBytes());
		} 
	}
}
