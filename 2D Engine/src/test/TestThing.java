package test;

import base.gui.Window.Brush;
import base.utility.maths.Vector;
import base.world.Entity;
import base.world.World;

public class TestThing implements Entity{
	private Vector loc = new Vector(0,0);

	@Override
	public void addedTo(World w) {
		
	}

	@Override
	public void run(int t) {
		Vector v = Vector.skalMult(t, new Vector(0.01,0.01));
		loc = Vector.add(v, loc);
	}

	@Override
	public void draw(Brush b) {
		b.fillRect(loc, new Vector(22,100));
	}

}
