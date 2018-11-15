package base.world;

import base.gui.Window.Brush;

public interface Entity {
	public void addedTo(World w);
	public void run(int t);
	public void draw(Brush b);
}
