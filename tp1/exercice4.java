import java.util.Scanner;

public class exercice4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le prix hors taxes : ");
        double prixHT = scanner.nextDouble();

        double montantTVA = (prixHT * 1.2) - prixHT;
        double prixTTC = prixHT + montantTVA;

        System.out.println("Résultats");
        System.out.println("Montant de la TVA : " + montantTVA);
        System.out.println("Prix TTC : " + prixTTC);

        scanner.close();
    }
}
