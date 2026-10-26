public class Agence {
    private String nom;
    private Compte[] comptes;
    private int nbComptes;

    public Agence(String nom, int capacite) {
        this.nom = nom;
        this.comptes = new Compte[capacite];
        this.nbComptes = 0;
    }

    public void ajouter(Compte c) {
        if (nbComptes < comptes.length) {
            comptes[nbComptes] = c;
            nbComptes++;
        }
    }

    public Compte extraire(int numero) {
        for (int i = 0; i < nbComptes; i++) {
            if (comptes[i].getNumero() == numero) {
                return comptes[i];
            }
        }
        return null;
    }

    public void supprimer(int numero) {
        for (int i = 0; i < nbComptes; i++) {
            if (comptes[i].getNumero() == numero) {
                for (int j = i; j < nbComptes - 1; j++) {
                    comptes[j] = comptes[j + 1];
                }
                comptes[nbComptes - 1] = null;
                nbComptes--;
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Agence : " + nom + "\n");
        for (int i = 0; i < nbComptes; i++) {
            sb.append(comptes[i].toString()).append("\n");
        }
        return sb.toString();
    }
}