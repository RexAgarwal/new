import java.util.Scanner;

import java.util.Arrays;

class CreditCardTester {
    public static void main(String[] args) {
        String uname;
        String ucardnumber;
        int choice;
        int i = 0;
        String cont = "yes";
        Scanner user = new Scanner(System.in);
        CreditCard user1[] = new CreditCard[3];

        for (int j = 0; j < user1.length; j++) {
            System.out.println("\n Please Enter name & card number of credit card holder: ");
            uname = user.next();
            ucardnumber = user.next();

            user1[j] = new CreditCard(uname, ucardnumber);
            break;
        }
        while (cont == "yes") {

        System.out.print("Main Menu \n ...................................   ");
        System.out.println(" 1.Change Pin \n 2.Transact \n 3.Display \n 4.Change Card Status");
        choice = user.nextInt();
        System.out.print("Enter Your card number and pin \n ");
        String number = user.next();
        int ppin = user.nextInt();

        for (i = 0; i < user1.length; i++) {
            if (user1[i].check_pin(ppin)) {
        
                break;
            }

        }
        if (i == user1.length){
            System.out.println("No such account was found..");
        }
        
            switch (choice) {

                case 1:

                    System.out.print("Enter new pin...\n");
                    int newpin = user.nextInt();
                    user1[i].changePin(newpin);

                    break;

                case 2:
                    System.out.print("Enter amount for transaction..\n");
                    int amount = user.nextInt();
                    user1[i].transact(amount);

                    break;

                case 3:
                    user1[i].display();
                    break;

                case 4:
                    System.out.print("Do you want to Disable the status?");
                    boolean status = user.nextBoolean();
                    user1[i].changeCardStatus(status);
                    break;
                default:

                    break;

            }
            System.out.print("Do you want to do something else? (yes/no): ");
            cont = user.nextLine();
            System.out.print(cont);
        }

    }

}