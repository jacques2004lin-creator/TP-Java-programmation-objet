public class animaldecompagnie {
    private String nom;
    private int age;

    public animaldecompagnie(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public void affichage() {
        System.out.println("l'annimal s'appelle " + this.nom + " et il a " + this.age + " ans.");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        animaldecompagnie a = new animaldecompagnie("bill", 3);
        a.affichage();
    }
}