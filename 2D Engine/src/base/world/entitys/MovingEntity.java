package base.world.entitys;

import java.awt.Color;

import base.utility.maths.Vector;

public class MovingEntity extends BasicShapedEntity{
	public final static int NO_BORDER_INTERACTION = 0;
	public final static int STOP_AT_BORDER = 1;
	public final static int REFLECT_AT_BORDER = 2;
	
	private Vector velo = new Vector(0,0);
	private int borderBehavior = 0;
	
	public MovingEntity(Vector loc, Vector size, Color c, int shape, Vector velocity, int borderBehavior) {
		super(loc, size, c, shape);
		velo = velocity;
		this.borderBehavior = borderBehavior;
	}
	
	public MovingEntity(Vector loc, Vector size, Color c, int shape, Vector velocity) {
		super(loc, size, c, shape);
		velo = velocity;
	}
	
	public MovingEntity(Vector loc, Vector size, Color c, int shape) {
		super(loc, size, c, shape);
	}
	
	public void setVeloctiy(Vector velocity) {
		velo = velocity;
	}
	
	public Vector getVelocity() {
		return velo;
	}
	
	public void setBorderBehavior(int borderBehavior) {
		this.borderBehavior = borderBehavior;
	}
	
	public int getBorderBehavior() {
		return borderBehavior;
	}
	
	@Override
	public void run(int t) {
		moveBy(Vector.skalMult(((double)t)*0.001, velo));
	}
	
	@Override
	public void cleanUp(int t) {
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
		if(getLocation().getX()-(getSize().getX()/2) < 0) {
			setLocation(new Vector(getSize().getX()/2,getLocation().getY()));
			setVeloctiy(new Vector(0,getVelocity().getY()));
		}
		if(getLocation().getY()-(getSize().getY()/2) < 0) {
			setLocation(new Vector(getLocation().getX(),getSize().getY()/2));
			setVeloctiy(new Vector(getVelocity().getX(),0));
		}
		if(getLocation().getX()+(getSize().getX()/2) > getWorld().getSize().getX()) {
			setLocation(new Vector(getWorld().getSize().getX() - getSize().getX()/2
					,getLocation().getY()));
			setVeloctiy(new Vector(0,getVelocity().getY()));
		}
		if(getLocation().getY()+(getSize().getY()/2) > getWorld().getSize().getY()) {
			setLocation(new Vector(getLocation().getX()
					,getWorld().getSize().getY() - getSize().getY() / 2));
		}
	}
	
	private void reflectAtBorder() {
		if(getLocation().getX()-(getSize().getX()/2) < 0) {
			setLocation(new Vector(getSize().getX()/2,getLocation().getY()));
			setVeloctiy(new Vector(-getVelocity().getX(),getVelocity().getY()));
		}
		if(getLocation().getY()-(getSize().getY()/2) < 0) {
			setLocation(new Vector(getLocation().getX(),getSize().getY()/2));
			setVeloctiy(new Vector(getVelocity().getX(),-getVelocity().getY()));
		}
		if(getLocation().getX()+(getSize().getX()/2) > getWorld().getSize().getX()) {
			setLocation(new Vector(getWorld().getSize().getX() - getSize().getX()/2
					,getLocation().getY()));
			setVeloctiy(new Vector(-getVelocity().getX(),getVelocity().getY()));
		}
		if(getLocation().getY()+(getSize().getY()/2) > getWorld().getSize().getY()) {
			setLocation(new Vector(getLocation().getX()
					,getWorld().getSize().getY() - getSize().getY() / 2));
			setVeloctiy(new Vector(getVelocity().getX(),-getVelocity().getY()));
		}
	}
}