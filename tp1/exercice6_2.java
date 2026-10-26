import java.util.Scanner;

public class exercice6_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le symbole pour la boîte : ");
        char symbole = scanner.next().charAt(0);

        System.out.print("Entrez la hauteur (nombre de lignes) : ");
        int lignes = scanner.nextInt();

        System.out.print("Entrez la largeur (nombre de colonnes) : ");
        int colonnes = scanner.nextInt();

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