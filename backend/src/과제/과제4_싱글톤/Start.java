package 과제.과제4_싱글톤;

import 과제.과제4_싱글톤.view.Front;

public class Start {
	public static void main(String[] args) {
			Front.getInstance().index();
	}
}

/*
 	M 데이터 모델링 [저장하고자 하는 데이터들의 설계]
 	V 입력 / 출력
 	C 제어/ 비지니스 로직 / 기능
	
	예) 회원가입
	V : 아이디, 비밀번호 입력 만							(HTML)
	C : 입력받은 데이터 유효성 검사후 저장					(java)
	M : 컨트롤이 데이터를 저장할 때 사용되는 모델링/설계도		(DB)
 */