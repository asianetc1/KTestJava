package k.programming.test;

import k.programming.data.Data;

public class TestClone {

	public static void main(String[] args) throws CloneNotSupportedException {

		Data d1 = new Data();
		Data d2 = (Data)d1.clone();

		d1.setName("aaa");
		d2.setName("bbb");
		System.out.println("k>TestClone.main - d1:" + d1.getName());	//t+++
		System.out.println("k>TestClone.main - d2:" + d2.getName());	//t+++
	}

}
