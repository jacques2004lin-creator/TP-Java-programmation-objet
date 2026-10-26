public class Main {
    public static void main(String[] args) {
        Enseignantchercheur ec = new Enseignantchercheur("Dupont", "Jean");
        ec.attribuerheures(200);
        System.out.println("Coût annuel de l'enseignant-chercheur : " + ec.cout() + " euros");

        Vacataire v = new Vacataire("Martin", "Sophie", "cnam");
        v.attribuerheures(50);
        System.out.println("Coût annuel du vacataire : " + v.cout() + " euros");
    }
}
