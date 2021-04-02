package AccountClass;

public class CheckingAccount extends BankAccount{

    private double balance;
    private float interestRate;

    public CheckingAccount(){
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public float getCheckingInterRate() {
        return interestRate;
    }

    public void setCheckingInterRate(float checkingInterRate) {
        this.interestRate = checkingInterRate;
    }

    public double getBalance() {
        return balance;
    }
}
