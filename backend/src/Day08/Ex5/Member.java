package Day08.Ex5;

public class Member {
	String name;
	String phone;
	
	public Member() {}
	
	public Member(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "member [name=" + name + ", phone=" + phone + "]";
	}

	


}
