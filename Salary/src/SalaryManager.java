import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public  abstract class SalaryManager {

    public abstract double Salary(double Salary);

    public double getSalary() throws  Exception {
        String fName = "Security.txt";
        File file1 = new File(fName);
        FileReader fileReader = new FileReader(file1);
        BufferedReader read = new BufferedReader(fileReader);
        String lines;
        String wage = "";
        while((lines = read.readLine()) != null) {
             wage = lines;
        }
        double minWage = Double.parseDouble(wage);
        read.close();
        return minWage;
    }
    public void setSalary(double minWage) throws Exception{
        String wage = String.valueOf(minWage);
        String fName = "Security.txt";
        File file1 = new File(fName);

        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write(wage);
        fileWriter.close();

        SalaryManager[] salaryManagers = new SalaryManager[]{new StudentSalary(), new OlderSalary(),new BusinessmanSalary(), new EmployeeSalary(), new UnemployedSalary()};
        String file = "ABank.txt";
        String uFile = "Useless.dll";
        File UFile = new File(uFile);
        FileWriter aWriter = new FileWriter(UFile, true);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String lines;
        while((lines = reader.readLine()) != null) {

            var divide = lines.split(";");
            var serialNumber = divide[0].split(":")[1].trim();
            var name = divide[1].split(":")[1].trim();
            var sName = divide[2].split(":")[1].trim();
            var yoBirth = divide[3].split(":")[1].trim();
            var position = divide[4].split(":")[1].trim();
            var card = divide[5].split(":")[1].trim();
            double salaryamount = 0;
            switch(position) {
                case "Student":  salaryamount = salaryManagers[0].Salary(minWage);
                    break;
                case "Older": salaryamount = salaryManagers[1].Salary(minWage);
                    break;
                case "Businessman": salaryamount = salaryManagers[2].Salary(minWage);
                    break;
                case "Employee": salaryamount = salaryManagers[3].Salary(minWage);
                    break;
                case "Unemployed": salaryamount = salaryManagers[4].Salary(minWage);
                    break;
                default: System.out.println("ERROR: !"); break;
            }
            aWriter.write("Serial number: "+serialNumber+"; Name: " + name + "; Surname: " + sName + "; YearOfBirth: "+yoBirth+"; Position: " + position+"; AntroCard: "+card+"; Salary: "+salaryamount+"\n");

        }
        aWriter.close(); reader.close();

        FileWriter fileWriter1 = new FileWriter(file, false);
        fileWriter1.close();

        FileWriter fileWriter2 = new FileWriter(file, true);
        FileReader fileReader1 = new FileReader(UFile);
        BufferedReader reader1 = new BufferedReader(fileReader1);

        String lines1 ;
        while((lines1 = reader1.readLine()) != null) {
            var divide = lines1.split(";");
            var seNumber = divide[0].split(":")[1].trim();
            var name = divide[1].split(":")[1].trim();
            var sName = divide[2].split(":")[1].trim();
            var yoBirth = divide[3].split(":")[1].trim();
            var position = divide[4].split(":")[1].trim();
            var card = divide[5].split(":")[1].trim();
            var sAmount = divide[6].split(":")[1].trim();

            fileWriter2.write("Serial number: " + seNumber + "; Name: " + name + "; Surname: " + sName + "; YearOfBirth: "+yoBirth+"; Position: " + position+"; AntroCard: "+card+"; Salary: "+sAmount+"\n");

        }
        fileWriter2.close(); reader1.close();
        FileWriter fileWriter3 = new FileWriter(UFile, false);
        fileWriter3.close();
    }
}
