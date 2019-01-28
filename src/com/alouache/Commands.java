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
		String args[] = cmd.split(" ");

		switch (args[0]) {
			case "start":
				this.antiFreeze.setState(true);
				System.out.println("AntiFreeze started !");
				break;

			case "stop":
				this.antiFreeze.setState(false);
				System.out.println("AntiFreeze stopped !");
				break;

			case "step":
				if (args.length > 1) {
					try {
						int step = Integer.parseInt(args[1]);
						this.antiFreeze.setStep(step);
						System.out.println("=> Step set to : " + step + " px");
					} catch (Exception e) {
						System.out.println("ERROR : " + args[1] + " is not a number");
					}
				} else {
					System.out.println("USAGE : step <nb pixels>");
				}
				break;

			case "interval":
				if (args.length > 1) {
					try {
						int interval = Integer.parseInt(args[1]);
						this.antiFreeze.setInterval(interval);
						System.out.println("=> Interval set to : " + interval + " px");
					} catch (Exception e) {
						System.out.println("ERROR : " + args[1] + " is not a number");
					}
				} else {
					System.out.println("USAGE : interval <time in ms>");
				}
				break;


			case "quit":
				System.out.println("Exiting...");
				System.exit(0);
				break;

			default:
				System.out.println("Unknown command");
				break;

		}
	}
}
