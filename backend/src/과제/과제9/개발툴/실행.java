package 과제.과제9.개발툴;

import 과제.과제9.개발툴.implement1.인텔리제이;

public class 실행 {
	public static void main(String[] args) {
		개발툴 tool = new 개발툴();
		
		tool.E1.shortcut();
		tool.E2.error();
		tool.E3.consol();
		
		tool.In1.shortcut();
		tool.In2.error();
		tool.In3.consol();
		
		tool.Vs1.shortcut();
		tool.Vs2.error();
		tool.Vs3.consol();
		
		
		tool.E1 = new 인텔리제이("인텔리제이","In");
		tool.E1.shortcut();
		System.out.println(tool.E1 instanceof 인텔리제이);
	}
}
