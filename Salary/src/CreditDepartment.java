import java.util.*;
import java.io.*;
public class CreditDepartment {
    public CreditDepartment() throws Exception{

        String fileName = "ABank.txt";
        File file = new File(fileName);
        if(!file.exists()) {
            file.createNewFile();
        }

        Scanner s = new Scanner(System.in);
        System.out.print("Serial Number: "); String sNumber = s.next();
        boolean checking = false;
        boolean checking2 = false;
        FileReader read = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(read);
        String lines;
        double salary = 0;
        String ssalary;
        String cCard = "Credit card";
        while((lines = bufferedReader.readLine()) != null) {

            var divide = lines.split(";");
            String serialNumber = divide[0].split(":")[1].trim();
            ssalary = divide[6].split(":")[1].trim();
            String card = divide[5].split(":")[1].trim();

            if(serialNumber.equals(sNumber)) {
                salary = Double.parseDouble(ssalary);
                checking = true;
            }

            if(serialNumber.equals(sNumber)  &&  (!card.equals(cCard))) {
                checking2 = true;
            }

        }
        bufferedReader.close();
        if(checking2) {
            System.out.println("Credit card not found on account!");
        }
        else {
            if (checking) {
                System.out.print("Say the credit amount: ");
                double money = s.nextInt();
                System.out.print("The duration of the month: ");
                int month = s.nextInt();
                CreditCalculator creditCalculator = new CreditCalculator();
                creditCalculator.calculator(money, month, salary);
            } else {
                System.out.println("No person found!");
            }
        }
    }
}
