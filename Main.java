import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Main Class
 */
public class Main {
    public static void main(String[] args) {
        // Cow[] cows = {};
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Welcome! Enter the number of cows you have: ");
        int numCows = scanner.nextInt();
        if(numCows ==0) {
            System.out.println("You have no cows. ");
            System.exit(0);
        }

        Cow[] cows = new Cow[numCows];
        
        for(int i = 0; i < numCows; i++) {
            System.out.print("Enter a new Cow ID: ");
            String cowID = scanner.next();
            if(cowID.length() != 3 || !isInteger(cowID)) {
                System.out.println("Invalid Cow ID! " + cowID);
                i--;
                continue;
            }

            // cows.add(new Cow(cowID));
            cows[i] = new Cow(cowID);
        }

        System.out.println("");

        // Collect data
        for(int i = 0; i < numCows; i++) {
            DecimalFormat df = new DecimalFormat("#.#");
            System.out.print("Enter the number of litres that cow " + cows[i].cowIdentityCode + " produces. ");
            double numLitres = scanner.nextDouble();
            numLitres = Double.parseDouble(df.format(numLitres));
            cows[i].setNumLitres(numLitres);
        }
        
        // Get statistics
        double totalVolume = 0;
        double averageVolume = 0;
        
        for (int i = 0; i < numCows; i++) {
            Cow cow = cows[i];
            totalVolume += cow.numLitresProduced;
        }
        
        DecimalFormat df = new DecimalFormat("#.#");
        averageVolume = Double.parseDouble(df.format(totalVolume / cows.length));

        System.out.println("");
        System.out.println("Total milk: " + totalVolume + " litres. ");
        System.out.println("Average milk: " + averageVolume + " litres. ");

        scanner.close();
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input, 10);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}