package Level2;

public class App {
    public static void main(String[] args) {
        System.out.println("---- ABSTRACT FACTORY PATTERN ----");
        System.out.println();

        // Spain
        ContactFactory spainFactory = new SpainContactFactory(
            "Carrer Major 34", "Barcelona", "08001", "123456789"
        );
        Contact contactSpain = new Contact(spainFactory);
        System.out.println(contactSpain.toString());
        System.out.println();

        // USA
        ContactFactory usaFactory = new USAContactFactory(
            "154 5th Avenue", "New York", "NY 10001", "0987654321"
        );
        Contact contactUSA = new Contact(usaFactory);
        System.out.println(contactUSA.toString());
    }
}
