package k.programming.test;

import java.io.IOException;

public class TestSystem {

	public static void main(String[] args) {
		System.out.println("k>TestSystem.main - :" );	//test+++
		try {
			Runtime.getRuntime().exec("C:\\kStock\\kStock.bat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
