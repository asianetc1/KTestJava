package k.programming.test;

public class TestByte {

	public static void main(String[] args) {
		byte[] b = new byte[]{12, 89, 100};
		System.out.println("k>TestByte.main - b.toString():" +b.toString() );	//t+++

		String s = "abc  ";
		byte[] b2 = s.getBytes();
		for (int i = 0; i < b2.length; i++) {
			System.out.println("k>TestByte.main - :[" + b2[i] + "]");	//t+++
		}
	}

}
