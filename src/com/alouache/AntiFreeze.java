package com.alouache;

import java.awt.*;

/**
 * AntiFreeze system is a software moving infinitely up and down the cursor to avoid video freezes caused by flash
 * issues on Linux
 */

public class AntiFreeze extends Thread {

	private Robot r;
	private int step;
	private int interval;
	private boolean run;

	public AntiFreeze() {
		this.step = 50;
		this.run = true;
		this.interval = 1000;

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
			try {
				sleep(this.interval);
			} catch (Exception e) {
			}

			if (this.run) {
				int xCoord = MouseInfo.getPointerInfo().getLocation().x;
				int yCoord = MouseInfo.getPointerInfo().getLocation().y;

				this.r.mouseMove(xCoord, yCoord + this.step);
				this.step = -this.step;
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

	/**
	 * Return if the antifreeze is running
	 *
	 * @return true if running
	 */
	public boolean isRunning() {
		return this.run;
	}

	public void setStep(int step) {
		this.step = step;
	}

	/**
	 * Set the interval between 2 ticks
	 *
	 * @param interval time in ms
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}
}
