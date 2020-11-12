package Control.LoginManage;

public class Login {
	private String password = "123abc";
	public Login() {
		
	}

	public boolean isSuccessful(String pass) {
		if(pass.equals(this.password)) {
			return true;
		}
		else {
			return false;
		}
	}
}
