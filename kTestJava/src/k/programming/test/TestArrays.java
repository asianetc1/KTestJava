package k.programming.test;

public class TestArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testArray1();
		testArray2();
		testArray3();
	}

	private static void testArray1() {
		String[] test2 = new String[7];
		test2[0] = "I";
		test2[1] = "Like";
		test2[2] = "Java";
		System.out.println(test2[0]);
		System.out.println(test2[1]);
	}

	private static void testArray2() {
		double[][] test3 = new double[3][2];
		test3[0][0] = 34.5;
		test3[0][1] = 23.7;
		test3[1][0] = 31.1;
		test3[1][1] = 56.5;
		System.out.println(test3[0][0]);
		System.out.println(test3[1][1]);
	}

	private static void testArray3() {
		String[] test4 = { "aaa", "bbb" };
		System.out.println(test4[0]);
	}

}
