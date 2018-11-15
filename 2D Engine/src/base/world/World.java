package base.world;

import java.util.ArrayList;
import java.util.List;

import base.gui.Window.Brush;
import base.utility.maths.Vector;

public class World {
	private final List<Entity> worldContent = new ArrayList<Entity>();
	private final List<Entity> toBeAdded = new ArrayList<Entity>();
	private final List<Entity> toBeRemoved = new ArrayList<Entity>();
	
	private final Vector size;
	
	public World(Vector worldSize) {
		size = worldSize;
	}
	
	public void run() {
		worldContent.addAll(toBeAdded);
		toBeAdded.clear();
		worldContent.forEach(e -> {
			e.run();
		});
//		worldContent.removeAll(toBeRemoved);
//		toBeRemoved.clear();
	}
	
	public void paint(Brush b) {
		worldContent.forEach(e -> {
			e.draw(b);
		});
	}
	
	//The specified entity will be added to the worldContent at the next start of a run cycle
	public void addEntity(Entity e) {
		toBeAdded.add(e);
		e.addedTo(this);
	}

	//The specified entity will be removed from the worldContent at the next end of a run cycle
	public void removeEntity(Entity e) {
		toBeRemoved.add(e);
	}
	
	//returns the size of the world as a vector
	public Vector getSize() {
		return size;
	}	
}