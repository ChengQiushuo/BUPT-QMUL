package Control.PaymentManage;

import java.io.IOException;

import Control.FileManage.PaymentFile;
import Entity.Payment;

public class PaymentInfo {
public  PaymentFile paymentfile = new PaymentFile();
	
	public  Payment[] getPaymentInfo() throws IOException {
				return paymentfile.getPaymentInfo();
	}
	
	public int getPaymentNum() {
		return paymentfile.getPaymentNum();
	}
}
