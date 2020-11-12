package Control.PaymentManage;
import Control.FileManage.*;
import Entity.Payment;
public class ModifyPayment {
	public PaymentFile paymentfile = new PaymentFile();
	public void ChangePayment(Payment[] paymentArr) {
		paymentfile.modifyPayment(paymentArr);
	}
	public void deletePayment(int num) {
		paymentfile.deletePayment(num);
	}
	public void addPayment(String name) {
		paymentfile.addPayment(name);
	}
	
}
