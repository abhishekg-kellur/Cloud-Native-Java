package POLYMORPHISM;

abstract class Vehicle {
	abstract void drive();
}

class Car extends Vehicle {
	void drive() {
		System.out.println("Car max speed 200km");
	}
}

class Motorcycle extends Vehicle {
	void drive() {
		System.out.println("Motorcyle max speed 160km");
	}
}

public class Main1 {
	public static void main(String[] args) {
		Vehicle c = new Car();
		Vehicle m = new Motorcycle();
		c.drive();
		m.drive();
	}
}
