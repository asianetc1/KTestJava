package k.programming.test;

import java.util.Random;

public class TestRandom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int i = 0;
		for (int j = 0; j < 10; j++) {
			i = r.nextInt(10);
			System.out.println("- i:" + i); // test+++
		}

	}

}
