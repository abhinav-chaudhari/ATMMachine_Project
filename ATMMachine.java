import java.util.Scanner;

public class ATMMachine
{
    private double totalBal = 100;
    Scanner input = new Scanner(System.in);
    public int userAccount()
    {
        System.out.println("Enter your account no. ");
        int account = input.nextInt();
        return account;
    }
    public int userPin()
    {
        System.out.println("Enter a pin");
        int pin = input.nextInt();
        return pin;
    }
    public void startAtm()
    {
        userAccount();
        userPin();
        drawMainMenu();
    }
    public void drawMainMenu()
    {
        int selection;
        System.out.println("\nAtm main menu");
        System.out.println("1 - Check Account Balance");
        System.out.println("2 - Withdraw Money");
        System.out.println("3 - Add Money");
        System.out.println("4 - Exit");
        System.out.println("Choice :");
        selection = input.nextInt();
        switch (selection)
        {
            case 1:
                accountInformation();
                break;
            case 2:
                WithdrawMoney();
                accountInformation();
                break;
            case 3:
                addMoney();
                accountInformation();
                break;
            default:
                System.out.println("Thank You for using our ATM!!!");
        }

    }
    public void accountInformation()
    {
        System.out.println("Account Information : ");
        System.out.println("\t--Total Balance $"+totalBal);
        drawMainMenu();
    }
    public void checkInsufficientFund(int withdrawAmount)
    {
        if(totalBal<withdrawAmount)
            System.out.println("\n/***INSUFFICIENT FUND/***");
        else {
            totalBal -= withdrawAmount;
            System.out.println("Please Collect Your cash");
        }
    }
    public void WithdrawMoney()
    {
        int withdrawAmount;
        System.out.println("Withdraw Money: ");
        System.out.println("1 - $20");
        System.out.println("2 - $40");
        System.out.println("3 - $60");
        System.out.println("4 - $100");
        System.out.println("5 - Back to Main Menu");
        System.out.println("Choice: ");
        withdrawAmount = input.nextInt();
        switch (withdrawAmount)
        {
            case 1:
                checkInsufficientFund(20);
                break;
            case 2:
                checkInsufficientFund(40);
                break;
            case 3:
                checkInsufficientFund(60);
                break;
            case 4:
                checkInsufficientFund(100);
                break;
            default:
                drawMainMenu();
                break;
        }
    }
    public void deposit(int depositMoney)
    {
        System.out.println("Insert Money");
        totalBal+=depositMoney;
    }

    public void addMoney()
    {
        int addFund;
        System.out.println("Deposit Amount: ");
        System.out.println("1 - $20");
        System.out.println("2 - $40");
        System.out.println("3 - $60");
        System.out.println("4 - $100");
        System.out.println("5 - Back to Main Menu");
        System.out.println("Choice: ");
        addFund = input.nextInt();
        switch (addFund)
        {
            case 1:
                deposit(20);
                break;
            case 2:
                deposit(40);
                break;
            case 3:
                deposit(60);
                break;
            case 4:
                deposit(100);
                break;
            default:
                drawMainMenu();
                break;
        }
    }



}
