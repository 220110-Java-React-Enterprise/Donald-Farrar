package Persistence;

public class BankModel {
    private Integer accountId;
    private String accountType;
    private Double balance;

    public BankModel() {
    }

    public BankModel( String accountType, Double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public BankModel(Integer accountId, String accountType, Double balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }
    public void withdraw(double amount){
        this.balance -= amount;
    }


    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
