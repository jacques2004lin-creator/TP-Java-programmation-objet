import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.String.valueOf;

public class Case extends JButton implements ActionListener {

    private int typeCase;  // si typeCase == 0, case du plateau, si typeCase == 1 case du stock

    private ImageIcon imagePion;
    private Pion pion;
    private Color couleurFond;

    private boolean occupe;
    private int abscisse;
    private int ordonnee;

    public Case(Color couleur, int abs, int ord, int typeCase) {
        this.couleurFond = couleur;
        this.abscisse = abs;
        this.ordonnee = ord;
        this.typeCase = typeCase;

        this.pion = null;
        this.occupe = false;
        this.imagePion = null;

        this.setBackground(couleur);
        if (typeCase == 0) {
            this.setPreferredSize(new Dimension(100, 100));
        } else {
            this.setPreferredSize(new Dimension(50, 50));
        }

        addActionListener(this);
    }

    public Pion getPion() {
        return this.pion;
    }

    public void setPion(Pion p) {
        this.pion = p;
        if (p == null) {
            this.occupe = false;
            this.imagePion = null;
            this.setIcon(null);
            this.setText("");
        } else {
            this.occupe = true;
            String chemin = (p.getCouleur() == CouleurPion.blanc)
                    ? "../Icones/zebre.png"
                    : "../Icones/guepard.png";

            this.imagePion = new ImageIcon(chemin);

            // Si tu lances le programme depuis la racine du projet (ex. dans VS Code)
            // et non depuis un sous-dossier src/, on teste aussi sans "../"
            if (this.imagePion.getIconWidth() <= 0) {
                String cheminRacine = (p.getCouleur() == CouleurPion.blanc)
                        ? "Icones/zebre.png"
                        : "Icones/guepard.png";
                this.imagePion = new ImageIcon(cheminRacine);
            }

            if (this.imagePion.getIconWidth() > 0) {
                this.setIcon(this.imagePion);
                this.setText("");
            } else {
                // Texte de secours uniquement si le fichier image est introuvable
                this.setIcon(null);
                this.setText(p.getCouleur() == CouleurPion.blanc ? "B" : "N");
            }
        }
    }

    public int getAbscisse() {
        return this.abscisse;
    }

    public int getTypeCase() {
        return this.typeCase;
    }

    public int getOrdonnee() {
        return this.ordonnee;
    }

