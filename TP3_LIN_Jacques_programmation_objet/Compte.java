public class Compte{
int solde = 0;
void depot(int montant){
solde = solde + montant;
}
void retrait(int montant){
solde = solde - montant;
}
void virement(int montant, Compte autre){
autre.retrait(montant);
this.depot(montant);
}
void afficher(){
System.out.println("solde:␣"+ solde);
}
}
