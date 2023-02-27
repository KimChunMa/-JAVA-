package Day15.Ex3;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
//일시정지
public class 실헹 {
	public static void main(String[] args) {
		//1.
		/*
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0 ; i < 3 ; i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000); // 1초간 정지 [3초간 cpu(명령어처리) 자원 점유 불가]
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		*/
		
		/*
		//2 콘솔로 시계만들기
		while(true) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss초");
			System.out.println(sdf.format(date));
			try {Thread.sleep(1000);}
			catch (Exception e) {}
			for(int i = 0 ; i < 100 ; i++) {System.out.println();} //100줄공백
		}
		*/
		
		//3
		SumThread sum = new SumThread();
		sum.start();
		System.out.println(sum.getSum()); //0
		
		try {sum.join();} 
		catch (InterruptedException e) {e.printStackTrace();}
		
		System.out.println(sum.getSum()); // 4950
		
	}
}
