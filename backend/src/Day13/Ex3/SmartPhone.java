package Day13.Ex3;

public class SmartPhone {
	private String company;
	private String os;
	
	public SmartPhone(String company, String os) {
		super();
		this.company = company;
		this.os = os;
	}
	
	@Override
	public String toString() {

		return company+" " + os;
	}
	
	
}
