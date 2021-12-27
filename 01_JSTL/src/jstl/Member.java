package jstl;

public class Member{
	//자료형을 하나 만든다는 개념으로 !
	private String name;
	private String phone;
	
	public Member() {
		name="홍길동";
		phone="010-1111-1111";
	}
	
	public Member(String name,String phone) {
		this.name=name;
		this.phone=phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
