package 과제.과제9.개발툴.implement1;

import 과제.과제9.개발툴.interface0.소프트웨어;
import 과제.과제9.개발툴.interface0.오류;
import 과제.과제9.개발툴.interface0.콘솔;
import 과제.과제9.개발툴.super2.super_sw필드;

public class 비쥬얼스튜디오  extends super_sw필드 implements 소프트웨어,오류,콘솔{
	//멤버
	String api;
	
	
	//생성자
	public 비쥬얼스튜디오(String name, String icon,String api) {
		super(name,icon);
		this.api = api;
	}
	
	//메소드
	@Override
	public void consol() {
		System.out.println(name+api+" 프로그램 콘솔");
		
	}

	@Override
	public void shortcut() {
		System.out.println(name+" 바로가기");
		
	}
	
	@Override
	public void error() {
		System.out.println(name+"  에러발생");
		
	}
	
	
}
