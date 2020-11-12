package Control.PaymentManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: ModifyPayment.java 
 * packageName: Control.PaymentManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import Control.FileManage.*;
import Entity.Payment;

/**
 * ClassName: ModifyPayment<br>
 * Description: This is the control class that used to control the payment ways.<br>
 * Like adding payment, deleting payment, setting availability.
 * @version V2.0
 */
public class ModifyPayment {
	/**the file control class used to operating on .json file*/
	public PaymentFile paymentfile = new PaymentFile();
	
	/**
	* Used to set the availability of each payment way
	* @param paymentArr the object array of payment ways
	*/
	public void ChangePayment(Payment[] paymentArr) {
		paymentfile.modifyPayment(paymentArr);
	}
	
	/**
	* Used to delete a payment way
	* @param num the index of this payment way in the object array of payment ways
	*/
	public void deletePayment(int num) {
		paymentfile.deletePayment(num);
	}
	
	/**
	* Used to add a payment way
	* @param name the name of the new payment way
	*/
	public void addPayment(String name) {
		paymentfile.addPayment(name);
	}
	
}
