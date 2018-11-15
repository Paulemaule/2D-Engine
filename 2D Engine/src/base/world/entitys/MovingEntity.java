package base.world.entitys;

import java.awt.Color;

import base.utility.maths.Vector;

public class MovingEntity extends BasicShapedEntity{
	public final static int NO_BORDER_INTERACTION = 0;
	public final static int STOP_AT_BORDER = 1;
	public final static int REFLECT_AT_BORDER = 2;
	
	private Vector velo;
	private int borderBehavior = 0;
	
	public MovingEntity(Vector loc, Vector size, Color c, int shape, Vector velocity, int borderBehavior) {
		super(loc, size, c, shape);
		velo = velocity;
		this.borderBehavior = borderBehavior;
	}
	
	@Override
	public void run(int t) {
		moveBy(Vector.skalMult(((double)t)*0.001, velo));
		switch (borderBehavior) {
		case NO_BORDER_INTERACTION:
			break;
		case STOP_AT_BORDER:
			stopAtBorder();
			break;
		case REFLECT_AT_BORDER:
			reflectAtBorder();
			break;
		default:
			break;
		}
	}
	
	private void stopAtBorder() {
		
	}
	
	private void reflectAtBorder() {
		
	}
}