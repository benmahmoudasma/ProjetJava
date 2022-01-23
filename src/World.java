import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import static java.lang.Math.cos;
import static java.lang.Math.toRadians;

public class World {

    ArrayList<Aeroport> aeroportList;

    public ArrayList<Aeroport> getaeroportList() {
        return aeroportList;
    }

    public World(String filename) {


        try {
            aeroportList = new ArrayList<Aeroport>();
            BufferedReader buf = new BufferedReader(new FileReader(filename));
            String s = buf.readLine();
            while (s != null) {
                s = s.replaceAll("\"", "");
                String fields[] = s.split(",");
                if (fields[1].equals("large_airport")) {

                    aeroportList.add(new Aeroport(fields[9], fields[2], fields[5], Double.parseDouble(fields[12]), Double.parseDouble(fields[11])));
                }
                s = buf.readLine();
            }
        }
        catch(Exception e){
            System.out.println("Maybe the file isn't there ?");
            System.out.println(aeroportList.get(aeroportList.size() - 1));
            e.printStackTrace();
        }
    }

    public Double dist (Double lat1, Double lat2, Double long1, Double long2) {

        Double norme = Math.pow((lat2 - lat1),2) + Math.pow((long2 - long1)*cos(toRadians(lat2+lat1)/2), 2);
        return norme;
    }

    public Aeroport FindNearestAirport(double lon, double lat){
        double dist = dist(lon,lat,aeroportList.get(0).getLongitude(),aeroportList.get(0).getLatitude());
        Aeroport aeroport1 = null;
        for(Aeroport aeroport2 : aeroportList){
            double lat1 = aeroport2.getLatitude();
            double long1 = aeroport2.getLongitude();
            double dist2 = dist(lat,lat1, lon, long1);
            if(dist2 < dist){
                aeroport1 = aeroport2;
                dist = dist2;
            }
        }
        return aeroport1;
    }

    public Aeroport findByCode(String code){
        for(Aeroport aeroport : aeroportList){
            if(aeroport.getIATA().equals(code)){
                return aeroport;
            }
        }
        return null;
    }
}
