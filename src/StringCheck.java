
public class StringCheck {

	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "Hello";
		String str3 = new String("Hello");
		str2 = str1+" World";
		System.out.println(str2);
		System.out.println(str1);
		System.out.println(str1 ==str2);
		System.out.println(str1 ==str3);
		System.out.println(str1.equals(str3));
	}

}
