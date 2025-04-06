import java.util.*;

public class SafariAdventure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] validAreas = {"Jungle", "River", "Desert", "Mountains"};
        int totalPoints = 0;

        System.out.println(" Welcome to Safari Adventure!");

        // for loop for 5 days of exploration
        for (int day = 1; day <= 5; day++) {
            System.out.println("\nDay " + day + ":");

            String area;
            // do...while loop for area selection
            do {
                System.out.print("Where would you like to explore? (Jungle, River, Desert, Mountains): ");
                area = scanner.nextLine().trim();
            } while (!isValidArea(area, validAreas));

            System.out.println("\nYou chose: " + area);
            System.out.println("Exploring " + area + "...");

            int dailyPoints = 0;
            int eventCount = 0;

            // while loop - up to 3 events
            while (eventCount < 3) {
                eventCount++;

                int eventType = random.nextInt(5); // 0 to 4
                // switch statement to keep it easy and to further add or remove events
                switch (eventType) {
                    case 0:
                        System.out.println("Event " + eventCount + ": You spotted a bird. ");
                        System.out.println("(Too small to track. Moving on.)");
                        continue; // skip to next event
                    case 1:
                        System.out.println("Event " + eventCount + ": You found edible berries! (+15 points)");
                        dailyPoints += 15;
                        break;
                    case 2:
                        System.out.println("Event " + eventCount + ": You discovered fresh water! (+20 points)");
                        dailyPoints += 20;
                        break;
                    case 3:
                        System.out.println("Event " + eventCount + ": A violent storm slows you down! (+5 points)");
                        dailyPoints += 5;
                        break;
                    case 4:
                        String danger = random.nextBoolean() ? "lion" : "crocodile";
                        System.out.println("Event " + eventCount + ": A " + danger + " appears! ");
                        System.out.print("Type 'run' to escape: ");
                        String response = scanner.nextLine().trim().toLowerCase();
                        if (response.equals("run")) {
                            System.out.println("You escaped safely, ending the day early.");
                            break; // escape the day loop
                        } else {
                            System.out.println("You hesitated and lost your chance to escape. No points this event.");
                        }
                        break;
                }
            }

            totalPoints += dailyPoints;
            System.out.println("\nDay Summary: " + dailyPoints + " points earned.");
            System.out.println("-----------------------------------");
        }

        // Final Summary
        System.out.println("\n Safari Complete! You collected " + totalPoints + " points!");
        if (totalPoints >= 100) {
            System.out.println("You survived and completed the adventure! ");
        } else {
            System.out.println("You didn't collect enough resources to survive. Better luck next time. ");
        }

        scanner.close();
    }

    // Helper function to check valid area
    private static boolean isValidArea(String area, String[] validAreas) {
        for (String valid : validAreas) {
            if (valid.equalsIgnoreCase(area)) {
                return true;
            }
        }
        System.out.println("Invalid area. Please choose again.");
        return false;
    }
}
