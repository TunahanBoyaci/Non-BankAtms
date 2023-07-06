package NonBankAtms;

public class CityBankAccount implements BankAccount {
    private String name;
    private String surname;
    private int balance;
    private String accountNumber;
    private String pinCode;

    public CityBankAccount(String name, String surname, int balance, String accountNumber, String pinCode) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
    }

    public CityBankAccount() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public String getPinCode() {
        return this.pinCode;
    }

    @Override
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public int totalBalance() {
        return this.balance;
    }

    @Override
    public void creditBalance(int credit) {
        if (this.balance - credit > 0) {
            this.balance -= credit;
        }
        else {
            System.out.println("Insufficent balance.");
        }
    }

    @Override
    public void debitBalance(int debit) {
        this.balance += debit;
    }

    @Override
    public void accountData() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(" ");
        stringBuilder.append(this.surname);
        stringBuilder.append(", Account: ");
        stringBuilder.append(this.accountNumber);
        stringBuilder.append(", Balance:");
        stringBuilder.append(this.balance);
        stringBuilder.append(" USD");
        System.out.println(stringBuilder);
    }
}