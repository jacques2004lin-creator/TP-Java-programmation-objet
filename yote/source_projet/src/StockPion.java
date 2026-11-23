import javax.swing.*;
import java.awt.*;

public class StockPion extends JPanel {
    private Case[][] monStockPion;
    private CouleurPion couleur;

    public StockPion(CouleurPion couleur) {
	this.couleur = couleur;
        this.monStockPion = new Case[6][2];

        // Grille de 6 lignes par 2 colonnes avec un leger espacement pour distinguer les cases
        this.setLayout(new GridLayout(6, 2, 2, 2));
        this.setBackground(Color.GRAY);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                this.monStockPion[i][j] = new Case(Color.BLACK, i, j, 1);
                this.monStockPion[i][j].setBorder(Yote.empty);
                this.add(this.monStockPion[i][j]);
            }
        }
// Remplit le stock avec les 12 pions de depart
        this.reinitialiser();
    }
    
    public void reinitialiser() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                this.monStockPion[i][j].setPion(new Pion(this.couleur));
                this.monStockPion[i][j].setBorder(Yote.empty);
            }
        }
    }
}