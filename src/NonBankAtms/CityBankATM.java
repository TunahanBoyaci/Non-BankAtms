package NonBankAtms;


import javax.xml.crypto.Data;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class CityBankATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to City Bank ATM");

        while (true){
            System.out.println("INSERT ACCOUNT NUMBER:");
            String accountNumber = scanner.nextLine();
            System.out.println("INSERT PINCODE:");
            String pinCode = scanner.nextLine();

            BankAccount bankAccount = Database.getAccount(accountNumber);

            if (bankAccount != null && bankAccount.getPinCode().equals(pinCode)){
                if (bankAccount instanceof CityBankAccount){
                    while (true) {
                        clearConsole();
                        System.out.println("PRESS [0] TO EXIT");
                        System.out.println("PRESS [1] TO CASH WITHDRAWAL");
                        System.out.println("PRESS [2] TO VIEW BALANCE");
                        System.out.println("PRESS [3] TO CHANGE PIN CODE");
                        System.out.println("PRESS [4] TO CASH IN ACCOUNT");
                        System.out.println("PRESS [5] TO VIEW ACCOUNT DATA");

                        String option = scanner.nextLine();

                        if (option.equals("1")){
                            try {
                                System.out.println("Insert amount to cash withdrawal");
                                int amount = scanner.nextInt();
                                bankAccount.creditBalance(amount);
                                System.out.println("Remaining balance " + bankAccount.totalBalance() + " USD");
                                scanner.nextLine(); // Dummy
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        else if (option.equals("2")){
                            System.out.println(bankAccount.totalBalance() + " USD");
                        }
                        else if (option.equals("3")){
                            System.out.println("Insert old PIN Code:");
                            String oldPin = scanner.nextLine();

                            if (bankAccount.getPinCode().equals(oldPin)){
                                System.out.println("Insert new PIN Code");
                                String newPin = scanner.nextLine();
                                System.out.println("Insert again");
                                String newPin2 = scanner.nextLine();

                                if (newPin.equals(newPin2)){
                                    System.out.println("PIN Code has been changed.");
                                    bankAccount.setPinCode(newPin);
                                }
                                else {
                                    System.out.println("New PIN Codes are not the same");
                                }
                            }
                            else {
                                System.out.println("Incorrect old PIN Code");
                            }
                        }
                        else if (option.equals("4")){
                            try {
                                System.out.println("Insert amount to deposit");
                                int amount = scanner.nextInt();

                                bankAccount.debitBalance(amount);
                                System.out.println("Money has been deposited.");
                                System.out.println("Balance " + bankAccount.totalBalance() + " USD");
                                scanner.nextLine(); // Dummy
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        else if (option.equals("5")){
                            bankAccount.accountData();
                        }
                        else if (option.equals("0")){
                            break;
                        }
                    }
                }
                else {
                    while (true) {
                        clearConsole();
                        System.out.println("PRESS [0] TO EXIT");
                        System.out.println("PRESS [1] TO CASH WITHDRAWAL");
                        System.out.println("PRESS [2] TO VIEW BALANCE");

                        String option = scanner.nextLine();

                        if (option.equals("1")){
                            try {
                                System.out.println("Insert amount to cash withdrawal");
                                int amount = scanner.nextInt();
                                bankAccount.creditBalance(amount + 3);
                                System.out.println("Remaining balance " + bankAccount.totalBalance() + " USD");
                                scanner.nextLine(); // Dummy
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        else if (option.equals("2")){
                            bankAccount.accountData();
                        }
                        else if (option.equals("0")){
                            break;
                        }
                    }
                }
            }
            else {
                System.out.println("Incorrect Account Number or Pin Code");
            }
        }
    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}