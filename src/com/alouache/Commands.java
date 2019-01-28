package com.alouache;

import java.util.Scanner;

public class Commands extends Thread {

	private AntiFreeze antiFreeze;
	private Scanner sc;

	public Commands(AntiFreeze antiFreeze) {
		this.antiFreeze = antiFreeze;
		this.sc = new Scanner(System.in);
	}

	public void run() {
		System.out.println("running");
		while (true) {
			System.out.print("> ");
			String cmd = this.sc.nextLine();

			interpretCommand(cmd);
		}
	}

	public void interpretCommand(String cmd) {
		switch (cmd) {
			case "start":
				System.out.println("Starting AntiFreeze system...");
				this.antiFreeze.setState(true);
				System.out.println("AntiFreeze started !");
				break;

			case "stop":
				System.out.println("Stopping AntiFreeze system...");
				this.antiFreeze.setState(false);
				System.out.println("AntiFreeze stopped !");
				break;

			case "quit":
				System.out.println("Exiting...");
				System.exit(0);
				break;
		}
	}
}
