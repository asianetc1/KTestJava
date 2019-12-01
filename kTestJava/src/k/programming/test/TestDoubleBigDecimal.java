package k.programming.test;

import java.math.BigDecimal;

public class TestDoubleBigDecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double amount = 12345.67;
		double balance = 123.4567;

		BigDecimal amountBig = new BigDecimal(amount);

		System.out.println("- amount:" + amount); // test+++
		System.out.println("- balance:" + balance); // test+++
		System.out.println("- amountBig:" + amountBig); // test+++

		TestBigDecimal testBigDecimal = new TestBigDecimal();
		testBigDecimal.setAmount(amount);
		double add = testBigDecimal.add(amount, balance);
		double subtract = testBigDecimal.subtract(amount, balance);
		double divide = testBigDecimal.divide(amount, balance);

		System.out.println("- add:" + add); // test+++
		System.out.println("- subtract:" + subtract); // test+++
		System.out.println("- divide:" + divide); // test+++
	}
}
