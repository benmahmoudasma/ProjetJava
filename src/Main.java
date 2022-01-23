public class Main {

    public static void main(String[] args) {

       /* Aeroport Orly = new Aeroport ("ORY","ORLY", "France", 2.3690, 48.7280);
        System.out.println(Orly); */
        World w = new World("/airport-codes_no_comma.csv");
        System.out.println("Found "+w.getaeroportList().size()+" airports.");
        Aeroport paris = w.FindNearestAirport(2.316,48.866);
        Aeroport cdg = w.findByCode("CDG");
        double distance = w.dist(2.316,48.866,paris.getLongitude(),paris.getLatitude());
        System.out.println(paris);
        System.out.println(distance);
        double distanceCDG = w.dist(2.316,48.866,cdg.getLongitude(),cdg.getLatitude());
        System.out.println(cdg);
        System.out.println(distanceCDG);

    }
}

