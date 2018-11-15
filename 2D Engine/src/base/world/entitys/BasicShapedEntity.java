package base.world.entitys;

import java.awt.Color;

import base.gui.Window.Brush;
import base.utility.maths.Vector;
import base.world.Entity;
import base.world.World;

public class BasicShapedEntity implements Entity{
	public final static int FILL_RECT = 0;
	public final static int RECT = 1;
	public final static int FILL_OVAL = 2;
	public final static int OVAL = 3;
	
	private Vector loc;
	private Vector size;
	private Color color;
	private int shape;
	
	public BasicShapedEntity(Vector loc, Vector size, Color c, int shape) { 
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
	public void addedTo(World w) {
	}

	@Override
	public void run(int t) {
	}

	@Override
	public void draw(Brush b) {
		b.setColor(color);
		
		switch (shape) {
		case FILL_RECT:
			b.fillRect(loc, size);
			break;
		case RECT:
			b.drawRect(loc, size);
			break;
		case FILL_OVAL:
			b.fillOval(loc, size);
			break;
		case OVAL:
			b.drawOval(loc, size);
			break;
		default:
			System.out.println("BasicShapedEntity tried to draw invalid shape");
			break;
		}
	}
}
