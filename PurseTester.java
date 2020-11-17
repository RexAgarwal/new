import java.util.Scanner;

import java.util.Arrays;

class PurseTester {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        Purse p = new Purse(0, 0, 0);
        char cont = 'y';
        while (cont == 'y') {
            int choice;

            System.out.print("Main Menu \n ...................................   ");
            System.out.println(
                    "case 1: add dirhams \n case 2: remove dirhams \n case 3: add 50 fills \n case 4: remove 50 fills case 5: add 25fills \n case 6: remove 25 fills ");
            choice = user.nextInt();
            switch (choice) {

                case 1:

                    System.out.print("Enter dirhams to be added...\n");
                    int dir = user.nextInt();
                    p.add_dirhams(dir);
                    p.total_cash();

                    break;

                case 2:
                    System.out.print("Enter dirhams to be removed...\n");
                    int amt = user.nextInt();
                    p.remove_dirhams(amt);
                    p.total_cash();

                    break;

                case 3:
                    System.out.print("Enter 50fills to be added...\n");
                    int i = user.nextInt();
                    p.add_50fills(i);
                    p.total_cash();

                    break;
                case 4:
                    System.out.print("Enter 50fills to be removed...\n");
                    int j = user.nextInt();
                    p.remove_50fills(j);
                    p.total_cash();

                    break;
                case 5:
                    System.out.print("Enter 25fills to be added...\n");
                    int k = user.nextInt();
                    p.add_50fills(k);
                    p.total_cash();

                    break;
                case 6:
                    System.out.print("Enter 25fills to be removed...\n");
                    int l = user.nextInt();
                    p.remove_25fills(l);
                    p.total_cash();

                    break;
                default:

                    break;

            }

            System.out.print("Do you want to do something else? (y/n): ");
            cont = user.next().charAt(0);

        }
    }
}