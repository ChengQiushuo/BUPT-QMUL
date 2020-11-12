package Entity;
/** 
 * projectName: SoftwareEngineering
 * fileName: Email.java 
 * packageName: Entity
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */

/**
 * ClassName: Email<br>
 * Description: This is the entity class that used to store<br>
 * the information about an email
 * @version V2.0
 */
public class Email {
	private String Email;
	private String Status;
	
	/**
	* This constructor is used to initialize a Email object, set the instance variables it has
	* @param email the name of an email
	* @param Status the status of email service(send or not send)
	*/
	public Email(String email,String Status) {
		this.Email = email;
		this.Status = Status;
	}
	
	/**
	* Used to get the email name(address)
	*@return String the address of the email
	*/
	public String getEmail() {
		return Email;
	}
	
	/**
	* Used to set the email name(address)
	* @param email the email name(address)
	*/
	public void setEmail(String email) {
		Email = email;
	}
	
	/**
	* Used to get the email service status
	*@return String the status of the email service(send or not send)
	*/
	public String getStatus() {
		return Status;
	}
	
	/**
	* Used to set the email service status
	* @param status the availability of the email service(Yes or No)
	*/
	public void setStatus(String status) {
		Status = status;
	}
	

}
