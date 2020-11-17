import java.util.Scanner;

import java.util.Arrays;

class Area {
    private float side1;
    private float side2;
    private float area;

    public int  calc_Area(int side)
    {
        area = (int)side * side;
        return (int)area;

    }
    public float calc_Area(float radius){
        area = (float)3.14*radius*radius;
        return area;

    }
    public float calc_Area(float side1,float side2){
        area = side1*side2;

        return area;

    }
    public void display(){

        System.out.println(area);

    }

}