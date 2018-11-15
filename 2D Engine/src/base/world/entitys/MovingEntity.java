package base.world.entitys;

import java.awt.Color;

import base.utility.maths.Vector;

public class MovingEntity extends BasicShapedEntity{
	private Vector velo;
	private int borderBehavior;
	
	public MovingEntity(Vector loc, Vector size, Color c, int shape, Vector velocity) {
		super(loc, size, c, shape);
		velo = velocity;
	}
	
	@Override
	public void run(int t) {
		moveBy(Vector.skalMult(((double)t)*0.001, velo));
	}
}