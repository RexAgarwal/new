import java.util.Scanner;

import java.util.Arrays;

class Purse {
    private int dirhams;
    private int _50fills;
    private int _25fills;
    private float total;

    public Purse(int a,int b ,int c){
        dirhams =a;
        _50fills = b;
        _25fills = c;
        total_cash();


    }



    public void add_dirhams(int amt)
    {
        dirhams+=amt;

    }
    public void remove_dirhams(int amt){
        dirhams-=amt;

    }
    public void add_50fills(int amt)
    {
        _50fills+=amt;

    }
    public void remove_50fills(int amt){
        _50fills-=amt;

    }
    public void add_25fills(int amt)
    {
        _25fills+=amt;

    }
    public void remove_25fills(int amt){
        _25fills-=amt;

    }
    public void total_cash(){

        total = dirhams + (float)_50fills/2 +(float)_25fills/4;
        System.out.print(total);

    }

}