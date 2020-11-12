package Control.PaymentManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: PaymentInfo.java 
 * packageName: Control.PaymentManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import Control.FileManage.PaymentFile;
import Entity.Payment;

/**
 * ClassName: PaymentInfo<br>
 * Description: This is the information class that used to control<br>
 * the information about the payment ways read from file
 * @version V2.0
 */
public class PaymentInfo {
	/**the file control class used to operating on .json file*/
public  PaymentFile paymentfile = new PaymentFile();
	
    /**
    * Used to get the object array of payment which contains all the information about payment ways<br>
    * by calling control file class
    * @return Payment[] the object array of payment ways
    */
	public  Payment[] getPaymentInfo(){
				return paymentfile.getPaymentInfo();
	}
	
	/**
	* Used to get the number of payment ways by calling control file class
	* @return int the number of payment ways
	*/
	public int getPaymentNum() {
		return paymentfile.getPaymentNum();
	}
}
