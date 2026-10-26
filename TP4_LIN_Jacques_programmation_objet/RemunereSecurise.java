public class RemunereSecurise extends Remunere {
    public RemunereSecurise(String titulaire, double soldeInitial, int taux) {
        super(titulaire, soldeInitial, taux);
    }

    public void debiter(double montant) {
        if (this.getSolde() >= montant) {
            super.debiter(montant);
        } else {
            System.out.println("solde insuffisant sur le compte " + this.getNumero());
        }
    }
}