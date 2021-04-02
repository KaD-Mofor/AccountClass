package AccountClass;

import java.util.Scanner;

public class BankAccount {
    private long acctNum;
    private String dateCreated;

    public BankAccount(){

    }

    public void setAcctNum(long acctNum) {
        this.acctNum = acctNum;
    }

    public long getAcctNum() {
        return acctNum;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount();
        CheckingAccount checkingAccount = new CheckingAccount();
        SavingAccount savingAccount = new SavingAccount();
        MyDate myDate = new MyDate();

        int tryAgain;              //To continue or exit the program

        System.out.println("------------Welcome!---------------\n");
        System.out.print("Enter account number: ");
        long acctNumber = input.nextLong();
        bankAccount.setAcctNum(acctNumber);
        System.out.println("Enter the date account was created: ");
        myDate.getDay();
        myDate.getMonth();
        myDate.getYear();
        System.out.println("\nEnter account balances now: ");
        System.out.print("Checking Account: $ ");
        double checkingBal = input.nextDouble();
        checkingAccount.setBalance(checkingBal);
        System.out.print("Saving Account: $ ");
        double savingBal = input.nextDouble();
        savingAccount.setBalance(savingBal);

        do {
            System.out.println("\nDo you wish to make a withdrawal or deposit?\n"+
                    " Enter: 1 = Withdrawal\n"+
                    "\t\t 2 = Deposit ");
            int activity = input.nextInt();
            if(activity == 1){
                makeWithdrawal(savingAccount.getBalance(), checkingAccount.getBalance());}
            else if (activity == 2){
                makeDeposit(checkingAccount.getBalance(), savingAccount.getBalance());
            }
            else {
                System.out.println("Invalid entry\n");
            }
            System.out.println("\nDo you have another transaction?\n"+" Enter: 1 = Yes\n\t\t"+"2 = No");
                tryAgain = input.nextInt();

        }while (tryAgain == 1);

        System.out.println("Good bye!");

    }

    public static void makeWithdrawal(double savingBal, double checkingBal) {
        //BankAccount bankAccount = new BankAccount();
        CheckingAccount checkingAccount = new CheckingAccount();
        SavingAccount savingAccount = new SavingAccount();
        Scanner input = new Scanner(System.in);

        double amtWithdraw = 0;                        //To hold withdrawal amount
        double totalBal = checkingBal+savingBal;       //To hold total account bal


        System.out.println("From which account do you wish to withdraw? \n" +
                            "Enter: 1 = Checking \n\t"
                                 +"\t2 = Saving ");
        int acctType = input.nextInt();
        input.nextLine();


        if(acctType == 2){
            System.out.println("Enter the amount you wish to withdraw: ");
            amtWithdraw = input.nextDouble();
            if(savingBal == 0){
                System.out.println("Sorry! This account has a zero (0) balance.");
            }
            else if(amtWithdraw <= savingBal){
                savingBal -= amtWithdraw;
                System.out.println("Ok. \n"+"New Saving balance is: $"+ savingBal);
                savingAccount.setBalance(savingBal);
            }else{
                System.out.println("You do not have enough funds to do this withdrawal.\n"
                                    +"You may want to revise the withdrawal amount. \n");
                 }
        }
        else if(acctType == 1)
        {
            System.out.println("Enter the amount you wish to withdraw: ");
            amtWithdraw = input.nextDouble();

            if(checkingBal == 0){
                System.out.println("Sorry! This account has a zero (0) balance.");
            }
            else if(amtWithdraw <= checkingBal)
                {
                checkingBal -= amtWithdraw;
                System.out.println("Ok.\n"+"New Checking balance is: $"+checkingBal);
                checkingAccount.setBalance(checkingBal);
                }
            else if(amtWithdraw <= totalBal)
                {
                System.out.println("\nChecking account overdrawn: $"+ (amtWithdraw-checkingBal));
                checkingBal = 0;
                savingBal -= (amtWithdraw-checkingBal);
                savingAccount.setBalance(savingBal);
                System.out.println("New Checking balance is: $"+checkingBal);
                checkingAccount.setBalance(checkingBal);
                }
        }
        else{
                System.out.println("Invalid entry");
        }
    }

    public static void makeDeposit(double ch, double sa){
        //BankAccount bankAccount = new BankAccount();
        CheckingAccount checkingAccount = new CheckingAccount();
        SavingAccount savingAccount = new SavingAccount();
        Scanner input = new Scanner(System.in);

        System.out.println("To which account do you wish to deposit? \n" +
                " Enter: 1 = Checking \n\t"
                +"\t2 = Saving ");
        int acctType = input.nextInt();
        input.nextLine();

        if (acctType == 1){
            System.out.println("How much do want to deposit? ");
            double deposit = input.nextDouble();
            ch += deposit;
            checkingAccount.setBalance(ch);
            System.out.println("\nYour new checking account balance is: $ "+checkingAccount.getBalance());

        }else if(acctType == 2){
            System.out.println("How much do want to deposit? ");
            double deposit = input.nextDouble();
            sa += deposit;
            savingAccount.setBalance(sa);
            System.out.println("\nYour new saving account balance is: $ "+savingAccount.getBalance());
        }
    }

}
