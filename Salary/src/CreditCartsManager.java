import java.io.*;
import java.util.Scanner;

public class CreditCartsManager {
    public CreditCartsManager(int cEnter) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print(" -Serial number: ");
        int sNumber = s.nextInt();
        String uselessFName = "Useless.dll";
        String fName = "Abank.txt";
        File uFile = new File(uselessFName);
        File file = new File(fName);
        FileReader fileReader2 = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader2);
        String lines2 = "";
        int x = 0;
        int y = 0;
        String cCard;
        if (cEnter == 1) {
            cCard = "Credit card";
        } else {
            cCard = "Debit card";
        }
        while ((lines2 = reader.readLine()) != null) {
            var divide = lines2.split(";");
            String seNumber = divide[0].split(":")[1].trim();
            int serialNumber = Integer.parseInt(seNumber);
            var card = divide[5].split(":")[1].trim();
            x++;
            if(serialNumber != sNumber) {
                y++;
            }
            if (serialNumber == sNumber && card.equals("notOwn")) {
                System.out.println("Congratulations," + ((cEnter == 1) ? "Credit card" : "Debit card") + " added to Account.");
                CreditCards creditCards = new CreditCards(sNumber, cEnter);

                break;
            } else if (serialNumber == sNumber && !card.equals("notOwn") && card.equals(cCard)) {
                System.out.println("The proposed card is already available in account.");
                break;
            } else if (serialNumber == sNumber && !card.equals("notOwn") && !card.equals(cCard)) {
                System.out.println(card + " is already keep in account.Do you want to change?");
                System.out.println("     Yes              No\n");
                System.out.print("Enter: "); int mEnter = s.nextInt();
                switch (mEnter) {
                    case 1: CreditCards creditCards = new CreditCards(sNumber, cEnter);
                        break;
                    case 2:
                    default:
                        System.out.println("Credit card is keep on account at the moment.");
                        break;
                }

            }

        }
        if(x == y)
        {
            System.out.println("ERROR: !Account with serial number " + sNumber + " not found!");
        }
    }
}

