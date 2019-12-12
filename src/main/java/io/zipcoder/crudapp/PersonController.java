package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personService.createPerson(p), HttpStatus.CREATED);

    }
    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") int id){
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }
    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getPersonList(){
        return new ResponseEntity<>(personService.getPersonList(), HttpStatus.OK);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person p){
        return new ResponseEntity<>(personService.updatePerson(p, id), HttpStatus.OK);
    }
    @DeleteMapping("/people/{id}")
    public void deletePerson(@PathVariable("id") int id){
        personService.delete(id);
    }



}