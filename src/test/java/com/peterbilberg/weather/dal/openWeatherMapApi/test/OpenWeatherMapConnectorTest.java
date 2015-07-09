/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.weather.dal.openWeatherMapApi.test;

import com.peterbilberg.weather.dal.openWeatherMapApi.HttpResponceWrapper;
import com.peterbilberg.weather.dal.openWeatherMapApi.OpenWeatherMapConnector;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pbi
 */
public class OpenWeatherMapConnectorTest {
    private static OpenWeatherMapConnector openWeatherMapConnector;
   
    public OpenWeatherMapConnectorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        openWeatherMapConnector =new OpenWeatherMapConnector();
      
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void getOpenWeatherReportTest() {
      
        try {
            String city = "london";
            String land ="uk";
            HttpResponceWrapper httpResponceWrapper = openWeatherMapConnector.getOpenWeatherReport(city, land);
            
            assertTrue("StatusCode is not 200", httpResponceWrapper.getStatusCode() == 200);
           
            String jsonObjectFromOpenWeatherMap = httpResponceWrapper.getResponseText();
            
            assertTrue("jsonObjectFromOpenWeatherMap is empty", jsonObjectFromOpenWeatherMap.length() >0);
            assertTrue("Responce from OpenWeatherMap does not contain \"London\"", jsonObjectFromOpenWeatherMap.contains("London"));
        } catch (IllegalStateException ex) {
            fail("IllegalStateException " + ex.getMessage());
        } catch (IOException ex) {
            fail("IOException " + ex.getMessage());
        }
     }
}
