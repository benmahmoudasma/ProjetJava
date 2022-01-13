public class Aeroport {


    private String IATA;
    private String name;
    private String country;
    private Double latitude;
    private Double longitude;


    public Aeroport(String IATA, String name, String country, Double latitude, Double longitude) {
        this.IATA = IATA;
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getIATA() {
        return IATA;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString () {
        return ("L'Aeroport " + name + " \n = " + "Le IATA est " + IATA + " \n = " + "Le nom est " + name + " \n = " + "Le pays est " + country + " \n = " + "La latitude est de " + latitude + " \n = " + "La longitude est de "+ longitude);
    }

}



