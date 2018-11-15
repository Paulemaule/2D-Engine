package base.utility.maths;

public final class Vector {
	private final double x;
	private final double y;
	private final String name;
	
	//Constructor, x and y are the base coordinates of the vector, the name of the vector will be "none"
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
		name = "none";
	}
	
	//Constructor, x and y are the base coordinates of the vector and name the name of the vector
	public Vector(double x, double y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	//returns the x coordinate
	public double getX() {
		return x;
	}
	
	//returns the x coordinate rounded to an integer value
	public int getIntX() {
		return Maths.round(x);
	}
	
	//returns the y coordinate
	public double getY() {
		return y;
	}
	
	//returns the y coordinate rounded to an integer value
	public int getIntY() {
		return Maths.round(y);
	}
	
	//returns the norm(/length) of the vector
	public double norm() {
		return Math.sqrt(Vector.skalProd(this, this));
	}
	
	//returns the angle (in radian) between the vector and the x-axis, where 0 is set for v=lambda*(1,0)
	public double phi() {
		if (x > 0 & y >= 0) {
			return Math.atan(y / x);
		} else if (x > 0 & y < 0) {
			return Math.atan(y / x) + 2 * Math.PI;
		} else if (x < 0) {
			return Math.atan(y / x) + Math.PI;
		} else if (x == 0 & y > 0) {
			return Math.PI / 2;
		} else if (x == 0 & y < 0) {
			return Math.PI * 3 / 2;
		} else {
			return -1;
		}
	}
	
	//outputs the name x,y and r,phi coordinates to the textbox
	public void print() {
		System.out.println("  << '"+name+"'"+" ; kartesian = (" + Maths.roundTo(x, 3) + " , " + Maths.roundTo(y, 3)
				+ ") : polar = (" + Maths.roundTo(norm(), 3) + " , "
				+ Maths.roundTo(phi() * (360 / (2 * Math.PI)), 3) + "°) >>");
	}
	
	//returns a new vector that is the sum of the two input vectors
	public static Vector add(Vector v, Vector w) {
		return new Vector(v.getX()+w.getX(),v.getY()+w.getY());
	}
	
	//returns a new vector that is the scalar multiplicative of lambda and v
	public static Vector skalMult(double lambda, Vector v) {
		return new Vector(lambda*v.getX(),lambda*v.getY());
	}
	
	//return the scalar product of the two input vectors
	public static double skalProd(Vector v, Vector w) {
		return v.getX()*w.getX()+v.getY()*w.getY();
	}
}
