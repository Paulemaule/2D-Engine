package test;

import java.awt.Color;

import base.Base;
import base.utility.maths.Maths;
import base.utility.maths.Vector;
import base.world.entitys.BasicShapedEntity;
import base.world.entitys.MovingEntity;

public class Main {

	public static void main(String[] args) {
		Base.initialize("TEST221",new Vector(800,500));
		System.out.println("aaa");
		for(int i = 0; i < 200; i++) {
		Base.getWorld().addEntity(
				new MovingEntity(
						new Vector(100,100), 
						new Vector(20,50),
						Color.GREEN,
						BasicShapedEntity.FILL_RECT,
						new Vector(Maths.random(-150, 150),Maths.random(-150, 150)),
						MovingEntity.REFLECT_AT_BORDER));
		}
		Base.startLoop();
	}
}