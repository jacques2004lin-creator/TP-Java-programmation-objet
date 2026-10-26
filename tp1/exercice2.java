import java.util.Scanner;

public class exercice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le rayon du cercle : ");
        double rayon = scanner.nextDouble();

        double perimetre = 2 * Math.PI * rayon;
        double surface = Math.PI * rayon * rayon;

        System.out.println("Résultats ");
        System.out.println("Périmètre : " + perimetre);
        System.out.println("Surface   : " + surface);

        scanner.close();
    }
}
