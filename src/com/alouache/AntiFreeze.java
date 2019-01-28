package com.alouache;

import java.awt.*;

/**
 * AntiFreeze system is a software moving infinitely up and down the cursor to avoid video freezes caused by flash
 * issues on Linux
 */

public class AntiFreeze extends Thread {

	private Robot r;
	private int direction;
	private boolean run;

	public AntiFreeze() {
		this.direction = 50;
		this.run = false;

		try {
			this.r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Move cursor up and down
	 */
	public void run() {
		while (true) {
			if (this.run) {
				System.out.println("lol");
				int xCoord = MouseInfo.getPointerInfo().getLocation().x;
				int yCoord = MouseInfo.getPointerInfo().getLocation().y;

				this.r.mouseMove(xCoord, yCoord + this.direction);
				this.direction = -this.direction;

				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * Start and stop the Anti Freeze system
	 *
	 * @param b true to start
	 */
	public void setState(boolean b) {
		this.run = b;
	}

	public boolean isRunning() {
		return this.run;
	}
}
