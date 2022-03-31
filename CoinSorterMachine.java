import java.io.File;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Class CoinSorterMachine gives a deposit summary and total deposit for a user given coin data set
 * @version 3/31/22
 * @author 22niedel
 */

public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    public int pennies, nickels, dimes, quarters, halfDs, dollars;

    /**
     * initializes coins ArrayList
     */
    public CoinSorterMachine() {
        coins = new ArrayList<>();
    }

    /**
     * method depositCoins uses two scanner objects to access the user given coin file and add coins to
     * coins array list and add coins to corresponding ints
     */
    public void depositCoins(){
        Scanner UserIn = new Scanner(System.in);
        System.out.println("Enter the name of the data file for coin deposit: ");
        try{
            Scanner filein = new Scanner(new File(UserIn.nextLine()));
            UserIn.close();
            System.out.println("Depositing coins ");
            while(filein.hasNext()) {
                int val = filein.nextInt();
                if(val == 1) {
                    coins.add(new Penny());
                    pennies++;
                }
                else if(val == 5) {
                    coins.add(new Nickel());
                    nickels++;
                }
                else if(val == 10) {
                    coins.add(new Dime());
                    dimes++;
                }
                else if(val == 25) {
                    coins.add(new Quarter());
                    quarters++;
                }
                else if(val == 50) {
                    coins.add(new HalfDollar());
                    halfDs++;
                }
                else if(val == 100) {
                    coins.add(new Dollar());
                    dollars++;
                }
                else System.out.println("Coin value " + val + " not recognized");
                }
            filein.close();
            }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints deposit summary, the number of coins and the value of those coins, using a DecimalFormat object
      */
    public void printDepositSummary(){
        DecimalFormat df = new DecimalFormat("$0.00");
        System.out.println("Summary of Deposit:");
        if(pennies == 1) System.out.println(pennies + " penny $0.01");
        else
            System.out.println(pennies + " pennies " + df.format(pennies*.01));
        if(nickels == 1) System.out.println(nickels + " nickel $0.05");
        else
            System.out.println(nickels + " nickels " + df.format(nickels * .05));
        if(dimes == 1) System.out.println(dimes + " dime $0.10");
        else
            System.out.println(dimes + " quarters " + df.format(dimes * .10));
        if(quarters == 1) System.out.println(quarters + " quarter $0.25");
        else
            System.out.println(quarters + " quarters " + df.format(quarters * .25));
        if(halfDs == 1) System.out.println(halfDs + " half dollar $0.50");
        else
            System.out.println(halfDs + " half dollars " + df.format(halfDs * .50));
        if(dollars == 1) System.out.println(dollars + " dollar $1.00");
        else
            System.out.println(dollars + " dollars " + df.format(dollars * 1.00));
        System.out.println("TOTAL DEPOSIT: " + df.format(getTotalValue()));
    }

    /**
     * return the total value of all Coin objects stored in coins as a double
     */
    public double getTotalValue() {
        double total = 0;
        for(Coin c : coins)
            total += c.getValue();
        return total;

    }

    /**
     * main entry point for CoinSorterMachine
     * @param args
      */
    public static void main(String[] args) {
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}
