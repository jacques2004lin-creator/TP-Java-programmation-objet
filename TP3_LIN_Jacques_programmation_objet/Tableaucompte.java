public class Tableaucompte {
    public static void main(String[] args) {
        Compte[] comptes = new Compte[10];

        for (int i = 0; i < comptes.length; i++) {
            comptes[i] = new Compte();
            comptes[i].depot(200  +(100 * 1));
        }

        System.out.println("soldes dépôts :");
        for (int i = 0; i < comptes.length; i++) {
            System.out.println("Compte n " + i + " : " + comptes[i].solde);
        }
    }
}