    public boolean isOccupe() {
        return this.occupe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Yote.etat == 0) {
            // Desactiver le bouton annuler au debut d'un tour
            Fenetre.boutonAnnuler.setEnabled(false);

            // Selection de la case de depart
            Yote.caseDep = ((Case) e.getSource());

            if (Yote.caseDep.isOccupe()) {
                if (Yote.caseDep.getPion().getCouleur() == Yote.joueur) {
                    // Case valide : occupee par un pion du joueur courant
                    Yote.caseDep.setBorder(Yote.redline);
                    Yote.etat = 1;
                }
            }
        } else {
            if (Yote.etat == 1) {
                // Identification de la case possible d'arrivee
                Yote.caseArr = ((Case) e.getSource());

                if (Yote.unPlateau.isIn(Yote.caseArr)) {
                    // Si le pion vient du stock (parachutage sur une case libre du plateau)
                    if (Yote.caseDep.getTypeCase() == 1) {
                        if (!Yote.caseArr.isOccupe()) {
                            Yote.unPlateau.jouerCoup(Yote.caseDep, Yote.caseArr);
                        } else {
                            if (Yote.caseArr.getPion().getCouleur() == Yote.joueur) {
                                Yote.caseDep.setBorder(Yote.empty);
                                Yote.caseArr.setBorder(Yote.redline);
                                Yote.caseDep = Yote.caseArr;
                                Yote.etat = 1;
                            }
                        }
                    } else {
                        // Le pion vient deja du plateau
                        if (Yote.unPlateau.coupValide(Yote.caseDep, Yote.caseArr) == 1) {
                            Yote.unPlateau.jouerCoup(Yote.caseDep, Yote.caseArr);
                        } else {
                            if (Yote.unPlateau.coupValide(Yote.caseDep, Yote.caseArr) == 2) {
                                Yote.unPlateau.jouerCoupPrise(Yote.caseDep, Yote.caseArr);
                                Yote.scoreBlanc.setText("Score Joueur Blanc \n " + valueOf(Yote.nbPionBlanc));
                                Yote.scoreNoir.setText("Score Joueur Noir \n" + valueOf(Yote.nbPionNoir));
                            } else {
                                if (Yote.unPlateau.coupValide(Yote.caseDep, Yote.caseArr) == 0
                                        && Yote.caseArr.isOccupe()
                                        && Yote.caseArr.getPion().getCouleur() == Yote.caseDep.getPion().getCouleur()) {
                                    // Changement de pion de depart (meme couleur)
                                    Yote.caseDep.setBorder(Yote.empty);
                                    Yote.caseArr.setBorder(Yote.redline);
                                    Yote.caseDep = Yote.caseArr;
                                    Yote.etat = 1;
                                }
                            }
                        }
                    }
                } else {
                    // La case d'arrivee selectionnee n'est pas dans le plateau (clic dans le stock)
                    if (Yote.caseArr.isOccupe()) {
                        if (Yote.caseArr.getPion().getCouleur() == Yote.caseDep.getPion().getCouleur()) {
                            Yote.caseDep.setBorder(Yote.empty);
                            Yote.caseArr.setBorder(Yote.redline);
                            Yote.caseDep = Yote.caseArr;
                            Yote.etat = 1;
                        }
                    }
                }
            } else {
                if (Yote.etat == 2) {
                    // Choix du deuxieme pion adverse a prendre
                    boolean finPartie = false;
                    Yote.casePrise = ((Case) e.getSource());
                    CouleurPion couleurSuiv = CouleurPion.blanc;
                    if (Yote.joueur == CouleurPion.blanc) {
                        couleurSuiv = CouleurPion.noir;
                    }

                    // Si sur la case cliquee la piece est de la couleur adverse
                    if (Yote.casePrise.isOccupe() && Yote.casePrise.getPion().getCouleur() == couleurSuiv) {
                        Yote.casePrise.setPion(null);
                        if (Yote.joueur == CouleurPion.blanc) {
                            Yote.nbPionNoir--;
                            if (Yote.nbPionNoir == 0) {
                                finPartie = true;
                            }
                        } else {
                            Yote.nbPionBlanc--;
                            if (Yote.nbPionBlanc == 0) {
                                finPartie = true;
                            }
                        }

                        if (finPartie) {
                            String[] lesTextes = {"Recommencer", "Fermer le jeu"};
                            int retour = JOptionPane.showOptionDialog(
                                    this,
                                    "Partie terminée. Le joueur " + couleurSuiv + " a perdu !",
                                    "Fin de jeu",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,
                                    new ImageIcon(),
                                    lesTextes,
                                    lesTextes[0]
                            );
                            if (retour == 0) {
                                Yote.unPlateau.reinitialiser();
                            } else {
                                Yote.fenetrePrincipale.dispose();
                            }
                        }

                        Yote.scoreBlanc.setText("Score Joueur Blanc \n " + valueOf(Yote.nbPionBlanc));
                        Yote.scoreNoir.setText("Score Joueur Noir \n" + valueOf(Yote.nbPionNoir));

                        Yote.fenetrePrincipale.repaint();
                        Yote.fenetrePrincipale.validate();

                        Fenetre.boutonAnnuler.setEnabled(true);

                        Yote.joueur = couleurSuiv;
                        // On retourne dans l'etat 0
                        Yote.etat = 0;
                    }
                }
            }
        }
    }

    public String toString() {
        return "Case (" + abscisse + ", " + ordonnee + ") - type: " + typeCase
                + (occupe ? " - " + pion.toString() : " - vide");
    }
}