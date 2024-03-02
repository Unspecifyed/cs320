package contact;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContactTest {

    @Test
    public void testValidContact() {
        Contact contact = new Contact("1".repeat(10),"John", "Doe", "123 Main St", "1234567890");

        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("123 Main St", contact.getAddress());
        assertEquals("1234567890", contact.getPhone());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullFirstName() {
        new Contact("1".repeat(10), null, "Doe", "123 Main St", "1234567890");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullLastName() {
        new Contact("1".repeat(10),"John", null, "123 Main St", "1234567890");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPhone() {
        new Contact("1".repeat(10),"John", "Dull", "123 Main St", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullAddress() {
        new Contact("1".repeat(10),"John", "Dull", null, "1234567890");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameTooLong() {
        new Contact("1".repeat(10),"John".repeat(10), "Dull", "123 Main St", "1234567890");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastNameTooLong() {
        new Contact("1".repeat(10),"John", "Dull".repeat(10), "123 Main St", "1234567890");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneTooLong() {
        new Contact("1".repeat(10),"John", "Dull", "123 Main St", "1234567890".repeat(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhoneFormat() {
        new Contact("1".repeat(10),"John", "Dull", "123 Main St", "1asdfasdf890");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddressTooLong() {
        new Contact("1".repeat(10),"John", "Dull", "123 Main St".repeat(10), "1234567890");
    }
}

    
