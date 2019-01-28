package com.alouache;

public class Main {

	public static void main(String[] args) {
	    AntiFreeze af = new AntiFreeze();
	    Commands cmdManager = new Commands(af);

		cmdManager.start();
	    af.start();
	}
}
