package 과제.과제8.controller;

public class location {

	//싱글톤
	private location() {};
	private static location lo = new location();
	public static location getInstance() {return lo;}

	
	
	
	
}
