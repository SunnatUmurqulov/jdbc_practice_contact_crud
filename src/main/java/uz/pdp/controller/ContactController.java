package uz.pdp.controller;

import uz.pdp.model.Contact;
import uz.pdp.service.ContactService;
import uz.pdp.DataBaseUtil;

import java.util.Scanner;

public class ContactController {

    private Scanner strScanner = new Scanner(System.in);
    private Scanner numScanner = new Scanner(System.in);
    public  void start(){
        DataBaseUtil.createTable();
        boolean flag = true;
        while (flag){
            showMenu();
            int action = getAction();

            switch (action){
                case 1 :
                    System.out.println("Add Contact");
                    addContact();
                    break;
                case 2:
                    System.out.println("Contact List");
                    contactList();
                    break;
                case 3:
                    System.out.println("Delete Contact");
                    deleteContact();
                    break;
                case 4:
                    System.out.println("Search Contact");
                    searchContact();
                    break;
                case 0:
                    System.out.println("Exit");
                    flag = false;
            }
        }
    }

    public   void searchContact() {
        System.out.println("Enter query: ");
        String query = strScanner.next();
        ContactService contactService = new ContactService();
        contactService.searchContact(query);
    }

    public   void deleteContact() {
        System.out.println("Enter phone: ");
        String phone = strScanner.next();
        ContactService contactService = new ContactService();
        contactService.deleteContact(phone);
    }

    public   void contactList() {
       ContactService contactService = new ContactService();
       contactService.contactList();
    }

    public   void addContact() {

        System.out.println("Enter name: ");
        String name = strScanner.next();

        System.out.println("Enter surname: ");
        String surname = strScanner.next();

        System.out.println("Enter phone: ");
        String phone = strScanner.next();

        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);

        ContactService contactService = new ContactService();
        contactService.addContact(contact);
    }

    public  void showMenu(){
        System.out.println("*** Menu ***");
        System.out.println("1. Add Contact");
        System.out.println("2. Contact List");
        System.out.println("3. Delete Contact");
        System.out.println("4. Search Contact");
        System.out.println("0. Exit");
    }

    public  int getAction(){
        System.out.println("Enter Action: ");
        return numScanner.nextInt();
    }
}
