import java.util.Scanner;

import java.util.Arrays;

class AreaTester {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        Area shape = new Area();
        String cont = "yes";
        while (cont == "yes") {
            int choice;

            System.out.print("Main Menu \n ...................................   ");
            System.out.println("case 1: calculating area of square \n case 2: calculating area of circle \n case 3: calculating area of rectangle");
            choice = user.nextInt();
            switch (choice) {

                case 1:

                    System.out.print("Enter side of square...\n");
                    int side = user.nextInt();
                    shape.calc_Area(side);
                    shape.display();
                    

                    break;

                case 2:
                    System.out.print("Enter radius for circle..\n");
                    float radius = user.nextFloat();
                    shape.calc_Area(radius);
                    shape.display();

                    break;

                case 3:
                    System.out.print("Enter side1 and side2 of rectangle");
                    float side1 = user.nextFloat();
                    float side2 = user.nextFloat();
                    shape.calc_Area(side1, side2);
                    shape.display();
                    
                    break;
                default:

                    break;

            }




            System.out.print("Do you want to do something else? (yes/no): ");
            cont = user.next();
    
    }
}
}