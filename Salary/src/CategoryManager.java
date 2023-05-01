import java.util.Scanner;

public class CategoryManager {

    public  CategoryManager() throws Exception {
        Scanner s = new Scanner(System.in);
        int enter = s.nextInt();
        switch(enter) {
            case 1:CreditDepartment creditDepartment = new CreditDepartment();
            break;
            case 2:AccountManager accountManager = new AccountManager();
            break;
            case 3:CardsBank cardsBank = new CardsBank();
                break;
            case 4:SalaryChange salaryChange = new SalaryChange(new PersonManager());
                break;
            case 5:ContactBank contactBank = new ContactBank();
                break;
            default: System.out.println("Hoping to meet again."); break;
        }

    }

}
