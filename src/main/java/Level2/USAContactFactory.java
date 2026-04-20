package Level2;

public class USAContactFactory implements ContactFactory {
    private final String street;
    private final String city;
    private final String zipCode;
    private final String phone;

    public USAContactFactory(String street, String city, String zipCode, String phone) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.phone = phone;
    }

    @Override
    public Address createAddress() {
        return new USAAddress();
    }

    @Override
    public Phone createPhone() {
        return new USAPhone();
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String getPhone() {
        return phone;
    }
}
