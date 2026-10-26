import java.util.Scanner;

public class exercice1 {
    public static void main ( String [] args )
    {
        Scanner input = new Scanner(System.in) ;
        double a= input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double somme = a + b + c;
        double moyenne = somme / 3;

        System.out.println("Notes : a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("Somme = " + somme);
        System.out.println("Moyenne = " + moyenne);

        input.close();
    }
}