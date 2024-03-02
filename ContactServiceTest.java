package contact;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.*;
import java.util.Scanner;

public class ContactServiceTest {
    String contactID = "1234567890\n";
    String firstName = "John\n";
    String lastName = "Doe\n";
    String address = "123 Main St\n";
    String phone = "123-555-1234\n";
    String contact = contactID + firstName + lastName + address + phone;
 
    /**
     * Sets up the test environment before each test method is executed.
     *
     * @param  none    No parameters
     * @return         No return value
     */
    @Before
    public void setUp() {
    }
    @Test
    public void testAddContact() {
        InputStream inputStream = new ByteArrayInputStream(contact.getBytes());
        ContactService contactService = new ContactService(inputStream);
        contactService.addContact();
        assertTrue(contactService.hasContact("1234567890"));
    }
    @Test
    public void testDeleteContact() {
        InputStream inputStream = new ByteArrayInputStream(contact.concat(contactID).getBytes());
        ContactService contactService = new ContactService(inputStream);
        contactService.addContact();
        contactService.deleteContact();
        assertFalse(contactService.hasContact("1234567890"));
    }
    @Test
    public void testUpdateFirstName() { 
        InputStream inputStream = new ByteArrayInputStream(contact.concat(contactID.concat("SPLEEN\n"
        )).getBytes());
        ContactService contactService = new ContactService(inputStream);
        contactService.addContact();
        contactService.updateFirstName();
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("SPLEEN", updatedContact.getFirstName());
    }
    @Test
    public void testUpdateLastName() {
        InputStream inputStream = new ByteArrayInputStream(contact.concat(contactID.concat("SPLEEN\n"
        )).getBytes());
        ContactService contactService = new ContactService(inputStream);
        contactService.addContact();
        contactService.updateLastName();
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("SPLEEN", updatedContact.getLastName());
    }
    @Test
    public void testUpdatePhone() {
        InputStream inputStream = new ByteArrayInputStream(contact.concat(contactID.concat("1114567890\n"
        )).getBytes());
        ContactService contactService = new ContactService(inputStream);
        contactService.addContact();
        contactService.updatePhone();
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("1114567890", updatedContact.getPhone());
    }
    @Test
    public void testUpdateAddress() {
        InputStream inputStream = new ByteArrayInputStream(contact.concat(contactID.concat("1114567890\n"
        )).getBytes());
        ContactService contactService = new ContactService(inputStream);
        contactService.addContact();
        contactService.updateAddress();
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("1114567890", updatedContact.getAddress());
    }
 
}
