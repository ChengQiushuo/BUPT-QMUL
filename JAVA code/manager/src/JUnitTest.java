
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Boundary.*;
import Control.PaymentManage.*;
import Control.FileManage.*;
import Entity.*;

import java.io.IOException;

class JUnitTest {

	@Test
	void test() throws IOException {
		ModifyMenu mm = new ModifyMenu();
		assertFalse(mm.compulsoryInfo.equals(null));
		assertFalse(mm.compulsoryArr.length <= 0);
		assertTrue(mm.compulsoryNumber >= 0 && mm.compulsoryNumber <= 15);
		assertFalse(mm.extrainfo.equals(null));
		assertFalse(mm.extraArr.length <= 0);
		assertTrue(mm.extraNumber >= 0 && mm.extraNumber <= 10);
		String test1_1 = "1";
		String test1_2 = "2";
		String[] test1_3 = {"3", "3", "3"};
		String[] test1_4 = {"4", "4", "4", "4"};
		Compulsory c1 = new Compulsory();
		c1.setDishID(test1_1);
		c1.setName(test1_2);
		c1.setOption(test1_3);
		assertEquals(test1_1, c1.getDishID());
		assertEquals(test1_2, c1.getName());
		assertEquals(test1_3, c1.getOption());
		Compulsory c2 = new Compulsory(test1_1, test1_2, test1_3, test1_4);
		assertEquals(test1_1, c2.getDishID());
		assertEquals(test1_2, c2.getName());
		assertEquals(test1_3, c2.getOption());
		assertEquals(test1_4, c2.getAvailability());
		String test2_1 = "1";
		String test2_2 = "2";
		double test2_3 = 3.33;
		String test2_4 = "4";
		Extra extra1 = new Extra();
		extra1.setDishID(test2_1);
		extra1.setName(test2_2);
		extra1.setPrice(test2_3);
		extra1.setAvailability(test2_4);
		assertEquals(test2_1, extra1.getDishID());
		assertEquals(test2_2, extra1.getName());
		
		assertEquals(test2_4, extra1.getAvailability());
		Extra extra2 = new Extra(test2_1, test2_2, test2_3, test2_4);
		assertEquals(test2_1, extra2.getDishID());
		assertEquals(test2_2, extra2.getName());
		
		assertEquals(test2_4, extra2.getAvailability());
		
		PaymentFile mp = new PaymentFile();
		assertEquals("./payment.json", mp.jsonFile);
		PaymentInfo pi = new PaymentInfo();
		assertFalse(pi.paymentfile.equals(null));
		String test3_1 = "1";
		String test3_2 = "2";
		Payment p1 = new Payment();
		p1.setName(test3_1);
		p1.setAvailability(test3_2);
		assertEquals(test3_1, p1.getName());
		assertEquals(test3_2, p1.getAvailability());
		Payment p2 = new Payment(test3_1, test3_2);
		assertEquals(test3_1, p2.getName());
		assertEquals(test3_2, p2.getAvailability());
		
		ReportShow rs = new ReportShow();
		assertFalse(rs.save_url.equals(""));
		AutomaticReport ar = new AutomaticReport();
		assertFalse(ar.status.equals(""));
		String test4_1 = "1";
		String test4_2 = "2";
		Email email = new Email(test4_1, test4_2);
		assertEquals(test4_1, email.getEmail());
		assertEquals(test4_2, email.getStatus());
	}

}
