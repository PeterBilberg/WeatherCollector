/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.weather.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import java.util.ArrayList;
import java.util.List;
import org.bson.BsonDocument;
import org.bson.Document;

/**
 *
 * @author pbi
 */
public class DaoMongoDb {
    
    private final MongoClient mongoClient;
    private final MongoDatabase db;
    private final MongoCollection weatherCollection;
    
    public DaoMongoDb(String host,int port,String databaseName, String collection)throws MongoException{
        mongoClient = new MongoClient( host , port );
        MongoIterable<String> dbnames = mongoClient.listDatabaseNames();
       System.out.println("------------------------------------------------------");
        System.out.println("Starting MongoClient to host: "+host+" on port: "+port);
        for(String bdn : dbnames){
            System.out.println("Database: "+bdn);
        }
        db = mongoClient.getDatabase(databaseName);
       // db = mongoClient.getDB( databaseName);
       weatherCollection = db.getCollection(collection);
         
    }
    public void putWeatherDocument(String weatherDocument){
        Document doc = Document.parse(weatherDocument);
        weatherCollection.insertOne(doc);      
    }
    public void closeMongo(){
        mongoClient.close();
    }
    
    public long countDocumentsInCollection(){
    
    long count =  weatherCollection.count();
  
          return count;
    }
    
     public List<String> getAllWeatherDocumentsForCity(String cityname){
          BsonDocument filter =  BsonDocument.parse("{\"cityname\":\""+cityname+"\"}");
         FindIterable findIterable = weatherCollection.find(filter);
                 List<String> jsonAsStringList = new ArrayList();
                MongoCursor iterator = findIterable.iterator();
         while(iterator.hasNext()){
             Document next = (Document)iterator.next();
             jsonAsStringList.add(next.toJson());
             System.out.println(next.toJson());
         }
          return jsonAsStringList;
    }

    
    
}
