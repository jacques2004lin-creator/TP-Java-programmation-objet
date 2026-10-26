public class Main {
    public static void main(String[] args) {
        Compte c1 = new Courant("Biloute", 521.0);
        System.out.println(c1.toString());
        
        Securise c2 = new Securise("Alice", 1000.0);
        c2.debiter(1500.0);

        Remunere c3 = new Remunere("Bob", 200.0, 5);
        c3.calculInteret();

        RemunereSecurise c4 = new RemunereSecurise("Charlie", 500.0, 2);
        
        Agence agence = new Agence("Banque Centrale", 10);
        agence.ajouter(c1);
        agence.ajouter(c2);
        agence.ajouter(c3);
        agence.ajouter(c4);
        
        System.out.println("\nAffichage global de l'agence");
        System.out.println(agence.toString());
        
        agence.supprimer(c1.getNumero());
        System.out.println("\nAprès suppression du compte " + c1.getNumero());
        System.out.println(agence.toString());
    }
}