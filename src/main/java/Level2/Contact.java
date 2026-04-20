package Level2;

public class Contact {
    private final Address address;
    private final Phone phone;
    private final ContactFactory contactFactory;

    public Contact(ContactFactory contactFactory) {
        this.contactFactory = contactFactory;
        this.address = contactFactory.createAddress();
        this.phone = contactFactory.createPhone();
    }

    @Override
    public String toString() {
        String formattedAddress = address.format(
                contactFactory.getStreet(),
                contactFactory.getCity(),
                contactFactory.getZipCode()
        );

        String formattedPhone = phone.format(contactFactory.getPhone());

        return "Address: " + formattedAddress + " | Phone: " + formattedPhone;
    }

    public String getFormattedAddress(String street, String city, String zipCode) {
        return address.format(street, city, zipCode);
    }

    public String getFormattedPhone(String number) {
        return phone.format(number);
    }

    public String getPhonePrefix() {
        return phone.getPrefix();
    }
}
