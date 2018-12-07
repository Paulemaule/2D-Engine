package base.utility.maths;

public final class Vector {
	//q1 is the x coordinate and q2 the y coordinate
	public static final int CARTESIAN = 1;
	//q1 is the norm and q2 is the angle phi (in radian) relative to the positive x-axis
	public static final int POLAR = 2;
	
	private final double x;
	private final double y;
	private final String name;
	
	//Constructor, x and y are the base coordinates of the vector, the name of the vector will be "none"
	public Vector(double x, double y) {
		this(x,y,"none");
	}
	
	//Constructor, x and y are the base coordinates of the vector and name the name of the vector
	public Vector(double x, double y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	//Constructor, q1 and q2 are the base coordinates of the vector in the specified coordinate system,
	//the name of the vector will be "none"
	public Vector(double q1, double q2, int coordinateSystem) {
		this(q1,q2,coordinateSystem,"none");
	}
	
	//Constructor, q1 and q2 are the base coordinates of the vector in the specified coordinate system,
	//name will be its name
	public Vector(double q1, double q2, int coordinateSystem, String name) {
		switch(coordinateSystem) {
		case CARTESIAN:
			x = q1;
			y = q2;
			break;
		case POLAR:
			x = q1 * Math.cos(q2);
			y = q1 * Math.sin(q2);
			break;
		default:
			x = 0;
			y = 0;
			break;
		}
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
	
	//outputs the name x,y and r,phi coordinates to the console
	public void print() {
		System.out.println("  << '"+name+"'"+" ; kartesian = (" + Maths.roundTo(x, 3) + " , " + Maths.roundTo(y, 3)
				+ ") : polar = (" + Maths.roundTo(norm(), 3) + " , "
				+ Maths.roundTo(phi() * (360 / (2 * Math.PI)), 3) + "°) >>");
	}
	
	//returns a new vector that is the input vector rotated by phi counterclockwise
	public static Vector rotateBy(Vector v, double phi) {
		return new Vector(v.norm(),v.phi()+phi,Vector.POLAR);
	}
	
	//returns a new vector that is the input vector normed to the specified lenght
	public static Vector normTo(Vector v, double norm) {
		return new Vector(norm, v.phi(), POLAR);
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
