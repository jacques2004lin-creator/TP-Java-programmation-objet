import java.util.Scanner;

public class personne {
    private static int nbInstances = 0;

    private String nom;
    private String prenom;
    private int anneeNaissance;
    private char sexe;
    private boolean enCouple;

    public personne(String nom, String prenom, int anneeNaissance, char sexe, boolean enCouple) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
        this.sexe = sexe;
        this.enCouple = enCouple;
        nbInstances++;
    }

    public personne(String nom, String prenom, int anneeNaissance, char sexe) {
        this(nom, prenom, anneeNaissance, sexe, false);
    }

    public static int getNbInstances() {
        return nbInstances;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public int getAnneeNaissance() { return anneeNaissance; }
    public void setAnneeNaissance(int anneeNaissance) { this.anneeNaissance = anneeNaissance; }

    public char getSexe() { return sexe; }
    public void setSexe(char sexe) { this.sexe = sexe; }

    public boolean isEnCouple() { return enCouple; }
    public void setEnCouple(boolean enCouple) { this.enCouple = enCouple; }

    public int age(int annee) {
        if (annee < this.anneeNaissance) {
            throw new IllegalArgumentException("l'année spécifiée est la naissance.");
        }
        return annee - this.anneeNaissance;
    }

    public void afficheInfos() {
        boolean estHomme = (this.sexe == 'M' || this.sexe == 'm');

        String civilite = estHomme ? "M." : "Mme.";
        String accord = estHomme ? "né" : "née";
        String pronom = estHomme ? "il" : "elle";
        String statut = this.enCouple ? "en couple" : "célibataire";

        System.out.println(civilite + " " + this.prenom + " " + this.nom + " est " + accord
                + " en " + this.anneeNaissance + ", " + pronom + " est " + statut + ".");
    }

    private static personne saisirPersonne(Scanner sc, int numero) {
        System.out.println("\n Saisie de la personne n" + numero + " ---");

        System.out.print("nom : ");
        String nom = sc.nextLine();

        System.out.print("prénom : ");
        String prenom = sc.nextLine();

        System.out.print("année de naissance : ");
        int annee = sc.nextInt();

        System.out.print("Sexe (M/F) : ");
        char sexe = sc.next().toUpperCase().charAt(0);

        System.out.print("En couple ? (oui/non) : ");
        String reponse = sc.next();
        boolean enCouple = reponse.equalsIgnoreCase("oui");

        sc.nextLine();

        return new personne(nom, prenom, annee, sexe, enCouple);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        personne p1 = saisirPersonne(scanner, 1);
        personne p2 = saisirPersonne(scanner, 2);
        personne p3 = saisirPersonne(scanner, 3);

        System.out.println("\n informations enregistrées");
        p1.afficheInfos();
        p2.afficheInfos();
        p3.afficheInfos();

        System.out.println("\n nombre total de personnes créées : " + personne.getNbInstances());

        scanner.close();
    }
}