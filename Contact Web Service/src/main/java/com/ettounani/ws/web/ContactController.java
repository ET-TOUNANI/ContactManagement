//Authors : Abderrahim Ettounani
package com.ettounani.ws.web;

import com.ettounani.ws.entities.Contact;
import com.ettounani.ws.repository.IContactRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ContactController {
    private final IContactRepo contactRepo;

    @GetMapping("/contacts")
    public List<Contact> all() {

        System.out.println("jooo");
        return contactRepo.findAll();
    }

    @PostMapping("/contact")
    Contact newContact(@RequestBody Contact newContact) {
        return contactRepo.save(newContact);
    }

    @GetMapping("/contacts/{id}")
    Contact one(@PathVariable Long id) {
        return contactRepo.findById(id).isPresent() ? contactRepo.findById(id).get() : new Contact();
    }

    @DeleteMapping("/deleteContacts/{id}")
    void deleteContact(@PathVariable Long id) {

        System.out.println("delete" + id);
        contactRepo.deleteById(id);
    }

    @PutMapping("/contacts/{id}")
    Contact updateContact(@RequestBody Contact contact, @PathVariable Long id) {
        return contactRepo.findById(id)
                .map(contact1 -> {
                    contact1.setFirstName(contact.getFirstName());
                    contact1.setPhone(contact.getPhone());
                    contact1.setLastName(contact.getLastName());
                    contact1.setEmail(contact.getEmail());
                    contact1.setGender(contact.getGender());
                    contact1.setType(contact.getType());
                    return contactRepo.save(contact1);
                })
                .orElseGet(() -> {
                    contact.setId(id);
                    return contactRepo.save(contact);
                });
    }

}
