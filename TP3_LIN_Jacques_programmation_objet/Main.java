import java.util.Scanner;

class Morceau {
    public static final String GENRE1 = "JAZZ";
    public static final String GENRE2 = "REGGAE";
    public static final String GENRE3 = "METAL";
    public static final String GENRE4 = "SKA";

    private String titre;
    private String auteur;
    private int duree;
    private String genre;

    public Morceau(String titre, String auteur, int duree) {
        this.titre = titre;
        this.auteur = auteur;
        this.duree = duree;
        this.genre = null;
    }

    public Morceau(String titre, String auteur, int duree, String genre) {
        this.titre = titre;
        this.auteur = auteur;
        this.duree = duree;
        this.setGenre(genre);
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getDuree() {
        return this.duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        if (GENRE1.equalsIgnoreCase(genre)) {
            this.genre = GENRE1;
        } else if (GENRE2.equalsIgnoreCase(genre)) {
            this.genre = GENRE2;
        } else if (GENRE3.equalsIgnoreCase(genre)) {
            this.genre = GENRE3;
        } else if (GENRE4.equalsIgnoreCase(genre)) {
            this.genre = GENRE4;
        } else {
            System.out.println(" Genre « " + genre + " » choix possibles : "
                    + GENRE1 + ", " + GENRE2 + ", " + GENRE3 + ", " + GENRE4 + ".");
        }
    }

    @Override
    public String toString() {
        return "« " + this.titre + " » de " + this.auteur + " (" + this.duree + " s, Genre : "
                + (this.genre != null ? this.genre : "Non défini") + ")";
    }
}

class PlayList {
    private static int compteurPlayList = 0;

    private Morceau[] liste;
    private int taille;

    public PlayList(int capaciteMax) {
        if (capaciteMax <= 0) {
            throw new IllegalArgumentException("la capacité maximale doit être positive.");
        }
        this.liste = new Morceau[capaciteMax];
        this.taille = 0;
        compteurPlayList++;
    }

    public static int getCompteurPlayList() {
        return compteurPlayList;
    }

    public int getTaille() {
        return this.taille;
    }

    public Morceau getMorceau(int i) {
        if (i < 0 || i >= this.taille) {
            throw new IndexOutOfBoundsException("Indice invalide : " + i);
        }
        return this.liste[i];
    }

    public void ajouter(Morceau m) {
        if (this.taille >= this.liste.length) {
            System.out.println("playList saturée (" + this.liste.length + " max).");
            return;
        }
        this.liste[this.taille] = m;
        this.taille++;
        System.out.println(" morceau ajouté : " + m.getTitre());
    }

    public void supprimer(Morceau m) {
        int index = -1;
        for (int i = 0; i < this.taille; i++) {
            if (this.liste[i] != null && this.liste[i].getTitre().equalsIgnoreCase(m.getTitre())) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println(" morceau introuvable : " + m.getTitre());
            return;
        }

        for (int i = index; i < this.taille - 1; i++) {
            this.liste[i] = this.liste[i + 1];
        }

        this.liste[this.taille - 1] = null;
        this.taille--;
        System.out.println(" morceau « " + m.getTitre() + " » supprimé.");
    }

    public void afficher() {
        System.out.println("\n contenu de la playList (" + this.taille + "/" + this.liste.length + ") ---");
        if (this.taille == 0) {
            System.out.println("(aucun morceau)");
        } else {
            for (int i = 0; i < this.taille; i++) {
                System.out.println((i + 1) + ". " + this.liste[i]);
            }
        }
    }
}

class JukeBox {
    private PlayList listeCourante;
    private int indexLecture;

    public JukeBox() {
        this.listeCourante = null;
        this.indexLecture = 0;
    }

    public void ouvrir(PlayList playlist) {
        this.listeCourante = playlist;
        this.indexLecture = 0;
    }

    public void lire(Morceau m) {
        if (m != null) {
            System.out.println("Lecture : " + m.getTitre());
        }
    }

    public void jouer() {
        if (this.listeCourante == null || this.listeCourante.getTaille() == 0) {
            System.out.println("[jukeBox] playList vide.");
            return;
        }

        if (this.indexLecture >= this.listeCourante.getTaille()) {
            this.indexLecture = 0;
        }

        Morceau courant = this.listeCourante.getMorceau(this.indexLecture);
        lire(courant);

        this.indexLecture = (this.indexLecture + 1) % this.listeCourante.getTaille();
    }

    public void jouerEnContinu() {
        if (this.listeCourante == null || this.listeCourante.getTaille() == 0) {
            System.out.println("[jukeBox] playList vide.");
            return;
        }

        for (int i = this.indexLecture; i < this.listeCourante.getTaille(); i++) {
            lire(this.listeCourante.getMorceau(i));
        }

        this.indexLecture = 0;
    }

    public void next() {
        if (this.listeCourante == null || this.listeCourante.getTaille() == 0) {
            System.out.println("[jukeBox] playList vide ou absente.");
            return;
        }

        this.indexLecture = (this.indexLecture + 1) % this.listeCourante.getTaille();
        lire(this.listeCourante.getMorceau(this.indexLecture));
    }

    public void pause() {
        System.out.println("pause");
    }

    public void stop() {
        this.indexLecture = 0;
        System.out.println("[jukeBox] lecture arrêtée (index remis à 0).");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("capacité maximale de la playList : ");
        int capacite = scanner.nextInt();
        scanner.nextLine();

        PlayList maPlaylist = new PlayList(capacite);
        JukeBox jukeBox = new JukeBox();
        jukeBox.ouvrir(maPlaylist);

        boolean continuer = true;

        while (continuer) {
            System.out.println("\n menu jukeBox");
            System.out.println("1. ajouter un morceau");
            System.out.println("2. supprimer un morceau par son titre");
            System.out.println("3. jouer");
            System.out.println("4. next");
            System.out.println("5. jouer en continu");
            System.out.println("6. pause");
            System.out.println("7. stop");
            System.out.println("8. afficher la playlist");
            System.out.println("9. afficher le nombre d'instances de playList");
            System.out.println("0. quitter");
            System.out.print("ton choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Titre : ");
                    String titre = scanner.nextLine();

                    System.out.print("Auteur : ");
                    String auteur = scanner.nextLine();

                    System.out.print("Durée (en secondes) : ");
                    int duree = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Genre (JAZZ, REGGAE, METAL, SKA) : ");
                    String genre = scanner.nextLine();

                    Morceau m = new Morceau(titre, auteur, duree, genre);
                    maPlaylist.ajouter(m);
                    break;

                case 2:
                    System.out.print("Titre du morceau à retirer : ");
                    String titreASupprimer = scanner.nextLine();
                    maPlaylist.supprimer(new Morceau(titreASupprimer, "", 0));
                    break;

                case 3:
                    jukeBox.jouer();
                    break;

                case 4:
                    jukeBox.next();
                    break;

                case 5:
                    jukeBox.jouerEnContinu();
                    break;

                case 6:
                    jukeBox.pause();
                    break;

                case 7:
                    jukeBox.stop();
                    break;

                case 8:
                    maPlaylist.afficher();
                    break;

                case 9:
                    System.out.println("nombre total de PlayLists créées : " + PlayList.getCompteurPlayList());
                    break;

                case 0:
                    continuer = false;
                    System.out.println("fermeture du JukeBox");
                    break;

                default:
                    System.out.println("pas d'option");
            }
        }

        scanner.close();
    }
}