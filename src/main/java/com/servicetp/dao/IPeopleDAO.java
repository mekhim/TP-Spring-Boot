package com.servicetp.dao;

import com.servicetp.model.People;

import java.util.List;

public interface IPeopleDAO {

    List<People> findAll();

    People findOneById(int id);

    void save(People people);


}
