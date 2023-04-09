package com.ettounani.ws;

import com.ettounani.ws.entities.Contact;
import com.ettounani.ws.entities.Gender;
import com.ettounani.ws.entities.Type;
import com.ettounani.ws.repository.IContactRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactWS {

    public static void main(String[] args) {
        SpringApplication.run(ContactWS.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(IContactRepo contactRepo) {

        return args -> {
            contactRepo.save(new Contact(
                    0,
                    "Abderrahmane",
                    "ETTOUNANI",
                    "tounani@gmail.com",
                    "01111111",
                    Type.BUSINESS,
                    Gender.MALE
            ));
            contactRepo.save(new Contact(
                    0,
                    "khadija",
                    "khayer eddine",
                    "tounani4@gmail.com",
                    "04444444",
                    Type.PERSONNEL,
                    Gender.FEMALE
            ));
            contactRepo.save(new Contact(
                    0,
                    "youssef",
                    "ETTOUNANI",
                    "tounani3@gmail.com",
                    "03333333",
                    Type.BUSINESS,
                    Gender.MALE
            ));
            contactRepo.save(new Contact(
                    0,
                    "oumaima",
                    "ETTOUNANI",
                    "tounani2@gmail.com",
                    "02222222",
                    Type.PERSONNEL,
                    Gender.FEMALE
            ));
            contactRepo.save(new Contact(
                    0,
                    "ahmed",
                    "ETTOUNANI",
                    "tounani6@gmail.com",
                    "0555555",
                    Type.PERSONNEL,
                    Gender.MALE
            ));
            contactRepo.save(new Contact(
                    0,
                    "Boutaina",
                    "Oubella",
                    "boutaina2@gmail.com",
                    "0888888",
                    Type.PERSONNEL,
                    Gender.FEMALE
            ));
        };
    }

}
