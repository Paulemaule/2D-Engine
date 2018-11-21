package base;

import base.gui.Window;
import base.gui.Window.Brush;
import base.utility.maths.Vector;
import base.world.World;

public final class Base {
	private static World world;
	private static Window window;
	
	//this should not be instanced
	private Base() {}
	
	//first method that should be called when starting the gui
	public static void initialize(String windowName, Vector worldSize) {
		window = new Window(Vector.add(worldSize, new Vector(Window.RIGHT_OFFSET,Window.BOTTOM_OFFSET)), windowName);
		world = new World(worldSize);
	}
	
	//starts the basic while(true) loop
	public static void startLoop() {
		long t = System.currentTimeMillis();
		while(true) {
			int dt = (int) (System.currentTimeMillis() - t);
			t = System.currentTimeMillis();
			world.run(dt);
			window.draw();
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	//this method gets called by the window when it started repainting and will pass this forward to the world
	//ie. the Base only acts as a mediator here
	public static void drawWith(Brush b) {
		world.paint(b);
	}
	
	public static World getWorld() {
		return Base.world;
	}
}
