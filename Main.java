package ABSTRACTION;
import java.util.Scanner;

abstract class Printer {
	abstract void configuration();
	abstract void display();
}

class DotMatrix extends Printer {
	void configuration() {
		System.out.println("DotMatrix configuration");
	}
	void display() {
		System.out.println("DotMatrix display");
	}
}

class LaserJet extends Printer {
	void configuration() {
		System.out.println("LaserJet configuration");
	}
	void display() {
		System.out.println("LaserJet display");
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Printer pr;
		System.out.println("1.DotMatrix \n2.LaserJet \n3.Exit");
		while (true) {
			int ch = sc.nextInt();
			switch (ch) {
			case 1: pr = new DotMatrix();
					pr.configuration();
					pr.display();
					break;
			case 2: pr = new LaserJet();
					pr.configuration();
					pr.display();
					break;
			case 3: System.out.println("Exit--");
					sc.close();
					return;
			default: System.out.println("Invalid choice");
					break;
			}
		}
	}
}
