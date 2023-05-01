import javax.management.BadStringOperationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AccountManager {
    public AccountManager() throws Exception{
       // Runtime.getRuntime().exec("cls");
        Scanner s = new Scanner(System.in);
        String fileName = "ABank.txt";
        File file = new File(fileName);
        System.out.println("-_-_-_-_-_-_-_-_-_-_-Account-_-_-_-_-_-_-_-_-_-_-");
        System.out.print("\n    CurrentAccount              New account\n\nEnter: "); int aEnter = s.nextInt();
        switch(aEnter) {
            case 1:System.out.print("\n-Serial Number: "); String seNumber = s.next();
                FileReader fileReader = new FileReader(file);
                BufferedReader read = new BufferedReader(fileReader);
                String lines;
                // Serial number: 33033; Name: Dadas; Surname: Qurbanov; YearOfBirth: 1997; Position: Employee; Salary: 1700.0
                while((lines = read.readLine()) != null) {
                       var divide = lines.split(";");
                       var serialNumber = divide[0].split(":")[1].trim();
                       var nname = divide[1].split(":")[1];
                       var surName = divide[2].split(":")[1];
                       var yOBirth = divide[3].split(":")[1];
                       var pposition = divide[4].split(":")[1];
                       var card = divide[5].split(":")[1];
                       var ssalary = divide[6].split(":")[1];
                       if(serialNumber.equals(seNumber)) {
                           System.out.println("Personal information");
                           System.out.println(" -Name:"+ nname);
                           System.out.println(" -SurName:"+ surName);
                           System.out.println(" -YearOfBirth:"+ yOBirth);
                           System.out.println(" -Position:"+ pposition);
                           System.out.println(" -AntroCard:"+card);
                           System.out.println(" -Salary:"+ssalary+"$");
                           System.out.println("*Please,don't share");
                           return;
                       }
                   }
                   System.out.println("Account doesn't exist.");
                read.close();
                break;
            case 2:// Runtime.getRuntime().exec("cls");
                SalaryManager[] salaryManagers = new SalaryManager[]{new StudentSalary(), new OlderSalary(),new BusinessmanSalary(), new EmployeeSalary(), new UnemployedSalary()};
                PersonManager personManager = new PersonManager(salaryManagers);
                System.out.println("-_-_-_-_-New Account-_-_-_-_-");
                System.out.print("\n-Serial Number: "); String sNumber = s.next();
                System.out.print(" -Name: "); String name = s.next();
                System.out.print(" -Surname: "); String surName = s.next();
                System.out.print(" -YearOfBirth: "); int yOfBirth = s.nextInt();
                System.out.print(" -Your position: "); String position = s.next();
                double salaryamount = 0;
                switch(position) {
                    case "Student":  salaryamount = salaryManagers[0].Salary(personManager.getSalary());
                        break;
                    case "Older": salaryamount = salaryManagers[1].Salary(personManager.getSalary());
                        break;
                    case "Businessman": salaryamount = salaryManagers[2].Salary(personManager.getSalary());
                        break;
                    case "Employee": salaryamount = salaryManagers[3].Salary(personManager.getSalary());
                        break;
                    case "Unemployed": salaryamount = salaryManagers[4].Salary(personManager.getSalary());
                        break;
                    default: System.out.println("ERROR: !New Account wasn't created!"); break;

                }
                CheckParameters checkParameters = new CheckParameters();
                boolean parameters = checkParameters.check(sNumber, yOfBirth, position);
                if(salaryamount != 0 && parameters == true) {
                    FileWriter aWriter = new FileWriter(file, true);
                    aWriter.write("Serial number: " + sNumber + "; Name: " + name + "; Surname: " + surName + "; YearOfBirth: "+yOfBirth+"; Position: " + position+"; AntroCard: notOwn; Salary: "+salaryamount+"\n");
                    System.out.println("Good Luck with the New Account:)");
                    aWriter.close();
                }
                break;
            default:System.out.println("ERROR: !Not Found!"); break;
        }

    }

}
