package MAIl;

import Shape.Square;
import Shape.Triangle;
import Shape.Circle;

public class Mail {
    public static void main(String[] args) {
        // Creating objects for each shape
        Square square = new Square(5.0);
        Triangle triangle = new Triangle(6.0, 4.0, 3.0, 4.0, 5.0);
        Circle circle = new Circle(2.5);

        // Calculating and printing the areas and perimeters/circumference
        System.out.println("Square Area: " + square.calculateArea());
        System.out.println("Square Perimeter: " + square.calculatePerimeter());

        System.out.println("Triangle Area: " + triangle.calculateArea());
        System.out.println("Triangle Perimeter: " + triangle.calculatePerimeter());

        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Circumference: " + circle.calculateCircumference());
    }
}
