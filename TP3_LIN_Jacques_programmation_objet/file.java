import java.util.Scanner;

public class file {
    private int t[] ;
    private int debut;
    private int fin;
    private int taille;
    private final int capacitemax;

    public file(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("La taille maximale doit être positive : " + n);
        }
        this.capacitemax = n;
        this.t = new int[n];
        this.debut = 0;
        this.fin = 0;
        this.taille = 0;
    }
    public boolean vide() {
        return this.taille == 0;
    }

     public boolean pleine() {
        return this.taille == this.capacitemax;
    }

    public int tete() {
        if (vide()) {
            throw new IllegalStateException("la file est vide.");
        }
        return this.t[this.debut];
    }

    public void enfiler(int x) {
        if (this.pleine()) {
            throw new IllegalStateException("la file est pleine.");
        }
        this.t[this.fin] = x;
        this.fin = (this.fin + 1) % this.capacitemax;
        this.taille++;
    }

    public int defiler() {
        if (vide()) {
            throw new IllegalStateException("la file est vide.");
        }
        int element = this.t[this.debut];
        this.debut = (this.debut + 1) % this.capacitemax;
        return element;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("entrez la capacité maximale de la file : ");
        int n = scanner.nextInt();
        file file = new file(n);
        System.out.println("file initialisée avec une capacité de " + n + " éléments.");

        boolean actif = true;
        while (actif) {
            System.out.println("enfiler un entier");
            System.out.println("défiler un entier");
            System.out.println("consulter la tête de file");
            System.out.println("tester si la file est vide");
            System.out.println("tester si la file est pleine");
            System.out.println("quitter");
            System.out.print("votre choix : ");

            int choix = scanner.nextInt();

            try {
                switch (choix) {
                    case 1:
                        System.out.print("Valeur à enfiler : ");
                        int val = scanner.nextInt();
                        file.enfiler(val);
                        System.out.println("Entier " + val + " ajouté.");
                        break;
                    case 2:
                        int retire = file.defiler();
                        System.out.println("élément retiré : " + retire);
                        break;
                    case 3:
                        System.out.println("tete actuelle : " + file.tete());
                        break;
                    case 4:
                        System.out.println("file vide ? " + (file.vide() ? "Oui" : "Non"));
                        break;
                    case 5:
                        System.out.println("file pleine ? " + (file.pleine() ? "Oui" : "Non"));
                        break;
                    case 0:
                        actif = false;
                        System.out.println("arrêt du programme.");
                        break;
                    default:
                        System.out.println("choix non reconnu.");
                }
            } catch (IllegalStateException e) {
                System.out.println(" sa ne marche pas " + e.getMessage());
            }
        }

        scanner.close();
    }
}
