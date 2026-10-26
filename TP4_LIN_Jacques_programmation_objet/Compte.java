public abstract class Compte {
    public static int nbTotalCompte = 0;
    private String titulaire;
    private double solde;
    private int numero;
    private String titre;

    public Compte(String titulaire, double soldeInitial, String titre) {
        this.titulaire = titulaire;
        this.solde = soldeInitial;
        this.titre = titre;
        nbTotalCompte++;
        this.numero = nbTotalCompte;
    }

    public void crediter(double montant) {
        this.solde += montant;
    }

    public void debiter(double montant) {
        this.solde -= montant;
    }

    public double getSolde() {
        return this.solde;
    }

    public int getNumero() {
        return this.numero;
    }

    public String toString() {
        return "********************\ncompte n: " + numero + "\ntitulaire : " + titulaire + "\nsolde : " + solde + " euro\n********************";
    }
}