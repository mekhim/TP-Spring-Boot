package com.servicetp.web;

import com.servicetp.dao.IPeopleDAO;
import com.servicetp.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeopleController {

    private final IPeopleDAO dao;

    @Autowired
    public PeopleController(IPeopleDAO dao) {
        this.dao = dao;
    }

    @GetMapping(value="/people")
    public List<People> getPeople() {
        return dao.findAll();
    }

    @GetMapping(value="/people/{id}")
    public People getOnePeople(@PathVariable int id) {
        return dao.findOneById(id);
    }

    @PutMapping(value="/people")
    public void getOnePeople(@RequestBody People people) {
         dao.save(people);
    }


}
