package 과제.과제9.개발툴;

import 과제.과제9.개발툴.implement1.비쥬얼스튜디오;
import 과제.과제9.개발툴.implement1.이클립스;
import 과제.과제9.개발툴.implement1.인텔리제이;
import 과제.과제9.개발툴.interface0.소프트웨어;
import 과제.과제9.개발툴.interface0.오류;
import 과제.과제9.개발툴.interface0.콘솔;

public class 개발툴 {
	소프트웨어 E1 = new 이클립스("이클립스","E","Jvm");
	오류 E2 = new 이클립스("이클립스","E","Jvm");
	콘솔 E3 = new 이클립스("이클립스","E","Jvm");
	
	소프트웨어 In1 = new 인텔리제이("인텔리제이","In");
	오류 In2 = new 인텔리제이("이클립스","E");
	콘솔 In3 = new 인텔리제이("이클립스","E");
	
	
	소프트웨어 Vs1 = new 비쥬얼스튜디오("비쥬얼스튜디오","VS","api");
	오류 Vs2 = new 비쥬얼스튜디오("비쥬얼스튜디오","VS","api");
	콘솔 Vs3 = new 비쥬얼스튜디오("비쥬얼스튜디오","VS","api");
}
