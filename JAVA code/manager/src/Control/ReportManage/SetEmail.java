package Control.ReportManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: SetEmail.java 
 * packageName: Control.ReportManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import Control.FileManage.EmailFile;
import Entity.Email;

/**
 * ClassName: SetEmail<br>
 * Description: This is the medium class that used to control<br>
 * the setting about the  sending email service
 * @version V2.0
 */
public class SetEmail {
	private EmailFile emailfile = new EmailFile();
	
	/**
	* Used to set the email service information by calling control file class, like status, name.
	* @param email the email name(email address)
	*/
	public void SetNewEmail(Email email) {
		emailfile.SetEmail(email);
	}
}
