/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.weather.mongodb.test;

import com.mongodb.MongoException;
import com.peterbilberg.weather.mongodb.DaoMongoDb;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pbi
 */
public class DaoMongoDbTest {
    
 
     @Test
     public void countweatherDocumentsTest() {
         try{
     DaoMongoDb daoMongoDb = new DaoMongoDb("localhost", 27017,"openweatherRawData_Test", "weatherCollection");
     long number =  daoMongoDb.countDocumentsInCollection();
     daoMongoDb.closeMongo();
     assertTrue(number > 9000);
    
         }catch(MongoException e){
             fail("MongoException: "+e.getMessage());
         }
     }
     
             @Test
     public void getAllWeatherDocumentsForCityTest() {
         try{
     DaoMongoDb daoMongoDb = new DaoMongoDb("localhost", 27017,"openweatherRawData_Test", "weatherCollection");
     List<String> jsonList = daoMongoDb.getAllWeatherDocumentsForCity("Skjern");
    daoMongoDb.closeMongo();
     assertTrue(jsonList.size() > 4);
    
         }catch(MongoException e){
             fail("MongoException: "+e.getMessage());
         }
     }
}
