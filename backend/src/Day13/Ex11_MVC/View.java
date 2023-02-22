package Day13.Ex11_MVC;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	//싱글톤
	private View () {};
	private static View view = new View();
	public static View getInstand() {return view;}
	
	Scanner sc = new Scanner(System.in);
	
	public void index() {
		while(true) {
		System.out.println("1 관리자 2. 사용자"); int ch0 = sc.nextInt();
		
			if(ch0==1) {
				while(true) {
				System.out.println("-------선택란------");
				System.out.println("1 제품 등록[C]  2 제품 출력[R] 3 제품 수정[U] \n4 제품 재고변경/수정[U]  5 제품 삭제[D] 6 뒤로가기");
				int ch = sc.nextInt();
				
				if(ch==1) {pSubmit();}
				else if(ch==2) {list();}
				else if(ch==3) {pEdit();}
				else if(ch==4) {iEdit();}
				else if(ch==5) {delete();}
				else if(ch==6) {break;}
				else {System.out.println("잘못된 입력입니다.");}
				}//while che
			}
		
		
			else if (ch0==2) {
			
				while(true) {
					clist();
					System.out.println("0:결제 1:제품번호 입력받기 2:뒤로가기");  int ch1 = sc.nextInt();
					
					if(ch1==0) {pay();}
					else if(ch1==1) {pclick();}
					else if(ch1==2) {break;}
					else {System.out.println("잘못된 입력입니다.");}
				}
			}
		
		}//while(ch0) e
	}//index e
	//------------------관리자----------------------
	//제품 등록
	public void pSubmit() {
		System.out.print("제품이름을 입력해주세요."); String pname = sc.next();
		System.out.print("제품가격을 입력해주세요."); int pprice = sc.nextInt();
		System.out.print("제품재고을 입력해주세요."); int inventory = sc.nextInt();
		
		boolean result =
		Controller.getInstand().pSubmit(pname, pprice, inventory);
		
		if (result) {System.out.println("[알림] 제품등록 성공!");}
		else {System.out.println("[알림]제품등록 실패!");}
	}
	
	//제품 출력
	public void list() {
		System.out.println("--------출력------");
		System.out.printf("%2s \t %8s \t %8s \t %10s\n","번호","이름","가격","재고");
		ArrayList<ProductDto> result = Controller.getInstand().list();
		for(ProductDto dto : result) {
			System.out.printf("%2d \t %8s \t %8d \t %10d\n",
			dto.getPno(),dto.getPname(),dto.getPprice(),dto.getInventory());
		}
	}//list ()
	
	//제품수정 이름,가격
	public void pEdit() {
		System.out.println("--------수정-------");
		System.out.print("변경할 제품 번호:"); int pno = sc.nextInt(); 
		System.out.print("변경될 제품 이름:"); String pname = sc.next();
		System.out.print("변경될 제품 가격: "); int pprice = sc.nextInt();
		boolean result = Controller.getInstand().pEdit(pno, pname, pprice);
		if(result) {System.out.println("[알림] 제품 변경 완료!");}
		else {System.out.println("[알림] 제품 변경 실패");}
	}
	
	//제품 재고 변경
	public void iEdit() {
		System.out.println("--------재고 수정-------");
		System.out.print("변경할 제품 번호:"); int pno = sc.nextInt();
		System.out.print("변경될 재고 :"); int inventory = sc.nextInt();
		boolean result = Controller.getInstand().iEdit(pno, inventory);
		if(result) {System.out.println("[알림] 제품 재고 변경 완료!");}
		else {System.out.println("[알림] 제품 재고 변경 실패");}
	}
	
	//제품삭제
	public void delete() {
		System.out.println("------제품 삭제------");
		System.out.print("삭제할 제품 번호:"); int pno = sc.nextInt();
		boolean result =Controller.getInstand().delete(pno);
		if(result) {System.out.println("[알림] 제품 삭제 완료!");}
		else {System.out.println("[알림] 제품 삭제 실패");}
	}
	
	//---------------사용자---------------
	//사용자 제품 출력
	public void clist() {
		System.out.println("--------출력------");
		System.out.printf("%2s \t %8s \t %8s \t %10s\n","번호","이름","가격","상태");
		
		ArrayList<ProductDto> result = Controller.getInstand().list();
		for(ProductDto dto : result) {
			System.out.printf("%2d \t %8s \t %8d \t ",
			dto.getPno(),dto.getPname(),dto.getPprice());
			
			if(dto.getInventory()>=1) {
				System.out.printf("%10s\n","판매중");
			}else {
				System.out.printf("%10s\n","재고부족");
			}
		}
	}//list ()
	
	//제품번호받기
	public void pclick() {
		System.out.println("선택한 제품번호를 입력해주세요."); int pno = sc.nextInt();
		boolean result = Controller.getInstand().pclick(pno);
		
		if(result) {System.out.println("장바구니에 담겼습니다."); }
		else {System.out.println("재고가 없습니다.");}

	}//pclick() e
	
	//결제
	public void pay() {
		
		ArrayList<ProductDto> result =  Controller.getInstand().blist();
		
		 System.out.println("-----장바구니-----");
		  System.out.printf("%2s \t %8s \t %8s\n","번호","이름","가격"); 
		  for(ProductDto dto : result) {
			  System.out.printf("%2d \t %8s \t %10d\n",
		  dto.getPno(),dto.getPname(),dto.getPprice()); }
		  
		  Controller.getInstand().min();
		  System.out.println("결제완료");
		
	}
}
