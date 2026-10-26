public class exercice5 {
    public static void main(String[] args) {
        int lignes = 5;
        int colonnes = 6;

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (i == 0 || i == lignes - 1 || j == 0 || j == colonnes - 1) {
                    System.out.print('+');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}