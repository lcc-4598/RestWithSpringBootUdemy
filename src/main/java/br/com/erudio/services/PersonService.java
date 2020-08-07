package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id) {

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Lucca");
        person.setLastName("Chabu");
        person.setAddress("Santos - Brasil");
        person.setGender("Male");

        return person;
    }

    public List<Person> findAll() {

        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person create(Person person) {
        //persist logic
        return person;
    }

    public Person update(Person person) {
        //persist logic
        return person;
    }

    public void  delete(String id) {
        //persist logic
    }





    private Person mockPerson(int i) {
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("person name" + i);
        person.setLastName("last name" + i);
        person.setAddress("endereco - Brasil" + i);
        person.setGender("genero");

        return person;
    }
}
