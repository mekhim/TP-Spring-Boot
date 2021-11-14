package com.servicetp.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.servicetp.dao.mongoDB.MongoDBConnection;
import com.servicetp.model.Address;
import com.servicetp.model.People;
import org.bson.BSONObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class PeopleDAO implements IPeopleDAO{

    @Override
    public List<People> findAll() {

        DBCursor cursor = MongoDBConnection.getInstance().getCollection().find();

        List<People> list = new ArrayList<>();

        while(cursor.hasNext()){
            list.add(DBobject_to_People(cursor.next()));
        }

        return list;
    }

    @Override
    public People findOneById(int id) {

        DBObject query = new BasicDBObject("_id",id);
        DBCursor cursor = MongoDBConnection.getInstance().getCollection().find(query);
        DBObject peopleDB = cursor.one();

        return DBobject_to_People(peopleDB);
    }

    @Override
    public void save(People people) {
        DBObject peopleDB = People_to_DBObject(people);
        DBObject template = new BasicDBObject("_id",people.get_id());
        MongoDBConnection.getInstance().getCollection().update(template,peopleDB);
    }

    @Override
    public void add(People people) {
        DBObject peopleDB = People_to_DBObject(people);
        MongoDBConnection.getInstance().getCollection().insert(peopleDB);
    }

    @Override
    public void delete(int id) {
        DBObject peopleDB = new BasicDBObject("_id",id);
        MongoDBConnection.getInstance().getCollection().remove(peopleDB);
    }


    /**
     * convertit un people en DBObject
     * @param people people à convertir
     * @return le people convertit en DBObject
     */
    private static DBObject People_to_DBObject(People people){
        DBObject peopleDB = new BasicDBObject("_id",people.get_id())
                .append("lastname",people.getLastname())
                .append("firstname",people.getFirstname())
                .append("address",new BasicDBObject("street",people.getAddress().getStreet())
                    .append("postalCode",people.getAddress().getPostalCode())
                    .append("city",people.getAddress().getCity()));
        return peopleDB;
    }

    /**
     * convertit un DBOject (une réponse d'une requête) en people
     * @param object le DBObject à convertir
     * @return le DBObject convertit en People
     */
    private static People DBobject_to_People(DBObject object){
        int _id = (int)object.get("_id");
        String lastname = (String)object.get("lastname");
        String firstname = (String)object.get("firstname");
        DBObject addressDB = (DBObject) object.get("address");
        Address address = new Address((String) addressDB.get("street"), (String) addressDB.get("postalCode"),(String) addressDB.get("city"));

        return new People(_id,lastname,firstname,address);
    }
}
