public class Testcompte {
    public static void main(String[] args) {
        Compte c1 = new Compte();
        Compte c2 = new Compte();
        c1.depot(500);
        c1.virement(75, c2);
        c2.depot(1000);
        c2.retrait(10);

        System.out.println("Compte 1 :");
        c1.afficher();
        System.out.println("Compte 2 :");
        c2.afficher();
    }
}

