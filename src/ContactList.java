import java.io.*;
import java.util.*;

public class ContactList {

    public static void main(String args[]) throws IOException {
        Contact contact;
        contact = new Contact();
        int action = 0;

        ArrayList<Contact> contacts = new ArrayList<Contact>();
        while (action != 6) {

            System.out.println("\nWelcome to Contact List DB. "
                    + "What would you like to do? \n");

            System.out.println("1. Enter a new person" + "\n"
                    + "2. Print the contact list" + "\n"
                    + "3. Retrieve a person's information by last name" + "\n"
                    + "4. Retrieve a person's information by email address" + "\n"
                    + "5. Retrieve all people who live in a given zip code" + "\n"
                    + "6. Exit");
            Scanner reader = new Scanner(System.in);
            reader.useDelimiter("\n");
            action = reader.nextInt();

            if (action <= 0 || action > 6) {
                System.out.println("Invalid selection. ");

            }

            switch (action) {

                case 1: {

                    System.out.println("\nEnter Contact Last Name:");
                    String lastname = reader.next();
                    if (lastname == null) {
                        System.out.println("\nInvalid entry. ");
                        break;
                    }

                    else {
                        contact.setLastName(lastname.toLowerCase());
                    }
                    System.out.println("Enter Contact First Name: ");
                    String firstname = reader.next();
                    contact.setFirstName(firstname.toLowerCase());
                    System.out.println("Enter Contact Street Address: ");
                    String address = reader.next();
                    contact.setHouseAddress(address.toLowerCase());
                    System.out.println("Enter Contact City: ");
                    String city = reader.next();
                    contact.setCity(city.toLowerCase());
                    System.out.println("Enter Contact Zip Code: ");
                    String zip = reader.next();
                    contact.setZip(zip.toLowerCase());
                    System.out.println("Enter Contact Email: ");
                    String email = reader.next();
                    contact.setEmail(email.toLowerCase());
                    System.out.println("Enter Contact Phone Number: ");
                    String phone = reader.next();
                    contact.setPhone(phone.toLowerCase());
                    System.out.println("Enter Contact Notes: ");
                    String notes = reader.next();
                    contact.setNotes(notes.toLowerCase());

                    contacts.add(contact);

                    try {

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

                break;


                case 2: {

                    int counter = 0;
                    String line = null;

                    // Location of file to read
                    File file = new File("contactlist.csv");

                    // Sort contacts and print to console
                    try {

                        Scanner scanner = new Scanner(file);

                        // Before printing, add each line to a sorted set. by Seth
                        // Copeland
                        Set<String> lines = new TreeSet<>();
                        while (scanner.hasNextLine()) {
                            line = scanner.nextLine();
                            lines.add(line);
                            counter++;

                        }

                        // Print sorted contacts to console.
                        for (String fileLine : lines) {
                            String outlook = fileLine.substring(0, 1).toUpperCase()
                                    + fileLine.substring(1);
                            System.out.println(outlook);

                        }


                        scanner.close();

                    } catch (FileNotFoundException e) {

                    }
                    System.out.println("\n" + counter + " contacts in records.");

                }

                break;


                case 3:

                    try {
                        System.out.println("\nEnter the last"
                                + "name to search for: ");
                        String searchterm = reader.next();

                        // Open the file as a buffered reader
                        BufferedReader bf = new BufferedReader(new FileReader(
                                "contactlist.csv"));

                        // Start a line count and declare a string to hold our
                        // current line.
                        int linecount = 0;
                        String line;

                        // Let the user know what we are searching for
                        System.out.println("Searching for " + searchterm
                                + " in file...");
                        // Loop through each line, putting the line into our line
                        // variable.
                        boolean noMatches = true;
                        while ((line = bf.readLine()) != null) {
                            // Increment the count and find the index of the word.
                            linecount++;
                            int indexfound = line.indexOf(searchterm.toLowerCase());

                            // If greater than -1, means we found a match.
                            if (indexfound > -1) {
                                System.out.println("\nContact was FOUND\n"
                                        + "\nContact " + linecount + ": " + line);
                                noMatches = false;
                            }

                        }

                        // Close the file after done searching
                        bf.close();
                        if (noMatches) {
                            System.out.println("\nNO MATCH FOUND.\n");
                        }
                    }

                    catch (IOException e) {
                        System.out.println("IO Error Occurred: " + e.toString());
                    }

                    break;


                case 4:

                    try {
                        System.out.println("\nEnter the email "
                                + "address to search for: ");
                        String searchterm = reader.next();

                        // Open the file as a buffered reader
                        BufferedReader bf = new BufferedReader(new FileReader(
                                "contactlist.csv"));

                        // Start a line count and declare a string to hold our
                        // current line.
                        int linecount = 0;
                        String line;

                        // Let the user know what we are searching for
                        System.out.println("\nSearching for " + searchterm
                                + " in file...");

                        // Loop through each line, put the line into our line
                        // variable.
                        boolean noMatches = true;
                        while ((line = bf.readLine()) != null) {

                            // Increment the count and find the index of the word
                            linecount++;
                            int indexfound = line.indexOf(searchterm.toLowerCase());

                            // If greater than -1, means we found a match
                            if (indexfound > -1) {
                                System.out.println("\nContact was FOUND\n"
                                        + "\nContact " + linecount + ": " + line);
                                noMatches = false;
                            }

                        }
                        // Close the file after done searching
                        bf.close();
                        if (noMatches) {
                            System.out.println("\nNO MATCH FOUND.\n");
                        }

                    }

                    catch (IOException e) {
                        System.out.println("IO Error Occurred: " + e.toString());
                    }

                    break;


                case 5:

                    try {
                        System.out.println("\nEnter the Zipcode to search for: ");
                        String searchterm = reader.next();

                        // Open the file as a buffered reader
                        BufferedReader bf = new BufferedReader(new FileReader(
                                "contactlist.csv"));

                        // Start a line count and declare a string to hold our
                        // current line.
                        int linecount = 0;
                        String line;

                        // Let the user know what we are searching for
                        System.out.println("\nSearching for " + searchterm
                                + " in file...");

                        // Loop through each line, stashing the line into our line
                        // variable.
                        boolean noMatches = true;
                        while ((line = bf.readLine()) != null) {

                            // Increment the count and find the index of the word.
                            linecount++;
                            int indexfound = line.indexOf(searchterm.toLowerCase());

                            // If greater than -1, means we found a match.
                            if (indexfound > -1) {
                                System.out.println("\nContact was FOUND\n"
                                        + "\nContact " + linecount + ": " + line);
                                noMatches = false;
                            }
                        }
                        // Close the file after done searching
                        bf.close();
                        if (noMatches) {
                            System.out.println("\nNO MATCH FOUND.\n");
                        }
                    }

                    catch (IOException e) {
                        System.out.println("IO Error Occurred: " + e.toString());
                    }

                    break;
            }
        }
    }
}