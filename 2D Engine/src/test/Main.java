package test;

import java.awt.Color;

import base.Base;
import base.utility.maths.Vector;
import base.world.entitys.BasicShapedEntity;
import base.world.entitys.MovingEntity;

public class Main {

	public static void main(String[] args) {
		Base.initialize("TEST221",new Vector(800,500));
		Base.getWorld().addEntity(
				new MovingEntity(
						new Vector(50,100), 
						new Vector(40,40),
						Color.GREEN,BasicShapedEntity.FILL_RECT,
						new Vector(0,0),
						MovingEntity.REFLECT_AT_BORDER));
		Base.startLoop();
	}
}
