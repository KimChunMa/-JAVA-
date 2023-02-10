package Day08.Ex2;

public class Korean {
	//필드
	String nation = "대한민국";
	String name;
	String ssn;
	
	
	 Korean() {} 
	 Korean(String name, String ssn){ 
		 this.name = name;
		 this.ssn = ssn;
	 }
	 
	@Override
	public String toString() {
		return "ko [nation: "+ nation + " name:" + name+" ssn: " + ssn+"]";
	} 
	 

	}

