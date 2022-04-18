package workshop3;

import static java.lang.Math.sqrt;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Triangle extends GeometricObject {
    private static Scanner input;
    private static DecimalFormat df = new DecimalFormat("0.00");
    
    private double side1, side2, side3;

    //no arg constructor
    Triangle() {
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    };

    //three arg constructor
    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    };

    //Accessor methods for all three sides
    double getSide1() {
        return side1;
    }

    double getSide2() {
        return side2;
    }

    double getSide3() {
        return side3;
    }

    //Setter methods for all three sides
    void setSide1(double side1) {
        this.side1 = side1;
    }

    void setSide2(double side2) {
        this.side2 = side2;
    }

    void setSide3(double side3) {
        this.side3 = side3;
    }

    //Overridden functions from the abstract class GeometricObject
    @Override
    double getArea() {
        double temp = getPerimeter();
        double area = 0;
        
        area = sqrt(temp * ((temp - side1) * (temp - side2) * (temp - side3)));

        return area;
    }

    @Override
    double getPerimeter() {
        double temp = 0;

        temp = (side1 + side2 + side3) / 2;
        
        return temp;
    }

    //The description for the triangle
    public String toString() {
        String info = "\nWe calculated the perimeter and area of your triangle.\n" + 
        "The first side is *" + getSide1() + "*, second one is *" + getSide2() + "* and the third is *" + getSide3() +
        "*.\nThe perimeter is > " + getPerimeter() + " < and the area is > " + df.format(getArea()) +" <.\n" + 
        "\n-----------------" + 
        "\nFilled?: " + getFilled() + "  |\n" + 
        "-----------------\n" + "\nWe saw that you put in color.\n" + "The color of the triangle is *"+ getColor() + "*.\n" + 
        "\n----------------------------------\n" + 
        "Thank you for using our program ;)\n" +
        "----------------------------------\n";

        return info;
    }

    //Checks if the string is only numbers
    String numCheck(String str) {
        input = new Scanner(System.in);

        for (int i = 0; i < str.length(); i++) {
            while(!Character.isDigit(str.charAt(i))) {
                System.out.print("Letter detected! Enter digits only: ");
                str = input.next();
                continue;
            }
        }

        return str;
    }
    
    //Checker for each letter in the string if there is a number it will show error and ask again for input
    String stringCheck(String str) {
        input = new Scanner(System.in);

        for (int i = 0; i < str.length(); i++) {
            while(Character.isDigit(str.charAt(i))) {
                System.out.print("Digit detected! Enter letters only: ");
                str = input.next();
            }
        }

        setColor(str);
        return str;
    }

    //Checks the input and if it is true/TRUE it will set it to true
    //If not true/TRUE it will default it to false
    void filledCheck(String str) {
        
        if (Boolean.parseBoolean(str)) {
            setFilled(true);
        } else {
            setFilled(false);
        }
    }

    //Get all info needed to create a triangle
    void getInfo() {
        input = new Scanner(System.in);

        Triangle firstTriangle = new Triangle();

        System.out.println("***Create a Triangle***");
        
        System.out.print("Enter the first side: ");
        double firstSide = Double.parseDouble(firstTriangle.numCheck(input.next()));

        System.out.print("Enter the second side: ");
        double secondSide = Double.parseDouble(firstTriangle.numCheck(input.next()));

        System.out.print("Enter the third side: ");
        double thirdSide = Double.parseDouble(firstTriangle.numCheck(input.next()));

        firstTriangle.setSide1(firstSide);
        firstTriangle.setSide2(secondSide);
        firstTriangle.setSide3(thirdSide);

        System.out.print("Choose color for your triangle: ");
        String color = input.next();
        firstTriangle.stringCheck(color);

        System.out.print("Do you want the triangle to be filled? (true/false): ");
        String filled = input.next();
        firstTriangle.filledCheck(filled);

        System.out.print(firstTriangle.toString());
    }
}
