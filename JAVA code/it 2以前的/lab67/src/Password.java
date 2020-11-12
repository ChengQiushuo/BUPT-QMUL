public class Password {
	public static String passwordTest(String password) {
		int i=0;
		int a = 0;
		int b = 0;
		char c='a';
		for(;i < password.length();i++)
		{
			c=password.charAt(i);
			if((c>='0'&&c<='9')||(c>='A'&&c<='z'));
			else
				return "the password is not valid";

			if (c>='A'&&c<='z')
				a++;
			if(c>='0'&&c<='9')
				b++;
			System.out.println(c);
		}
		System.out.println(i);
		if (i<6||i>10)
			return "the password is not valid";
		if(a==0||b==0)
			return "the password is not valid";
		return "The password is valid";
	}

}

