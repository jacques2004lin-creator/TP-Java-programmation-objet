public class Securise extends Compte {
    public Securise(String titulaire, double soldeInitial) {
        super(titulaire, soldeInitial, "Securise");
    }

    @Override
    public void debiter(double montant) {
        if (this.getSolde() >= montant) {
            super.debiter(montant);
        } else {
            System.out.println("solde insuffisant sur le compte " + this.getNumero());
        }
    }
}