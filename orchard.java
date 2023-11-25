import java.util.Scanner;

public class orchard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input trees for Ashok and Anand
        System.out.print("Enter Ashok's row of trees: ");
        String ashokTrees = scanner.nextLine().toUpperCase();

        System.out.print("Enter Anand's row of trees: ");
        String anandTrees = scanner.nextLine().toUpperCase();

        // Validate input strings
        if (!isValidInput(ashokTrees) || !isValidInput(anandTrees)) {
            System.out.println("Invalid input");
            return;
        }

        int ashokPossibilities = countPossibilities(ashokTrees);
        int anandPossibilities = countPossibilities(anandTrees);

        if (ashokPossibilities > anandPossibilities) {
            System.out.println("Ashok");
        } else if (anandPossibilities > ashokPossibilities) {
            System.out.println("Anand");
        } else {
            System.out.println("Draw");
        }
    }

    static boolean isValidInput(String trees) {
        return trees.matches("[ML]+");
    }

    static int countPossibilities(String trees) {
        int possibilities = 0;
        for (int i = 0; i < trees.length() - 2; i++) {
            if (trees.charAt(i) != trees.charAt(i + 1) && trees.charAt(i + 1) != trees.charAt(i + 2)
                    && trees.charAt(i) != trees.charAt(i + 2)) {
                possibilities++;
            }
        }

        return possibilities;
    }
}
