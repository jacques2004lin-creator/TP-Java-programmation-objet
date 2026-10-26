public class Exo1 {
    public static double notefinale(double exam, double partiel) {
    
    if (exam < 7)
        return exam;
    else {
        double moy = (exam + partiel) / 2;
        if (moy > exam){
            return moy;
        } 
        else {
        return exam; 
        }
    }


}
    public static void main(String[] argv) {
        double a = notefinale( Double.parseDouble(argv[0]), Double.parseDouble (argv [1]));
        System.out.println("La note finale est : " + a);
    }
}
