package com.servicetp.dao.mongoDB;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;


public class MongoDBConnection {


    //instance du singleton
    private static MongoDBConnection instance;
    //la base de donnée "spring"
    private DB database;
    //la collection "people"
    private DBCollection collection;

    //la connexion
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
