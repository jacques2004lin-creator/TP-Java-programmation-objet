import java.util.Scanner;

public class exercice3 {

    public static boolean carre(int[][] a) {
        if (a == null || a.length == 0) {
            return false;
        }
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == null || a[i].length != n) {
                return false;
            }
        }
        return true;
    }

    public static int ligne(int[][] a, int i) {
        int somme = 0;
        for (int j = 0; j < a[i].length; j++) {
            somme += a[i][j];
        }
        return somme;
    }

    public static int colonne(int[][] a, int j) {
        int somme = 0;
        for (int i = 0; i < a.length; i++) {
            somme += a[i][j];
        }
        return somme;
    }

    public static int diagonale1(int[][] a) {
        int somme = 0;
        for (int i = 0; i < a.length; i++) {
            somme += a[i][i];
        }
        return somme;
    }

    public static int diagonale2(int[][] a) {
        int somme = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            somme += a[i][n - 1 - i];
        }
        return somme;
    }

    public static int[] histogramme(int[][] a, int n) {
        int[] h = new int[n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                int valeur = a[i][j];
                if (valeur >= 1 && valeur <= n) {
                    h[valeur - 1]++;
                }
            }
        }
        return h;
    }

    public static boolean normal(int[][] a) {
        if (!carre(a)) {
            return false;
        }
        int n = a.length;
        int taille = n * n;
        int[] h = histogramme(a, taille);

        for (int k = 0; k < taille; k++) {
            if (h[k] != 1) {
                return false;
            }
        }
        return true;
    }

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

    public static void main(String[] args) {
        int[][] tab = saisie();

        if (!carre(tab)) {
            System.out.println("ce n'est pas un carré magique (la matrice n'est pas carrée).");
            return;
        }

        if (!normal(tab)) {
            System.out.println("ce n'est pas un carré magique normal (il ne contient pas tous les entiers de 1 à n carrée exactement une fois).");
            return;
        }

        int n = tab.length;
        int sommeCible = diagonale1(tab);

        if (diagonale2(tab) != sommeCible) {
            System.out.println("ce n'est pas un carré magique (les diagonales ont des sommes différentes).");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (ligne(tab, i) != sommeCible || colonne(tab, i) != sommeCible) {
                System.out.println("ce n'est pas un carré magique (une ligne ou colonne n'a pas la bonne somme).");
                return;
            }
        }

        System.out.println("c'est bien un carré magique normal ! (somme magique = " + sommeCible + ")");
    }
}