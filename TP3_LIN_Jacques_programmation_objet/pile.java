import java.util.Scanner;

public class pile {
    private int t[] ;
    private int taille;
    private int haut_de_la_pile;

    public pile(int n) {
        this.taille = n;
        this.t = new int[n];
        this.haut_de_la_pile = -1;
    }

    public boolean vide() {
        return this.haut_de_la_pile == -1;
    }

    public boolean pleine() {
        return this.haut_de_la_pile == this.taille - 1;
    }

    public int hautdelapile() {
        if (vide()) {
            throw new IllegalStateException("la pile est vide.");
        }
        return this.t[this.haut_de_la_pile];
    }

    public void empiler(int x) {
        if (pleine()) {
            throw new IllegalStateException("la pile est pleine.");
        }
        this.haut_de_la_pile++;
        this.t[this.haut_de_la_pile] = x;
    }

    public int depiler() {
        if (vide()) {
            throw new IllegalStateException("la pile est vide.");
        }
        int valeur = this.t[this.haut_de_la_pile];
        this.haut_de_la_pile--;
        return valeur;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("entrez la capacité maximale de la pile (n) : ");
        int n = scanner.nextInt();

        pile pile = new pile(n);
        System.out.println("pile vide créée avec une capacité de " + n + " éléments.");

        int choix;
        do {
            System.out.println("empiler un entier");
            System.out.println("dépiler un entier");
            System.out.println("voir le haut de la pile");
            System.out.println("tester si la pile est vide");
            System.out.println("tester si la pile est pleine");
            System.out.println("quitter");
            System.out.print("choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    if (pile.pleine()) {
                        System.out.println("opération refusée : la pile est déjà pleine.");
                    } else {
                        System.out.print("entier à ajouter : ");
                        int val = scanner.nextInt();
                        pile.empiler(val);
                        System.out.println(val + " a été empilé.");
                    }
                    break;

                case 2:
                    if (pile.vide()) {
                        System.out.println("opération refusée : la pile est vide.");
                    } else {
                        System.out.println("valeur dépilée : " + pile.depiler());
                    }
                    break;

                case 3:
                    if (pile.vide()) {
                        System.out.println("la pile est vide, aucun élément au sommet.");
                    } else {
                        System.out.println("element au haut de la pile : " + pile.hautdelapile());
                    }
                    break;

                case 4:
                    System.out.println(pile.vide() ? "resultat : la pile est vide." : "Résultat : la pile n'est pas vide.");
                    break;

                case 5:
                    System.out.println(pile.pleine() ? "resultat : la pile est pleine." : "Résultat : la pile n'est pas pleine.");
                    break;

                case 0:
                    System.out.println("fin du test.");
                    break;

                default:
                    System.out.println("option inexistante.");
            }
        } while (choix != 0);

        scanner.close();
    }
}