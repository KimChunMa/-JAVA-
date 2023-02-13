package Day09.EX04;
/*
	오버로딩 : 이름은 같되 매개변수 타입, 갯수 다름
 	오버라이딩: 메소드 재정의
 
 
*/
public class Calculator {
	double 사각형넓이(double width) {
		return width*width;
	}
	
	double 사각형넓이(double width, double height) {
		return width*height;
	}
}
