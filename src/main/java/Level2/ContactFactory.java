package Level2;

public interface ContactFactory {
    Address createAddress();

    Phone createPhone();

    String getStreet();

    String getCity();

    String getZipCode();

    String getPhone();
}
