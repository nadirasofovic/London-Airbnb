public class Accomodation {

    private String id;
    private String name;
    private Integer host_id;
    private String host_name;
    private String neighbourhood;
    private Double latitude;
    private Double longitude;
    private String room_type;
    private Integer price;
    private Integer minimum_nights;

    public Accomodation(String id,String name,Integer host_id, String host_name,String neighbourhood, Double latitude,
                        Double longitude, String room_type, Integer price, Integer minimum_nights) {
        this.id = id;
        this.name = name;
        this.host_id = host_id;
        this.host_name = host_name;
        this.neighbourhood = neighbourhood;
        this.latitude = latitude;
        this.longitude = longitude;
        this.room_type = room_type;
        this.price = price;
        this.minimum_nights = minimum_nights;
  }
  public Accomodation() {

  }

  public String getRoomType() {
        return room_type;
  }

  public int getMinNights() {
        return minimum_nights;
    }

  public int getPrice() {
        return price;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public double getRadius(double latitude, double longitude) {
        double bigBenLatitude = 51.510357;
        double bigBenLongitude = -0.116773;
        double radius = Math.sqrt(Math.pow(bigBenLatitude - latitude, 2) + Math.pow(bigBenLongitude - longitude, 2));
        return (int) radius;
    }

  @Override
    public String toString() {
        return "Accomodation{id=" + id + ", name=" + name + ", hostId=" + host_id + ", hostName=" + host_name +
                ", neighbourhood=" + neighbourhood + ", latitude=" + latitude + ", longitude=" + longitude +
                ", roomType=" + room_type + ", price=" + price + ", minimumNights=" + minimum_nights + "}";
  }
}
