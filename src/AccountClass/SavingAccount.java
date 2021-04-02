package AccountClass;

public class SavingAccount extends BankAccount {
    private double balance;
    private float interestRate;

    public SavingAccount(){
    }

    public void setBalance(double savingBal) {
        this.balance = savingBal;
    }

    public double getBalance() {
        return balance;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public float getInterestRate() {
        return interestRate;
    }
}
