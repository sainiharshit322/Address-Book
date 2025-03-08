package addressBook;

import contact.Contact;

import java.util.*;

public class AddressBook {
    private Map<String, Contact> contactMap;

    public AddressBook() {
        contactMap = new HashMap<>();
    }

    // Add a new contact
    public void addContact(String name, String phoneNumber, String email) {
        if (contactMap.containsKey(name)) {
            System.out.println("Contact with this name already exists.");
        } else {
            Contact contact = new Contact(name, phoneNumber, email);
            contactMap.put(name, contact);
            System.out.println("Contact added successfully!");
        }
    }

    // Modify an existing contact
    public void modifyContact(String name, String newPhoneNumber, String newEmail) {
        Contact contact = contactMap.get(name);
        if (contact != null) {
            contact.setPhoneNumber(newPhoneNumber);
            contact.setEmail(newEmail);
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Contact not found!");
        }
    }

    // Delete a contact
    public void deleteContact(String name) {
        if (contactMap.remove(name) != null) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found!");
        }
    }

    // Search for a contact
    public void searchContact(String name) {
        Contact contact = contactMap.get(name);
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("Contact not found!");
        }
    }

    public String listAllContacts() {
        if (contactMap.isEmpty()) {
            return "No contacts found";
        } else {
            for (Contact contact : contactMap.values()) {
                System.out.println(contact);
                return contact.toString();
            }
        }
        return "";
    }
}