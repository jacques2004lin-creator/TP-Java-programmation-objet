import java.util.Scanner;

public class exercice2 {

    public static int[][] saisie() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("nombre de lignes (n) : ");
        int n = scanner.nextInt();

        System.out.print("nombre de colonnes (m) : ");
        int m = scanner.nextInt();

        int[][] tableau = new int[n][m];

        System.out.println("entrez les " + (n * m) + " entiers :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tableau[i][j] = scanner.nextInt();
            }
        }

        return tableau;
    }

    public static void affichage(int[][] a) {
        if (a == null || a.length == 0) {
            System.out.println("le tableau est vide.");
            return;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean recherche(int[][] a, int v) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == v) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("saisie du tableau");
        int[][] montableau = saisie();

        System.out.println("\naffichage du tableau");
        affichage(montableau);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nvaleur à chercher : ");
        int valeur = scanner.nextInt();

        if (recherche(montableau, valeur)) {
            System.out.println("la valeur " + valeur + " est présente dans le tableau.");
        } else {
            System.out.println("la valeur " + valeur + " n'a pas été trouvée.");
        }
    }
}