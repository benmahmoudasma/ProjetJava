/* import java.util.ArrayList;


    public class World {

   ArrayList<aeroport> aeroportArrayList;

    }

    public class World (String fileName){
        aeroportArrayList = new ArrayList<aeroport>();

    }
        try{
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String s = buf.readLine();
            while(s!=null){
                s=s.replaceAll("\"","");
//Enleve les guillemets qui s´eparent les champs de donn´ees GPS.
                String fields[]=s.split(",");
// Une bonne id´ee : placer un point d'arr^et ici pour du debuggage.
                if (fields[1].equals("large_airport")){
// A continuer



                }
                s = buf.readLine();
            }
        }
        catch (Exception e){
            System.out.println("Maybe the file isn't there ?");
            System.out.println(list.get(list.size()-1));
            e.printStackTrace();
        } */