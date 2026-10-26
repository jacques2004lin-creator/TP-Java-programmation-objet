import java.util.Scanner;

public class age {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);

        System.out.print("entrez votre prenom :");
        String prenom = scanner.nextLine();
        
        System.out.print("entrez votre age:");
        int age = scanner.nextInt();

        System.out.println("bonjours, " + prenom + " vous avez " + age + " ans");

        scanner.close();
    }
    
}
