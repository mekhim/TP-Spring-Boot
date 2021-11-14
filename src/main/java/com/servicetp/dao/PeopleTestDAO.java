package com.servicetp.dao;

import com.servicetp.model.People;

import java.util.ArrayList;
import java.util.List;


public class PeopleTestDAO implements IPeopleDAO{

    People p;

    public PeopleTestDAO() {
        p = new People();
        p.setLastname("Michel");
    }

    @Override
    public List<People> findAll() {
        People p1 = new People();
        p1.setLastname(p.getLastname());
        p.setLastname("Bernard");
        List<People> list = new ArrayList<People>();
        list.add(p1);
        return list;
    }

    @Override
    public People findOneById(int id) {
        return null;
    }

    @Override
    public void save(People people) {

    }
}
