import java.util.Scanner;

public class exercice1_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Combien de notes voulez-vous saisir ? ");
        int n = input.nextInt();

            double somme = 0;

            for (int i = 1; i <= n; i++) {
                System.out.print("Note " + i + " : ");
                double note = input.nextDouble();
                somme += note;
            }

            double moyenne = somme / n;

            System.out.println("Somme totale = " + somme);
            System.out.println("Moyenne = " + moyenne);

        input.close();
    }
}