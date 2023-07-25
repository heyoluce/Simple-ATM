package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AtmOperIntef op=new AtmOperationImpl();

        int defaultATMnumber = 1111;
        int defaultPIN = 0000;
        final int maxAttempts = 3;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the ATM!");

        for (int i = maxAttempts; i >= 1; i--) {
            System.out.print("Please enter your account number: ");
            int ATMnumber = sc.nextInt();
            System.out.print("Please enter your PIN: ");
            int PIN = sc.nextInt();

            if (ATMnumber == defaultATMnumber && PIN == defaultPIN) {
                while (true) {
                    System.out.println("1. View available balance\n2. Withdraw amount\n3. Deposit amount\n4. View Ministatement\n5. Exit");
                    byte ch=sc.nextByte();
                    switch (ch) {
                        case 1: op.viewBalance(); break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount=sc.nextDouble();
                            op.withdrawAmount(withdrawAmount);
                            break;
                        case 3:
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount=sc.nextDouble();
                            op.depositAmount(depositAmount);
                            break;
                        case 4: op.viewMiniStatement(); break;
                        case 5:
                            System.out.println("Take your card, thanks"); System.exit(0);
                        default:
                            System.out.println("Please enter a correct choice");
                    }
                }

            } else if (i > 1) {
                System.out.println("Incorrect number or PIN. Please try again! You have " + (i - 1) + " attempts left!");
            } else {
                System.out.println("Please try later.");
                System.exit(0);
            }
        }
    }
}
