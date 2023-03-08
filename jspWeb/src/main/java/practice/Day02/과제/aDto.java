package practice.Day02.과제;

public class aDto {
	private String name ;
    private String tel ;
    private float tall;
    
    private int age;
    private String sub ;
    private String sex ;
    
    private boolean agree ;
    private String region ;
    private String introduce ;
    
	public aDto(String name, String tel, float tall, int age, String submit, String sex, boolean agree, String region,
			String introduce) {
		super();
		this.name = name;
		this.tel = tel;
		this.tall = tall;
		this.age = age;
		this.sub = submit;
		this.sex = sex;
		this.agree = agree;
		this.region = region;
		this.introduce = introduce;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public float getTall() {
		return tall;
	}

	public void setTall(float tall) {
		this.tall = tall;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSubmit() {
		return sub;
	}

	public void setSubmit(String submit) {
		this.sub = sub;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
    
    
    
    
}
