package uz.pdp.service;
import uz.pdp.model.Contact;
import uz.pdp.repo.ContactRepository;

import java.util.List;

public class ContactService {
    private ContactRepository contactRepository = new ContactRepository();
    public   void deleteContact(String phone) {
        Contact contact = contactRepository.getByPhone(phone);
        if (contact == null){
            System.out.println("Contact not exists. Mazgi");
            return;
        }
        int deleted = contactRepository.delete(phone);
        if (deleted == 1){
            System.out.println("Contact successfully deleted");
        }
    }

    public void contactList() {
        List<Contact> contactList = contactRepository.getList();
        for (Contact contact : contactList) {
            System.out.println(contact.getName()+ " " + contact.getSurname()+ " " +contact.getPhone());
        }
    }

    public void addContact(Contact contact) {
        boolean exists = contactRepository.saveContact(contact);
        if (exists){
            System.out.println("Contact added");
        }else {
            System.out.println("Something wend wrong. Mazgi");
        }
    }

    public   void searchContact(String query) {
        List<Contact> contactList = contactRepository.search(query);
        for (Contact contact : contactList) {
            System.out.println(contact.getName()+ " " + contact.getSurname()+ " " +contact.getPhone());
        }
    }
}
