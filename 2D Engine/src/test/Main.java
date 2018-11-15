package test;

import base.Base;
import base.utility.maths.Vector;

public class Main {

	public static void main(String[] args) {
		Base.initialize("TEST221",new Vector(800,500));
		Base.getWorld().addEntity(new TestThing());
		Base.startLoop();
	}
}
