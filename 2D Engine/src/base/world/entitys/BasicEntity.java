package base.world.entitys;

import base.gui.Window.Brush;
import base.world.Entity;
import base.world.World;

public class BasicEntity implements Entity{
	private String ID;
	private World world;
	
	public BasicEntity(String ID) {
		this.ID = ID;
	}
	
	public BasicEntity() {
		
	}
	
	public World getWorld() {
		return world;
	}

	@Override
	public void addedTo(World w) {
		world = w;
	}

	@Override
	public void run(int t) {
	}

	@Override
	public void cleanUp(int t) {
	}

	@Override
	public void draw(Brush b) {
	}

	@Override
	public void setID(String ID) {
		this.ID = ID;
	}

	@Override
	public String getID() {
		return ID;
	}
}
