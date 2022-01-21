/*import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static java.lang.Math.*;

public class World {

    ArrayList<Aeroport> aeroportArrayList;

    public ArrayList<Aeroport> getAeroportArrayList() {

        return aeroportArrayList;
    }

    public World (String fileName){


        try {
            aeroportArrayList = new ArrayList<Aeroport>();
            System.out.println("Test1");
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String s = buf.readLine();


            while(s!=null) {

                s = s.replaceAll("\"", "");

                String fields[] = s.split(",");

                if (fields[1].equals("large_airport")) {
                    Aeroport aeroport;
                    aeroportArrayList.add( aeroport = new Aeroport(fields[9], fields[2], fields[5],
                            Double.parseDouble(fields[10]), Double.parseDouble(fields[11])));

                }

                s = buf.readLine();

            }
        }
        catch (Exception e){
            System.out.println("Maybe the file isn't there ?");
            System.out.println(aeroportArrayList.get(aeroportArrayList.size()-1));
            e.printStackTrace();
        }

    }

    public Aeroport findByCode(String code){
        for(Aeroport aero : aeroportArrayList){
            if(aero.getIATA().equals(code)){
                return aero;
            }
        }
        System.out.println("Le code IATA ne correspond à aucun aeroport");
        return null;
    }

    public Double distance(Double longitude1, Double latitude1, Double longitude2, Double latitude2){
        Double norme = pow(latitude2 - latitude1, 2) + pow((longitude2 - longitude1) * cos(toRadians((latitude2 + latitude1) / 2)), 2);
        return norme;
        }

    public Aeroport findNearestAirport(Double longitude, Double latitude){
        Double distance = distance (longitude,latitude,aeroportArrayList.get(0).getLongitude(),aeroportArrayList.get(0).getLatitude());
        Aeroport aeroport1 = null;
        for(Aeroport aeroport2 : aeroportArrayList){
            Double latitude1 = aeroport2.getLatitude();
            Double longitude1 = aeroport2.getLongitude();
            Double distance2 = distance(longitude,latitude,longitude1, latitude1);
            if(distance2 < distance){
                aeroport1 = aeroport2;
                distance = distance2;
            }
        }
        return aeroport1;
    }


}

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import static java.lang.Math.cos;
import static java.lang.Math.toRadians;

public class World {

    ArrayList<Aeroport> aeroportArrayList;

    public ArrayList<Aeroport> getAeroportArrayList() {
        return aeroportArrayList;
    }

    public World(String fileName) {


        try {
            aeroportArrayList = new ArrayList<Aeroport>();
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String s = buf.readLine();
            while (s != null) {
                s = s.replaceAll("\"", "");
                String fields[] = s.split(",");
                if (fields[1].equals("large_airport")) {

                    aeroportArrayList.add(new Aeroport(fields[9], fields[2], fields[5], Double.parseDouble(fields[12]), Double.parseDouble(fields[11])));
                }
                s = buf.readLine();
            }
        }
        catch(Exception e){
            System.out.println("Maybe the file isn't there ?");
            System.out.println(aeroportArrayList.get(aeroportArrayList.size() - 1));
            e.printStackTrace();
        }
    }

    public Double Distance (Double latitude1, Double latitude2, Double longitude1, Double longitude2) {

        Double norme = Math.pow((latitude2 - latitude1),2) + Math.pow((longitude2 - longitude1)*cos(toRadians(latitude2+latitude1)/2), 2);
        return norme;
    }

    public Aeroport FindNearestAirport(double lon, double lat){
        double distance = Distance(lon,lat,aeroportArrayList.get(0).getLongitude(),aeroportArrayList.get(0).getLatitude());
        Aeroport aeroport1 = null;
        for(Aeroport aeroport2 : aeroportArrayList){
            double latitude1 = aeroport2.getLatitude();
            double longitude1 = aeroport2.getLongitude();
            double distance2 = Distance(lat,latitude1, lon, longitude1);
            if(distance2 < distance){
                aeroport1 = aeroport2;
                distance = distance2;
            }
        }
        return aeroport1;
    }

    public Aeroport findByCode(String code){
        for(Aeroport aeroport : aeroportArrayList){
            if(aeroport.getIATA().equals(code)){
                return aeroport;
            }
        }
        return null;
    }
}


