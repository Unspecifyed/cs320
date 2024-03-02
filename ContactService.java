package contact;
import java.util.TreeMap;
import java.util.Scanner;
import java.io.InputStream;
public class ContactService {
    private TreeMap<String, Contact> contacts; // I get a warning to implemnt a inteface but that would make another file not part of the assigment
    private InputStream S = new ByteArrayInputStream("Cus You told me this borke your stuff".getBytes());
    private Scanner scanner = new Scanner(S); 
    public ContactService(){
        contacts = new TreeMap<>();
    }
    public ContactService(InputStream inputStream){
        contacts = new TreeMap<>();
        this.scanner = new Scanner(inputStream);
    }
    private void checkNullString(String input){
        if(input == null){
            throw new IllegalArgumentException("Input cannot be null.");
        }
    }
    private void checkLargeString(String input){
        if(input.length() > 10){
            throw new IllegalArgumentException("Input cannot be longer than 10 characters.");
        }
    }
    private void checkUniqueID(String input){
        if(contacts.containsKey(input)){
            throw new IllegalArgumentException("Input must be unique.");
        }
    }
    public void addContact(){
        System.out.println("Enter the contact ID: ");
        String contactID = scanner.nextLine();
        checkNullString(contactID);
        checkLargeString(contactID);
        checkUniqueID(contactID);
        System.out.println("Enter the first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String phone = scanner.nextLine();
        Contact contact = new Contact( contactID,firstName, lastName, address, phone);
        contacts.put(contactID, contact);
        System.out.println("Contact added successfully.");
    }
    public boolean addContact(String contactID, String firstName, String lastName, String address, String phone){
        if(hasContact(contactID)) return false;
        Contact contact = new Contact( contactID,firstName, lastName, address, phone);
        contacts.put(contactID, contact);
        System.out.println("Contact added successfully.");
        return true;
    }
    public boolean hasContact(String contactID){
        checkNullString(contactID);
        if(!contacts.containsKey(contactID)){
            System.out.println("contactID not found.");
            return false;
        }
        System.out.println("Contact found.");
        return true;
    }
    public void deleteContact(){
        String contactID = enterID();
        contacts.remove(contactID);
        System.out.println("Contact removed successfully.");
    }
    public boolean deleteContact(String contactID){
        Contact c = contacts.remove(contactID);
        if(c!=null){
            System.out.println("Contact removed successfully.");
            return true;
        }
        System.out.println("Contact not found.");
        return false;
    }
    private void validUpdateID(String contactID){
        checkNullString(contactID);
        hasContact(contactID);
    }
    private String enterID(){
        System.out.println("Enter the contact ID: ");
        String contactID = scanner.nextLine();
        validUpdateID(contactID);
        hasContact(contactID);
        return contactID;
    }
    public void updateFirstName(){
        String contactID = enterID();
        System.out.println("Enter the new first name: ");
        String firstName = scanner.nextLine();
        contacts.get(contactID).setFirstName(firstName);
    }
    public boolean updateFirstName(String contactID, String firstName){
        Contatc c = contacts.get(contactID);
        if(c == null) return false;
        c.setFirstName(firstName);
        return true;
    }
    public void updateLastName(){
        String contactID = enterID();
        System.out.println("Enter the new last name: ");
        String lastName = scanner.nextLine();
        contacts.get(contactID).setLastName(lastName);
    }
    public boolean updateLastName(String contactID, String lastName){
        Contatc c = contacts.get(contactID);
        if(c == null) return false;
        c.setLastName(lastName);
        return true;
    }
    public void updatePhone(){
        String contactID = enterID();
        System.out.println("Enter the new phone number: ");
        String phone = scanner.nextLine();
        contacts.get(contactID).setPhone(phone);
    }
    public boolean updateAddress(String contactID, String address){
        Contatc c = contacts.get(contactID);
        if(c == null) return false;
        c.setAddress(address);
    }
    public void updateAddress(){
        String contactID = enterID();
        System.out.println("Enter the new address: ");
        String address = scanner.nextLine();
        contacts.get(contactID).setAddress(address);
    }
    public boolean updatePhone(String contactID, String phone){
        Contact c = contacts.get(contactID);
        if(c == null) return false;
        c.setPhone(phone);
        return true;
    }
    public Contact getContact(String contactID){
        checkNullString(contactID);
        if(!contacts.containsKey(contactID)){
            throw new IllegalArgumentException("Contact not found.");
        }
        return contacts.get(contactID);
    }
    public static void main(String[] args){
        ContactService contactService = new ContactService();
        contactService.menuLoop();
        
    }
    private void menuLoop(){
        String commandString;
        while(true){
            System.out.println("Enter a command: ");
            System.out.println("1. Add contact");
            System.out.println("2. Delete contact");
            System.out.println("3. Update first name");
            System.out.println("4. Update last name");
            System.out.println("5. Update phone");
            System.out.println("6. Update address");
            System.out.println("7. Exit");
            commandString = scanner.nextLine();
            int commandInt = Integer.parseInt(commandString);
           switch (commandInt) {
            case 1:
                addContact();
                break;
            case 2:
                deleteContact();
                break;
            case 3:
                updateFirstName();
                break;
            case 4:
                updateLastName();
                break;
            case 5:
                updatePhone();
                break;
            case 6:
                updateAddress();
                break;
            case 7:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                break;
           } 
        }
        
    }
}