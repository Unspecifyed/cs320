package contact;
public class Contact {
   private String firstName;
   private String lastName;
   private String address;
   private String phone;
   private String contactID;

    public Contact( String contactID, String firstName, String lastName, String address, String phone){
       setFirstName(firstName);
       setLastName(lastName);
       setAddress(address);
       setPhone(phone);
       setContactID(contactID);
   }
   

   public  String getFirstName() {
       return firstName;
   }
   public String getLastName() {
       return lastName;
   }
   public String getAddress() {
       return address;
   }
   public String getPhone() {
       return phone;
   }
   public String getContactID() {
       return contactID;
   }
   private static void checkNotNull(String input){
    if(input == null){
        throw new IllegalArgumentException("Input cannot be null.");
    }
   }
   private static void checkNotTooBig(String input, int length){
       if(input.length() > length){
        throw new IllegalArgumentException("Input cannot be longer than " + length + " characters.");
       }
   }
   private String cleanPhoneNumber(String input){
       return input.replaceAll("[^0-9]", "");
   }
   public void setFirstName(String firstName){
       checkNotNull(firstName);
       checkNotTooBig(firstName, 10);
       this.firstName = firstName;
   }
   public void setLastName(String lastName){
       checkNotNull(lastName);
       checkNotTooBig(lastName, 10);
       this.lastName = lastName;
   }
   private void setContactID(String contactID){
       checkNotNull(contactID);
       checkNotTooBig(contactID, 10);
       this.contactID = contactID;
   }
   public void setPhone(String input){
    checkNotNull(input);
    String cleanNumber = cleanPhoneNumber(input);
    if(cleanNumber.length() != 10){
        throw new IllegalArgumentException("Phone number must be 10 digits.");
    }
    this.phone= cleanNumber;
   } 
   public void setAddress(String address){
       checkNotNull(address);
       checkNotTooBig(address, 30);
       this.address = address;  
   }
  
}
