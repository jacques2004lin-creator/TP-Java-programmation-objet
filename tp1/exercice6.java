import java.util.Scanner;

public class exercice6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le symbole pour entourer la boîte : ");
        char symbole = scanner.next().charAt(0);

        int lignes = 5;
        int colonnes = 6;

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (i == 0 || i == lignes - 1 || j == 0 || j == colonnes - 1) {
                    System.out.print(symbole + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}