package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> getPersonList(){
        return personRepository.findAll();
    }

    public Person getPerson(int id){
        return personRepository.findOne(id);
    }

    public Person createPerson(Person p){
        return personRepository.save(p);

    }

    public Person updatePerson(Person p, int id){
        Person updatedPerson = personRepository.findOne(id);
        updatedPerson.setFirst_name(p.getFirst_name());
        updatedPerson.setLast_name(p.getLast_name());
        return personRepository.save(updatedPerson);
    }

    public Boolean delete(int id){
        personRepository.delete(id);
        return true;
    }





}