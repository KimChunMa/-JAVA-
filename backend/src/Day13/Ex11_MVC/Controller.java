package Day13.Ex11_MVC;

import java.util.ArrayList;

public class Controller {
	//싱글톤
	private Controller () {};
	private static Controller ctr = new Controller();
	public static Controller getInstand() {return ctr;}
	
	//제품 등록
	public boolean pSubmit(String pname, int pprice, int inventory) {
		boolean result = ProductDao.getInstand().pSubmit(pname, pprice, inventory);
		return result;
	}
	
	//제품 출력
	public ArrayList<ProductDto> list() {
		return  ProductDao.getInstand().list();
	}
	
	//제품 수정 이름,가격
	public boolean pEdit(int pno,String pname , int pprice) {
		boolean result = ProductDao.getInstand().pEdit(pno, pname, pprice);
		return result;
	}
	
	//제품 재고 변경
	public boolean iEdit(int pno , int inventory) {
		boolean result = ProductDao.getInstand().iEdit(pno, inventory);
		return result;
	}
	
	//제품 삭제
	public boolean delete(int pno) {
		boolean result = ProductDao.getInstand().delete(pno);
		return result;
	}
	
	//사용자용
	//사용자 제품 출력
	public ArrayList<ProductDto> clist() {
		return  ProductDao.getInstand().list();
	}
	
	//입력시 장바구니 넣기
	public boolean pclick(int pno) {
		return ProductDao.getInstand().pclick(pno);
	}
	
	//장바구니 출력
	public ArrayList<ProductDto> blist() {
		return ProductDao.getInstand().blist();
	}
	
	
	//재고감소
	public boolean min() {
		return ProductDao.getInstand().min();
	}
}
