package Control.LoginManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: Login.java 
 * packageName: Control.LoginManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */

/**
 * ClassName: Login<br>
 * Description: This is the control class that used to control the manager login process
 * @version V2.0
 */
public class Login {
	private String password = "123abc";
	
	/**
	* This constructor used to do nothing
	*/
	public Login() {
		
	}

	
	/**
	* Used to do the manager validation
	* @param pass the input of the user
	* @return boolean true when input password is correct, false when input is incorrect
	*/
	public boolean isSuccessful(String pass) {
		if(pass.equals(this.password)) {
			return true;
		}
		else {
			return false;
		}
	}
}
