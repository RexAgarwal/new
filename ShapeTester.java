import java.util.Scanner;
class ShapeTester{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter Size of cube for the shape of type of cube..\n ");
        float a = sc.nextInt();
        Shape s1 = new Shape(a);
        System.out.print("Please Enter length width and height of cuboid for the shape of type of cuboid..\n ");
        float l = sc.nextInt();
        float w = sc.nextInt();
        float h = sc.nextInt();
        Shape s2 = new Shape(l,w,h);
        float SA_cube = s1.calculateSurfaceArea(a);
        float SA_cuboid = s2.calculateSurfaceArea(l,w,h);
        float V_cube = s1.calculateVolume(a);
        float V_cuboid = s2.calculateVolume(l, w, h);
        s1.displayDetails();
        System.out.println("Surface AREA is =" + SA_cube + "Volume of cube = " + V_cube +"\n \n");
        s2.displayDetails();
        System.out.println("Surface AREA is =" + SA_cuboid + "Volume of cuboid = " + V_cuboid +"\n \n");
        sc.close();
    }
}