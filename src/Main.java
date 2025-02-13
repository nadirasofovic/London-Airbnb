import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        ArrayList<Accomodation> accomodations = new ArrayList<>();
        Map<String, ArrayList<Accomodation>> roomType = new HashMap<>();
        File file = new File("input/airbnb.txt");

        try {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNext()) {
                String[] parts = scanner.nextLine().split("\t");

                if (parts.length == 10) {
                    String id = parts[0];
                    String name = parts[1];
                    Integer host_id = Integer.parseInt(parts[2]);
                    String host_name = parts[3];
                    String neighbourhood = parts[4];
                    Double latitude = Double.parseDouble(parts[5]);
                    Double longitude = Double.parseDouble(parts[6]);
                    String room_type = parts[7];
                    Integer price = Integer.parseInt(parts[8]);
                    Integer minimum_nights = Integer.parseInt(parts[9]);

                    Accomodation accomodation = new Accomodation(id,name,host_id,host_name,neighbourhood,latitude,
                            longitude,room_type,price,minimum_nights);

                    accomodations.add(accomodation);

                    if (roomType.containsKey(accomodation.getRoomType())) {
                        roomType.get(accomodation.getRoomType()).add(accomodation);
                    }
                    else {
                        roomType.put(accomodation.getRoomType(), new ArrayList<>());
                        roomType.get(accomodation.getRoomType()).add(accomodation);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("1. Cheapest shared room: ");
        for (String s: roomType.keySet()) {
            if (s.equals("Shared room")) {
                int minPrice = Integer.MAX_VALUE;
                Accomodation cheapestSharedRoom = new Accomodation();

                for (Accomodation accomodation : roomType.get(s)) {
                    if (accomodation.getMinNights() <= 7 && accomodation.getPrice() < minPrice) {
                        minPrice = accomodation.getPrice();
                        cheapestSharedRoom = accomodation;
                    }
                }
                System.out.println(cheapestSharedRoom);
            }
        }

        System.out.println("2. Most expensive private room in a radius of 10km from Big Ben");
        for (String s : roomType.keySet()) {
            if (s.equals("Private room")) {
                int maxPrice = Integer.MIN_VALUE;
                Accomodation mostExpRoom = new Accomodation();

                for (Accomodation accomodation : roomType.get(s)) {
                    if (accomodation.getRadius(accomodation.getLatitude(), accomodation.getLongitude()) < 10
                    && accomodation.getMinNights() <= 7 && accomodation.getPrice() > maxPrice) {
                        maxPrice = accomodation.getPrice();
                        mostExpRoom = accomodation;
                    }
                }
                System.out.println(mostExpRoom);
            }
        }

        System.out.println("3. Accommodation located in the middle of a list for all places that have London in " +
                "their name");
        ArrayList<Accomodation> accomodationsInLondon = new ArrayList<>();

        for (Accomodation accomodation : accomodations) {
            if (accomodation.getName().toLowerCase().contains("london") && accomodation.getMinNights() <= 7)
                accomodationsInLondon.add(accomodation);
        }

        boolean evenNumber = accomodationsInLondon.size() % 2 == 0;
        int middle = (int) Math.ceil(accomodationsInLondon.size()/2.);

        System.out.println(accomodationsInLondon.get(middle));

        if (evenNumber) {
            System.out.println(accomodationsInLondon.get(middle + 1));
        }
    }
}