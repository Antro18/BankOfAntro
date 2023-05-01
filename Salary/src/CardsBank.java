import java.util.Scanner;

public class CardsBank {
    public CardsBank() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("      Credit cards                Debit cards\n\nEnter: "); int cEnter = s.nextInt();
        switch(cEnter) {
            case 1:
            case 2:
                CreditCartsManager creditCarts = new CreditCartsManager(cEnter);
                break;
        default: System.out.println("ERROR: !Not Found!"); break;
        }
    }
}
