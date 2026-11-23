
public class Pion
{
    private int mvt = 1;//amplitude mouvement horizontal et vertical autorisé pour un déplacement
    private int mvtPrise = 2;//amplitude mouvement horizontal et vertical autorisé pour une prise

    private CouleurPion couleur;//blanc, noir

    public Pion(CouleurPion couleur){
	this.couleur = couleur;
    }
    
    public int getMvt() {
	return mvt;
    }
    public int getMvtPrise() {
	return mvtPrise;
    }

    public CouleurPion getCouleur() {
        return couleur;
    }

    public String toString(){
        return "Pion " + this.couleur;
    }

}
