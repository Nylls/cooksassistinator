package cooksassistinator.util;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.text.DecimalFormat;

import org.powerbot.game.api.methods.input.Mouse;

import cooksassistinator.stuff.Methods;

public class Paint {

	
	public final static void drawPaint(final Graphics render, long time) {
		Graphics2D g = (Graphics2D) render;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.setColor(Color.GREEN);
		g.drawLine(Mouse.getX() - 6, Mouse.getY(), Mouse.getX() + 6, Mouse.getY());
		g.setColor(Color.WHITE);
		g.drawLine(Mouse.getX(), Mouse.getY() - 6, Mouse.getX(), Mouse.getY() + 6);
		g.setColor(Color.BLACK);
		g.fill(new Rectangle(0, 0, 766, 50));
		g.setColor(Color.GREEN);
		double elapsed=(System.currentTimeMillis()-time)*0.001;
		long mins=((long)elapsed/60);
		DecimalFormat df = new DecimalFormat("#.###");
		double secs=elapsed-mins*60;
		g.drawString("Status: " + Methods.status, 20, 15);
		g.drawString("Time elapsed: " + mins + ":" + df.format(secs),20,40);
		
	}

}