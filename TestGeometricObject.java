package workshop3;
import java.util.Scanner;

public class TestGeometricObject {
    private static Scanner input;
    public static void main(String[] args) {
        
        //Normal triangle
        Triangle myTriangle = new Triangle();
        myTriangle.getInfo();

        System.out.println();

        //triangle with illegal sides *not obeying the rule*
        
        try {
            input = new Scanner(System.in);

            TriangleTask2 myIllegalTriangle = new TriangleTask2();

            System.out.println("***Create an Illegal Triangle***");
        
            System.out.print("Enter the first side: ");
            double firstSide = Double.parseDouble(myIllegalTriangle.numCheck(input.next()));

            System.out.print("Enter the second side: ");
            double secondSide = Double.parseDouble(myIllegalTriangle.numCheck(input.next()));

            System.out.print("Enter the third side: ");
            double thirdSide = Double.parseDouble(myIllegalTriangle.numCheck(input.next()));

            myIllegalTriangle = new TriangleTask2(firstSide,secondSide,thirdSide);
            
            System.out.print("Choose color for your triangle: ");
            String color = input.next();
            myIllegalTriangle.stringCheck(color);

            System.out.print("Do you want the triangle to be filled? (true/false): ");
            String filled = input.next();
            myIllegalTriangle.filledCheck(filled);

            System.out.print(myIllegalTriangle.toString());
        } catch (TriangleException e) {
            System.err.println(e);
        }
        
    }
}
