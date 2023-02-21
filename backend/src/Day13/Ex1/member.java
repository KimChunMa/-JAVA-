package Day13.Ex1;

public class member {
	public  String id;
	
	member(String id){
		this.id = id;
	}
	
	@Override 
	public boolean equals(Object obj) {
		
		/*
		 // if( obj instanceof Member target) { // jdk16 이상
			// 부모객체 instanceof 자식클래스 변환객체명
			// obj -> target 
		 */
		
		if(obj instanceof member ) {
			member target = (member) obj;
			if(id.equals(target.id)) {
				return true;
			}
		}
		return false;
	}
}
