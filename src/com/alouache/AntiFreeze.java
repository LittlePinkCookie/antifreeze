package com.alouache;

import java.awt.*;

public class AntiFreeze {

	private Robot r;
	private int direction;
	private boolean run;

	public AntiFreeze() {
		this.direction = 50;

		try {
			this.r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		while(true) {
			int xCoord = MouseInfo.getPointerInfo().getLocation().x;
			int yCoord = MouseInfo.getPointerInfo().getLocation().y;

			this.r.mouseMove(xCoord, yCoord + this.direction);
			this.direction = -this.direction;

			try { Thread.sleep(1000); } catch(Exception e) {}
		}
	}

	public static void main(String[] args) {
		System.out.println("Starting anti-freeze....");
		new AntiFreeze().start();
	}
}
