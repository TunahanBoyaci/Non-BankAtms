package NonBankAtms;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Database {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();


    static {
        accounts.add(new NationalBankAccount("John Thomas", 15000, "USD0101112","0102"));
        accounts.add(new NationalBankAccount("Sam Bakery", 3000, "USD0101113","2453"));
        accounts.add(new NationalBankAccount("Tom Smith", 40000, "USD0101114","6512"));
        accounts.add(new CityBankAccount("Kevin","Field", 12000, "USD0101115","5489"));
        accounts.add(new CityBankAccount("Mark","West", 500, "USD0101116","2318"));
        accounts.add(new CityBankAccount("Allen","Fitz", 500, "USD0101116","2318"));
    }

    public static ArrayList<BankAccount> getAccounts(){
        return accounts;
    }

    public static BankAccount getAccount(String accountNumber){
        for (BankAccount b : accounts){
            if (b.getAccountNumber().equals(accountNumber)){
                return b;
            }
        }
        return null;
    }
}

