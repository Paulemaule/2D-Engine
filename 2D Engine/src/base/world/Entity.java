package base.world;

import base.gui.Window.Brush;

public interface Entity {
	//gets called by World when the Entity is added to said World with said World as w
	public void addedTo(World w);
	//gets called each tick by the World for each Entity, t is the time in ms that the last tick used
	public void run(int t);
	//gets called each tick by the world for each Entity after run was called for each Entity
	public void cleanUp(int t);
	//gets called for each Entity after cleanup, all Entitys may use Brush to draw themselfes
	public void draw(Brush b);
	//can be used to name (ID) the Entity
	public void setID(String ID);
	//should return the name (ID) of the Entity
	public String getID();
}
