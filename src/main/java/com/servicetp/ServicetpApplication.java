package com.servicetp;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.servicetp.dao.mongoDB.MongoDBConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicetpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicetpApplication.class, args);
    }

}
