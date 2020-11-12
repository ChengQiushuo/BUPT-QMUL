import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordTest {

	@Test
	void testlength() {
		String a = Password.passwordTest("1");
		assertEquals("the password is not valid",a);
		}
	@Test
	void testletterdigits() {
		String a = Password.passwordTest(";");
		assertEquals("the password is not valid",a);
	}
	@Test
	void testleast() {
		String a = Password.passwordTest("111111");
		assertEquals("the password is not valid",a);
	}
	@Test
	void testblank() {
		String a = Password.passwordTest("123a aa");
		assertEquals("the password is not valid",a);
	}
	@Test
	void testcorrect() {
		String a = Password.passwordTest("123aaa");
		assertEquals("The password is valid",a);
	}
}
