import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static java.lang.Math.*;

public class World {

    ArrayList<Aeroport> aeroportArrayList;

    aeroportArrayList = new ArrayList<Aeroport>();

    public ArrayList<Aeroport> getAeroportArrayList() {

        return aeroportArrayList;
    }

    public World (String fileName){


        try {

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
    public Double distance(Double longitude1, Double latitude1, Double longitude2, Double latitude2){
        double norme = pow(latitude2 - latitude1, 2) + pow((longitude2 - longitude1) * cos(toRadians((latitude2 + latitude1) / 2)), 2);
        return norme;
    }

    public Aeroport findNearestAirport(double longitude, double latitude){
        double dist = distance (longitude,latitude,aeroportArrayList.get(0).getLongitude(),aeroportArrayList.get(0).getLatitude());
        Aeroport aeroport1 = null;
        for(Aeroport aeroport2 : aeroportArrayList){
            double latitude1 = aeroport2.getLatitude();
            double longitude1 = aeroport2.getLongitude();
            double distance2 = distance(longitude,latitude,longitude1, latitude1);
            if(distance2 < distance){
                aeroport1 = aeroport2;
                distance = distance2;
            }
        }
        return b;
    }


}


