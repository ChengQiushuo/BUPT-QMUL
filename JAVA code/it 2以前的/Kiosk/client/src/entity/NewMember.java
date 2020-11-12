package entity;
/**
 * Title        : NewMember.java
 * Description  : This class is used for generating a new membership.
 * @author      : Yutong Chai
 * @author 		: Jiaqi Zhang
 * @version     : 1.1
 */
public class NewMember {
	private String member_number;
	private String first_name;
	private String last_name;
	private String email;
	private String mobile_number;
	/**
	 * NewMember constructor with parameters.
	 * Process the information.
	 * @param l1 The membership number.
	 * @param l2 The first name.
	 * @param l3 The last name.
	 * @param l4 The email.
	 * @param l5 The mobile number.
	 */
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
	/**
	 * Setters.
	 */
	public void setMember_number(String member_number) {
		this.member_number = member_number;
	}
	/**
	 * Getters.
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * Setters.
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * Getters.
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * Setters.
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * Getters.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setters.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Getters.
	 */
	public String getMobile_number() {
		return mobile_number;
	}
	/**
	 * Setters.
	 */
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
}
