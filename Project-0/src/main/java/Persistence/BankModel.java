package Persistence;

public class BankModel {

    private Integer accountId;
    private String checking;
    private String savings;
    private Integer userId;
    //private String accountType; //= "checking" or "savings"

    public BankModel() {
    }

    //constructor is for testing so far

    public BankModel(String checking, String savings) {
        this.checking = checking;
        this.savings = savings;

    }
    public BankModel(Integer accountId, String checking, String savings, Integer user_id) {
        this.accountId = accountId;
        this.checking = checking;
        this.savings = savings;
        this.userId = userId;
    }



    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getChecking() {
        return checking;
    }

    public void setChecking(String checking) {
        this.checking = checking;
    }

    public String getSavings() {
        return savings;
    }

    public void setSavings(String savings) {
        this.savings = savings;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer user_id) {
        this.userId = userId;
    }
}
