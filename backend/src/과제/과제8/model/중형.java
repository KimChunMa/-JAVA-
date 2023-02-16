package 과제.과제8.model;

import 과제.과제8.model.지역.광주;
import 과제.과제8.model.지역.대구;
import 과제.과제8.model.지역.대전;
import 과제.과제8.model.지역.부산;

public class 중형 extends Car{
	
	public 중형(int ch2) {
		super();
		km=2;
		
		location = locations[ch2];
		if(ch2 == 1){distance = 대전.getInstance().getDistance(); }
		else if(ch2 == 2){distance = 대구.getInstance().getDistance();}
		else if(ch2 == 3){distance = 부산.getInstance().getDistance();}
		else if(ch2 == 4){distance = 광주.getInstance().getDistance();}
		time = distance/km;
		
		price = distance*2000; 
	}
}
