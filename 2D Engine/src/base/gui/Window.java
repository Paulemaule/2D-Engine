package base.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

import base.Base;
import base.utility.maths.Vector;

@SuppressWarnings("serial")
public class Window extends JFrame {
	private DrawPanel dp;
	
	private Color background_color = Color.WHITE;
	
	public static final int BOTTOM_OFFSET = 39;
	public static final int RIGHT_OFFSET = 16;

	public Window(Vector frameSize, String title) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
		setSize(frameSize.getIntX(), frameSize.getIntY());
		setLocationRelativeTo(null);
		dp = new DrawPanel();
		setContentPane(dp);
		setVisible(true);
	}
	
	public Window(Vector frameSize, String title, Color background) {
		background_color = background;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
		setSize(frameSize.getIntX(), frameSize.getIntY());
		setLocationRelativeTo(null);
		dp = new DrawPanel();
		setContentPane(dp);
		setVisible(true);
	}
	
	//gets called by the Base each loop, !may! trigger the repainting process
	public void draw() {
		repaint();
	}
	
	public void setBackgroundColor(Color c) {
		background_color = c;
	}
	
	//this object will be used by entitys to draw on the window
	public class Brush {
		private Graphics2D g2d;
		
		protected Brush(Graphics2D g2d) {
			this.g2d=g2d;
		}
		
		public void setColor(Color c) {
			g2d.setColor(c);
		}
		
		public void drawLine(Vector start, Vector end) {
			g2d.drawLine(start.getIntX(), start.getIntY(), end.getIntX(), end.getIntY());
		}
		
		public void drawRect(Vector loc, Vector size) {
			g2d.drawRect(loc.getIntX(), loc.getIntY(), size.getIntX(), size.getIntY());
		}
		
		public void fillRect(Vector loc, Vector size) {
			g2d.fillRect(loc.getIntX(), loc.getIntY(), size.getIntX(), size.getIntY());
		}
		
		public void drawOval(Vector loc, Vector size) {
			g2d.drawOval(loc.getIntX(), loc.getIntY(), size.getIntX(), size.getIntY());
		}
		
		public void fillOval(Vector loc, Vector size) {
			g2d.fillOval(loc.getIntX(), loc.getIntY(), size.getIntX(), size.getIntY());
		}
	}

	private class DrawPanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(background_color);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			Brush b = new Brush(g2d);
			paintEntitys(b);
			g2d.dispose();
		}
		
		//issues the drawing of all the entitys by the world
		private synchronized void paintEntitys(Brush b) {
			Base.drawWith(b);
		}
	}
}
