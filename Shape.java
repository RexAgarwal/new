import java.util.Scanner;
class Shape{
    private float Width;             
    private float Height;
    private float Depth;
    private String Type;
    public Shape(float a){    
        Type = "Cube";
        Width = a;
        Height = a;
        Depth = a;



    }
    public Shape(float w, float h, float d){
        Type = "Cuboid";
        Width = w;
        Height = h;
        Depth = d;


    }
public float calculateVolume(float a){
    float Volume = a * a * a;
    return Volume;

}
public float calculateVolume(float l,float w,float h){
    float Volume = l*w*h;
    return Volume;

}
public float calculateSurfaceArea(float a){
    float SA = 6 * a * a;
    return SA;


}
public float calculateSurfaceArea(float l,float w,float h){
    float SA = 2*(l*w + w * h + h * l);
    return SA;

}
public void displayDetails(){
    System.out.print("Printing details..\n");
    System.out.println("Type" + Type + " Width =" + Width + "Height = " + Height + "Depth =" + Depth + "\n");

}
}