import java.util.Scanner;

public class exercice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la température en degrés Celsius : ");
        double c = scanner.nextDouble();
        double f = (c * 9/5) + 32;
        System.out.println("La température en degrés Fahrenheit est : " + f);
        scanner.close();
    }
}