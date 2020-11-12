package Entity;

public class Email {
	private String Email;
	private String Status;
	public Email(String email,String Status) {
		this.Email = email;
		this.Status = Status;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	

}
