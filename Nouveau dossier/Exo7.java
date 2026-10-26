public class Exo7 {
        public static void main (String[]argv){
        int age = Integer.parseInt (argv[0]);
        if (age <= 26){
                System.out.println ( "tarif reduit");
        }
        else {
                System.out.println ( "tarif normal");
        }
        System.out.println ((age <= 26) ? "tarif reduit" : "tarif normal");

        }
}