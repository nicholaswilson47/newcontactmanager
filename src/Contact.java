import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Contact {
    private String lastname, firstname, address, city, zip, email, phone,
            notes;

    public Contact(String lastnamename, String firstname, String address,
                   String city, String zip, String email, String phone, String notes,
                   String lastname) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.email = email;
        this.phone = phone;
        this.notes = notes;
    }

    public Contact() {

    }

    // overrides the default Object method
    public String toString() {
        return lastname + ", " + firstname + ", " + address + ", " + city
                + ", " + zip + ", " + email + ", " + phone + ", " + notes;
    }

    /*
     * Sets the value for lastname to "s".
     */
    public void setLastName(String s) {
        lastname = s;
    }

    /*
     * Returns the value of lastname.
     */
    public String getLastName() {
        return lastname;
    }

    /*
     * Sets the value for firstname to "a".
     */
    public void setFirstName(String a) {
        firstname = a;
    }

    /*
     * Returns the value of firstname.
     */
    public String getFirstName() {
        return firstname;
    }

    /*
     * Sets the value for address to "b".
     */
    public void setHouseAddress(String b) {
        address = b;
    }

    /*
     * Returns the value of address.
     */
    public String getHouseAdress() {
        return address;
    }

    /*
     * Sets the value for city to "c".
     */
    public void setCity(String c) {
        city = c;
    }

    /*
     * Returns the value of city.
     */
    public String getCity() {
        return city;
    }

    /*
     * Sets the value for zip to "d".
     */
    public void setZip(String d) {
        zip = d;
    }

    /*
     * Returns the value of zip.
     */
    public String getZip() {
        return zip;
    }

    /*
     * Sets the value for phone to "e".
     */
    public void setPhone(String e) {
        phone = e;
    }

    /*
     * Returns the value of phone.
     */
    public String getPhone() {
        return phone;
    }

    /*
     * Sets the value for email to "f".
     */
    public void setEmail(String f) {
        email = f;
    }

    /*
     * Returns the value of email.
     */
    public String getEmail() {
        return email;
    }

    /*
     * Sets the value for notes to "g".
     */
    public void setNotes(String g) {
        notes = g;
    }

    /*
     * Returns the value of notes.
     */
    public String getNotes() {
        return notes;
    }

    public void read() {

    }

    static void write() {
        // Writes contact info to file. -Damani
        // ----------------------------------------------------------
        try {
            Contact contact;
            contact = new Contact();
            Contact c = contact;

            File file = new File("contactlist.csv");

            // If file doesn't exists, then create it.
            if (!file.exists()) {
                file.createNewFile();
            }

            try (PrintWriter output = new PrintWriter(new FileWriter(
                    "contactlist.csv", true))) {
                output.printf("%s\r\n", c);
            } catch (Exception e) {
            }

            System.out.println("Your contact has been saved.");
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}