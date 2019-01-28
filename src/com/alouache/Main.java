package com.alouache;

public class Main {

	public static void main(String[] args) {
	    AntiFreeze af = new AntiFreeze();
	    CommandManager cmdManager = new CommandManager(af);

		cmdManager.start();
	    af.start();
	}
}
