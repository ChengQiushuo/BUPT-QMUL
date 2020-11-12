package Control.ReportManage;
import Control.FileManage.EmailFile;
import Entity.Email;
public class SetEmail {
	private EmailFile emailfile = new EmailFile();
	public void SetNewEmail(Email email) {
		emailfile.SetEmail(email);
	}
}
