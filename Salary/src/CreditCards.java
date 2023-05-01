import java.io.*;

public class CreditCards {

    public  CreditCards(int sNumber, int cEnter) throws IOException {

        String uselessFName = "Useless.dll";
        String fName = "Abank.txt";
        File uFile = new File(uselessFName);
        File file = new File(fName);

        if (!uFile.exists()) {
            uFile.createNewFile();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader read = new BufferedReader(fileReader);
        FileWriter uFWriter = new FileWriter(uFile, true);
        String lines = "";
        while ((lines = read.readLine()) != null) {
            var divide = lines.split(";");
            String seNumber = divide[0].split(":")[1].trim();
            var name = divide[1].split(":")[1].trim();
            var sName = divide[2].split(":")[1].trim();
            var yoBirth = divide[3].split(":")[1].trim();
            var position = divide[4].split(":")[1].trim();
            var card = divide[5].split(":")[1].trim();
            var salary = divide[6].split(":")[1].trim();
            int serialNumber = Integer.parseInt(seNumber);
            if (serialNumber != sNumber) {
                uFWriter.write("Serial number: " + seNumber + "; Name: " + name + "; Surname: " + sName + "; YearOfBirth: " + yoBirth + "; Position: " + position + "; AntroCard: " + card + "; Salary: " + salary + "\n");
            } else {
                uFWriter.write("Serial number: " + seNumber + "; Name: " + name + "; Surname: " + sName + "; YearOfBirth: " + yoBirth + "; Position: " + position + "; AntroCard: "+((cEnter == 1)?"Credit card":"Debit card")+"; Salary: " + salary + "\n");
            }
        }
        read.close();
        uFWriter.close();
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.close();

        FileReader fileReader1 = new FileReader(uFile);
        BufferedReader read1 = new BufferedReader(fileReader1);
        FileWriter fileWriter1 = new FileWriter(file, true);
        String lines1 = "";
        while ((lines1 = read1.readLine()) != null) {
            var divide = lines1.split(";");
            var seNumber = divide[0].split(":")[1].trim();
            var name = divide[1].split(":")[1].trim();
            var sName = divide[2].split(":")[1].trim();
            var yoBirth = divide[3].split(":")[1].trim();
            var position = divide[4].split(":")[1].trim();
            var card = divide[5].split(":")[1].trim();
            var salary = divide[6].split(":")[1].trim();

            fileWriter1.write("Serial number: " + seNumber + "; Name: " + name + "; Surname: " + sName + "; YearOfBirth: " + yoBirth + "; Position: " + position + "; AntroCard: " + card + "; Salary: " + salary + "\n");

        }
        fileWriter1.close();
        read1.close();

        FileWriter fileWriter2 = new FileWriter(uFile, false);
        fileWriter2.close();
    }
}
