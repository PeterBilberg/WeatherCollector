/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.start;

import com.peterbilberg.weather.dal.openWeatherMapApi.HttpResponceWrapper;
import com.peterbilberg.weather.mongodb.DaoMongoDb;
import com.peterbilberg.weather.dal.openWeatherMapApi.OpenWeatherMapConnector;
import com.peterbilberg.utillities.BacicUtillities;
import com.peterbilberg.weather.xml.citycollection.CityCollectionValidationResult;
import com.peterbilberg.weather.xml.citycollection.CitycollectionTool;
import com.peterbilberg.weather.xml.citycollection.schema.CityCollection;
import com.peterbilberg.weather.xml.citycollection.schema.CityType;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author pbi
 */
public class StartClass {

    public static void main(String[] args) {
        try {
          
            try {
                  CityCollectionValidationResult result = CitycollectionTool.getinstance().validateCityCollectionXml();
            
            if(!result.isValidate()){
                 Logger.getLogger(StartClass.class.getName()).log(Level.WARNING,result.getErrorMessage());
                 throw new RuntimeException(result.getErrorMessage());
            }
            } catch (IOException ex) {
                Logger.getLogger(StartClass.class.getName()).log(Level.WARNING, "CityCollectionXml not found");
                throw ex;
            }
            
            CityCollection cityCollection = CitycollectionTool.getinstance().getCityMapFromXmlFile();
            File errorlog = new File("./Resources/errorlog.txt");
            
            String dbName = "openweatherRawData";
            DaoMongoDb daoMongoDb = new DaoMongoDb("localhost", 27017, dbName, "weatherCollection");
            OpenWeatherMapConnector openWeatherDao = new OpenWeatherMapConnector();
            
            for (CityType city : cityCollection.getCitylist().getCity()) {
                
                try {
                    HttpResponceWrapper fetchResult = openWeatherDao.getOpenWeatherReport(city.getName(), city.getCountry());
                    if (fetchResult.getStatusCode() == 200 && fetchResult.getException() == null) {
                        String jsonCityName = "\"cityname\":\"" + city.getName() + "\"";
                        String jsonDateTime = "\"dateTime\":\"" + BacicUtillities.makeDateString() + "\"";
                        String jsonPayload = "\"payload\":" + fetchResult.getResponseText() + "";
                        String mongoJsonString = "{" + jsonCityName + "," + jsonDateTime + "," + jsonPayload + "}";
                        daoMongoDb.putWeatherDocument(mongoJsonString);
                        System.out.println(city.getName() + " " + city.getCountry() + " ok");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(city.getName());
                        sb.append("  ");
                        sb.append(city.getCountry());
                        sb.append("  ");
                        sb.append("httpStatusCode:");
                        sb.append(fetchResult.getStatusCode());
                        sb.append("  ");
                        sb.append("Text:");
                        sb.append(fetchResult.getResponseText());
                        sb.append("\r\n");
                        sb.append("\r\n");
                        FileUtils.writeStringToFile(errorlog, sb.toString(), "utf-8", true);
                    }
                    
                } catch (Exception ex) {
                    // Logger.getLogger(StartClass.class.getName()).log(Level.SEVERE, null, ex);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Exception: ");
                    sb.append(city.getName());
                    sb.append("  ");
                    sb.append(city.getCountry());
                    sb.append("  ");
                    sb.append(ex.getMessage());
                    sb.append("\r\n");
                    sb.append("\r\n");
                    try {
                        FileUtils.writeStringToFile(errorlog, sb.toString(), "utf-8", true);
                    } catch (IOException ex1) {
                        Logger.getLogger(StartClass.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
            daoMongoDb.closeMongo();
            
            System.out.println("Done " + cityCollection.getCitylist().getCity().size() + " cities was called");
        } catch (RuntimeException | IOException | JAXBException ex) {
            Logger.getLogger(StartClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
