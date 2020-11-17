import java.util.Scanner;

import java.util.Arrays;
class Stringss{
    public static void main(String args[]){
        // Q.2
        // String a = "Hi";
        // String b = "mom";
        // String c = a+b;
        // String d = a.concat(b);
        // System.out.print(c + "  " + d + "\n");
        // Q.3
        // String name = "M S. ?@P";
        // String []h = name.split("[, ?.@]+");
        // String initials = "";
        // for(String f: h){
        //     initials += f;
        //     System.out.print(f + " \n");
        
        // }
        // System.out.print(initials + " \n");

        // Q.4
        String a = "parliament";
        String b = "partial men,";
        char []s = a.toCharArray();
        for(char f:s){
            System.out.print("\n"+f + "\n");
            if(b.indexOf(f) >= 0);
            else{
            System.out.print(f);
            System.out.print("It is not an anagram");
            }

        }
    }
}