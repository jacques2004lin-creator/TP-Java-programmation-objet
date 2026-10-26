public class exercice1 {

    public static int extraireChiffreUnite(int nombre) {
        int division = nombre / 10;
        int dizaines = division * 10;
        return nombre - dizaines;
    }

    public static int sommeChiffre(int nombre) {
        nombre = Math.abs(nombre);
        int somme = 0;

        while (nombre > 0) {
            somme += extraireChiffreUnite(nombre);
            nombre = nombre / 10;
        }

        return somme;
    }
    
    public static boolean multipledetrois(int nombre){
        int somme = Math.abs(nombre);

        while (somme >= 10) {
            somme = sommeChiffre(somme);
        }

        return somme == 3 || somme == 6 || somme == 9;
    }
    public static void main(String[] args) {
        int test1 = 978;
        int test2 = 14;

        System.out.println("Unité de " + test1 + " : " + extraireChiffreUnite(test1));
        System.out.println("Somme des chiffres de " + test1 + " : " + sommeChiffre(test1));
        System.out.println(test1 + " est multiple de 3 ? " + multipledetrois(test1));

        System.out.println("Somme des chiffres de " + test2 + " : " + sommeChiffre(test2));
        System.out.println(test2 + " est multiple de 3 ? " + multipledetrois(test2));
    }
}
