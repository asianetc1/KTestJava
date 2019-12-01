package k.programming.test;

public class TestString {

	public static void main(String[] args) {
		System.out.print("Hello!" + (char)13);
		//System.out.print("      ");
		System.out.print("Hello");
		System.out.print('\b');
		
		String name="Guru";
		char bc='\b';
		System.out.print(name+bc);
		
//		System.out.println("k>TestString.main - :" + "abcd".substring(0, 2));	//test+++
		System.out.println("k>TestString.main - :" + "abcd".substring(2, 4));	//test+++
		
		String trade_amount = "abcd";
		String s = trade_amount.substring(trade_amount.length()-1, trade_amount.length());
		System.out.println("k>TestString.main - s:" + s);	//test+++
		
	}

}
