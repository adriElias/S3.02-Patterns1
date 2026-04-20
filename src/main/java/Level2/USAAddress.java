package Level2;

public class USAAddress implements Address {
    @Override
    public String format(String street, String city, String zipCode) {
        return street + ", " + city + ", " + zipCode;
    }
}
