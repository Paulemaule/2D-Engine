package base.world.entitys;

import java.awt.Color;

import base.gui.Window.Brush;
import base.utility.maths.Vector;

public class ShapedEntity extends BasicEntity{
	public final static int FILL_RECT = 0;
	public final static int RECT = 1;
	public final static int FILL_OVAL = 2;
	public final static int OVAL = 3;
	
	private Vector loc;
	private Vector size;
	private Color color;
	private int shape;
	
	public ShapedEntity(Vector loc, Vector size, Color c, int shape, String ID) {
		super(ID);
		this.loc = loc;
		this.size = size;
		color = c;
		this.shape = shape;
	}
	
	public ShapedEntity(Vector loc, Vector size, Color c, int shape) { 
		this.loc = loc;
		this.size = size;
		color = c;
		this.shape = shape;
	}
	
	public Vector getSize() {
		return size;
	}

	public void setSize(Vector size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getShape() {
		return shape;
	}

	public void setShape(int shape) {
		this.shape = shape;
	}
	
	public Vector getLocation() {
		return loc;
	}
	
	public void setLocation(Vector loc) {
		this.loc = loc;
	}
	
	public void moveBy(Vector m) {
		loc = Vector.add(loc, m);
	}
	
	@Override
	public void draw(Brush b) {
		b.setColor(color);
		
		switch (shape) {
		case FILL_RECT:
			b.fillRect(Vector.add(loc,Vector.skalMult(-0.5,size)), size);
			break;
		case RECT:
			b.drawRect(Vector.add(loc,Vector.skalMult(-0.5,size)), size);
			break;
		case FILL_OVAL:
			b.fillOval(Vector.add(loc,Vector.skalMult(-0.5,size)), size);
			break;
		case OVAL:
			b.drawOval(Vector.add(loc,Vector.skalMult(-0.5,size)), size);
			break;
		default:
			System.out.println("BasicShapedEntity (" + getID() + ") tried to draw invalid shape");
			break;
		}
	}
}
