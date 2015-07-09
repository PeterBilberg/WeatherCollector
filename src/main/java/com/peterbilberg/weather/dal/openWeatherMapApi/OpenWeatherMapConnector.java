/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.weather.dal.openWeatherMapApi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


/**
 *
 * @author pbi
 */
public class OpenWeatherMapConnector {

    
    public  HttpResponceWrapper getOpenWeatherReport(String city, String country)
             {
                 HttpResponceWrapper myresponse = null;
        try {
            String url = "http://api.openweathermap.org/data/2.5/weather?q="+city+","+country;
            HttpClient httpclient = HttpClientBuilder.create().build();
            
            HttpGet httpget = new HttpGet(url);
            
            HttpResponse response = httpclient.execute(httpget);
            myresponse = new HttpResponceWrapper(response);
         
            return myresponse;
        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapConnector.class.getName()).log(Level.SEVERE, null, ex);
        myresponse.setException(ex);
        return myresponse;
        }
                
	}
    
}
