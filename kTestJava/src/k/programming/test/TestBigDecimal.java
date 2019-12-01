package k.programming.test;

import java.math.BigDecimal;

public class TestBigDecimal {

	private double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double add(double a, double b) {
		BigDecimal ba = new BigDecimal(a);
		BigDecimal bb = new BigDecimal(b);
		BigDecimal result = ba.add(bb);
		return result.doubleValue();
	}

	public double subtract(double a, double b) {
		BigDecimal ba = new BigDecimal(a);
		BigDecimal bb = new BigDecimal(b);
		BigDecimal result = ba.subtract(bb);
		return result.doubleValue();
	}

	public double divide(double a, double b) {
		BigDecimal ba = new BigDecimal(a);
		BigDecimal bb = new BigDecimal(b);
		BigDecimal result = ba.divide(bb, 8, 0);
		return result.doubleValue();
	}

}
