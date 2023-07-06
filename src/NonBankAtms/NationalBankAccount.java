package NonBankAtms;

public class NationalBankAccount implements BankAccount {
    private String fullName;
    private int balance;
    private String accountNumber;
    private String pinCode;

    public NationalBankAccount(String fullName, int balance, String accountNumber, String pinCode) {
        this.fullName = fullName;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
    }

    public NationalBankAccount() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        if (this.balance - credit > 0){
            this.balance -= credit;
        }
        else {
            System.out.println("Insufficent balance");
        }
    }

    @Override
    public void debitBalance(int debit) {
        this.balance += debit;
    }

    public void accountData() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fullName);
        stringBuilder.append(", Account: ");
        stringBuilder.append(this.accountNumber);
        stringBuilder.append(", Balance:");
        stringBuilder.append(this.balance);
        stringBuilder.append(" USD");
        System.out.println(stringBuilder);
    }
}