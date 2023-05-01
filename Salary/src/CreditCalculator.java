import java.text.DecimalFormat;
public class CreditCalculator {
    public void calculator(double money, int month, double personSalary) {
        double amount = personSalary*0.3;
        int intAmount = (int) (money/amount);
        if(money > (personSalary*7.2)) {
            System.out.println("Unfortunately!The maximum amount we could give was "+(personSalary*7.2)+"$");
        }
        else {
            if(money / month > amount) {
                System.out.println("Sorry,We can't give the proposed amount within "+month+" months.");
                System.out.println("We can give the proposed amount for a period of " + (intAmount + 1) + " months");
                // money = 600 ,  month = 6,  salary 1000
            }
            else{
                DecimalFormat df = new DecimalFormat("0.00");
                double moneyMonth = money/month;
                System.out.println("\n            SUCCESS");
                System.out.println("The proposed amount was successfully transferred to the card.");
                System.out.println("Pay amount a month: "+ (df.format(moneyMonth))+"$");
            }
        }
    }
}
