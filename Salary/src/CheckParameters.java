import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CheckParameters {
    public boolean check(String serialNumber, int yoBirth, String position) throws Exception {
        int nowYear = 2023;
        boolean check = true;
        String fileName = "ABank.txt";
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader read = new BufferedReader(fileReader);
        String lines;
        // Serial number: 33033; Name: Dadas; Surname: Qurbanov; YearOfBirth: 1997; Position: Employee; Salary: 1700.0
        while((lines = read.readLine()) != null) {
            var divide = lines.split(";");
            String sNumber = divide[0].split(":")[1].trim();
            if(sNumber.equals(serialNumber)) {
                System.out.println("ERROR: The serial number already used!");
                return false;
            }
        }
        read.close();
        if(serialNumber.length() < 5) {
            System.out.println("ERROR: Serial Number incorrectly!");
            return false;
        }

        switch(position) {
            case "Student": if(nowYear-yoBirth < 17 || nowYear-yoBirth > 24) {
                check = false;
            }
            break;
            case "Older": if(nowYear-yoBirth < 60) {
                check = false;
            }
            break;
            case "Employee": if(nowYear-yoBirth < 18 || nowYear-yoBirth >= 60) {
                check = false;
            }
            break;
            case "Businessman": if(nowYear-yoBirth < 18) {
                check = false;
            }
            break;
            case "Unemployed":if(nowYear-yoBirth > 17) {
                check = false;
            }
            break;

        }
        if(check){
            return true;
        }
        else {
            System.out.println("ERROR: Your position incorrectly!");
            return false;
        }
    }


}
