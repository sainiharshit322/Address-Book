package gui;
import addressBook.AddressBook;
import javax.swing.*;
import java.awt.*;

public class AddressBookGUI extends JFrame {
    private AddressBook addressBook;
    private JTextArea textArea;
    private JTextField nameField, phoneField, emailField;

    public AddressBookGUI() {
        addressBook = new AddressBook();

        setTitle("Address Book");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneLabel = new JLabel("Phone:");
        JLabel emailLabel = new JLabel("Email:");

        nameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();

        JButton addButton = new JButton("Add Contact");
        JButton modifyButton = new JButton("Modify Contact");
        JButton deleteButton = new JButton("Delete Contact");
        JButton searchButton = new JButton("Search Contact");
        JButton listButton = new JButton("List All Contacts");

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(addButton);
        panel.add(modifyButton);
        panel.add(deleteButton);
        panel.add(searchButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(listButton, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addContact());
        modifyButton.addActionListener(e -> modifyContact());
        deleteButton.addActionListener(e -> deleteContact());
        searchButton.addActionListener(e -> searchContact());
        listButton.addActionListener(e -> listContacts());
    }

    private void addContact() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        addressBook.addContact(name, phone, email);

        textArea.setText("Contact created successfully!\n");

        listContacts();
        clearFields();
    }

    private void modifyContact() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        addressBook.modifyContact(name, phone, email);

        textArea.setText("Contact modified successfully!\n");

        listContacts();
        clearFields();
    }

    private void deleteContact() {
        String name = nameField.getText();
        addressBook.deleteContact(name);

        textArea.setText("Contact deleted successfully!\n");

        listContacts();
        clearFields();
    }

    private void searchContact() {
        String name = nameField.getText();
        addressBook.searchContact(name);
        clearFields();
    }

    private void listContacts() {
        textArea.append("\n--- Listing All Contacts ---\n");
        textArea.append(addressBook.listAllContacts());
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }
}