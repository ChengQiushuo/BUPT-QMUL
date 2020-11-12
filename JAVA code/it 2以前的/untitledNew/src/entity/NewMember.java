package entity;

public class NewMember {
	private String member_number;
	private String first_name;
	private String last_name;
	private String email;
	private String mobile_number;

	public NewMember(String l1,String l2,String l3,String l4,String l5) {
		member_number = l1;
		first_name = l2;
		last_name = l3;
		email = l4;
		mobile_number =l5;
	}
	public String getMember_number() {
		return member_number;
	}
	public void setMember_number(String member_number) {
		this.member_number = member_number;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
}
