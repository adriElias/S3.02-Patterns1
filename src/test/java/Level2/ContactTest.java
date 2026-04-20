package Level2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    private Contact spainContact;
    private Contact usaContact;

    @BeforeEach
    public void setUp() {
        spainContact = new Contact(new SpainContactFactory(
            "Carrer Major 34", "Barcelona", "08001", "612345678"
        ));
        usaContact   = new Contact(new USAContactFactory(
            "154 5th Avenue", "New York", "NY 10001", "6123456789"
        ));
    }

    // ─── Contact toString test ───────────────────────────────

    @Test
    public void testSpainContactToString() {
        String result = spainContact.toString();
        assertTrue(result.contains("Address: Carrer Major 34, 08001 Barcelona"));
        assertTrue(result.contains("Phone: +34 612 34 56 78"));
    }

    @Test
    public void testUSAContactToString() {
        String result = usaContact.toString();
        assertTrue(result.contains("Address: 154 5th Avenue, New York, NY 10001"));
        assertTrue(result.contains("Phone: +1 (612) 345-6789"));
    }

    @Test
    public void testContactToStringFormat() {
        String result = spainContact.toString();
        assertTrue(result.contains("Address:"));
        assertTrue(result.contains("Phone:"));
        assertTrue(result.contains("|"));
    }

    @Test
    public void testContactToStringIsNotNull() {
        assertNotNull(spainContact.toString());
        assertNotNull(usaContact.toString());
    }

    // ─── Spain directions test ───────────────────────────────

    @Test
    public void testSpainAddressFormat() {
        String result = spainContact.getFormattedAddress(
                "Carrer Example", "Barcelona", "08001"
        );
        assertEquals("Carrer Example, 08001 Barcelona", result);
    }

    @Test
    public void testSpainAddressContainsPostalCodeBeforeCity() {
        String result = spainContact.getFormattedAddress(
                "Calle Mayor", "Madrid", "28001"
        );
        assertTrue(result.contains("28001 Madrid"));
    }

    @Test
    public void testSpainAddressNotNull() {
        String result = spainContact.getFormattedAddress(
                "Avinguda Diagonal", "Barcelona", "08013"
        );
        assertNotNull(result);
    }

    // ─── Spain phone test ────────────────────────────────

    @Test
    public void testSpainPhonePrefix() {
        assertEquals("+34", spainContact.getPhonePrefix());
    }

    @Test
    public void testSpainPhoneFormat() {
        String result = spainContact.getFormattedPhone("612345678");
        assertEquals("+34 612 34 56 78", result);
    }

    @Test
    public void testSpainPhoneStartsWithPrefix() {
        String result = spainContact.getFormattedPhone("699123456");
        assertTrue(result.startsWith("+34"));
    }

    // ─── USA directions test ──────────────────────────────────

    @Test
    public void testUSAAddressFormat() {
        String result = usaContact.getFormattedAddress(
                "Example Street", "New York", "10001"
        );
        assertEquals("Example Street, New York, 10001", result);
    }

    @Test
    public void testUSAAddressCityBeforePostalCode() {
        String result = usaContact.getFormattedAddress(
                "Main Street", "Los Angeles", "90001"
        );
        assertTrue(result.contains("Los Angeles, 90001"));
    }

    @Test
    public void testUSAAddressNotNull() {
        String result = usaContact.getFormattedAddress(
                "Broadway", "New York", "10002"
        );
        assertNotNull(result);
    }

    // ─── USA phone test ───────────────────────────────────

    @Test
    public void testUSAPhonePrefix() {
        assertEquals("+1", usaContact.getPhonePrefix());
    }

    @Test
    public void testUSAPhoneFormat() {
        String result = usaContact.getFormattedPhone("6123456789");
        assertEquals("+1 (612) 345-6789", result);
    }

    @Test
    public void testUSAPhoneStartsWithPrefix() {
        String result = usaContact.getFormattedPhone("8005551234");
        assertTrue(result.startsWith("+1"));
    }

    // ─── Cross-testing (the two countries do not mix)  ───────────

    @Test
    public void testPrefixesAreDifferent() {
        assertNotEquals(spainContact.getPhonePrefix(), usaContact.getPhonePrefix());
    }

    @Test
    public void testSpainAndUSAAddressFormatAreDifferent() {
        String spain = spainContact.getFormattedAddress("Calle Sol", "Sevilla", "41001");
        String usa   = usaContact.getFormattedAddress("Calle Sol", "Sevilla", "41001");
        // sameData, distinct format
        assertNotEquals(spain, usa);
    }
}
