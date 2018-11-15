package base.utility.maths;

public final class Maths {
	public static int round(double x) {
		return Math.round(Math.round(x));
	}

	public static double roundTo(double x, int n) {
		return Maths.round(x * Math.pow(10, n)) / Math.pow(10, n);
	}

	public static double random(double low, double high) {
		return (Math.random() * (high - low) + low);
	}
}

