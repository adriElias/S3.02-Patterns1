package Level2;

public class SpainAddress implements Address {
    @Override
    public String format(String street, String city, String zipCode) {
        return street + ", " + zipCode + " " + city;
    }
}
