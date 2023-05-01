import java.util.Scanner;

public class SalaryChange {
    public SalaryManager _salaryManager;
    public SalaryChange(PersonManager personManager) throws Exception {
        _salaryManager = personManager;
        Scanner s = new Scanner(System.in);
        int securityCode = 123113;
        System.out.print("Security code: "); int sCode = s.nextInt();
        if(sCode == 123113) {
                System.out.print("   Current minimum wage               Minimum wage change\n\n Enter: "); int sEnter = s.nextInt();
                switch (sEnter) {
                    case 1: System.out.println("Current minimum wage: " + _salaryManager.getSalary()+"$");
                    break;
                    case 2:System.out.println("Current minimum wage: " + _salaryManager.getSalary()+"$");
                        System.out.print("New minimum wage: ");
                        double minWage = s.nextDouble();
                        if(minWage >= 200) {
                            if(_salaryManager.getSalary() == minWage) {
                                System.out.println("The same minimum wage was included.");
                            }
                            else {
                                _salaryManager.setSalary(minWage);
                                System.out.println("The minimum wage was successfully changed.");
                            }
                        }
                        else {
                            System.out.println("Minimum wage was NOT accepted");
                        }
                        break;
                    default: System.out.println("ERROR: !Not Found!"); break;
                }
        }
        else {
            System.out.println("ERROR: !The security code was entered false!");
        }
    }
}
