package test;

import java.awt.Color;

import base.Base;
import base.utility.maths.Maths;
import base.utility.maths.Vector;
import base.world.entitys.ShapedEntity;
import base.world.entitys.MovingEntity;

public class Main {

	public static void main(String[] args) {
		Base.initialize("TEST221",new Vector(800,500));
		for(int i = 0; i < 15; i++) {
		Base.getWorld().addEntity(
			new Bird(new Vector(Maths.random(0+5, 800-5),Maths.random(0+5, 500-5))
					,new Vector(Maths.random(30, 90)
					,Maths.random(0,Math.PI*2),Vector.POLAR)));
		}
		Base.startLoop();
	}
}