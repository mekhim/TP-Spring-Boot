package com.servicetp.dao.mongoDB;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class MongoDBConnection {

    private static MongoDBConnection instance;
    private DB database;
    private DBCollection collection;

    private MongoClient connection;

    private void initConnection(){
        try {
            connection = new MongoClient();
            database = connection.getDB("swing");
            collection = database.getCollection("people");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private MongoDBConnection(){
        initConnection();
    }

    public static MongoDBConnection getInstance() {
        if(instance == null){
            instance = new MongoDBConnection();
        }
        return instance;
    }

    public DBCollection getCollection() {
        return collection;
    }
}
