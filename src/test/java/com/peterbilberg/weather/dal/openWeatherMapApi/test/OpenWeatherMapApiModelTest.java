/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.weather.dal.openWeatherMapApi.test;

import com.peterbilberg.weather.dal.openWeatherMapApi.HttpResponceWrapper;
import com.peterbilberg.weather.dal.openWeatherMapApi.OpenWeatherMapConnector;
import com.peterbilberg.weather.dal.openWeatherMapApi.model.GsonTool;
import com.peterbilberg.weather.dal.openWeatherMapApi.model.Observation;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pbi
 */
public class OpenWeatherMapApiModelTest {

    private static OpenWeatherMapConnector openWeatherMapConnector;


    @BeforeClass
    public static void setUpClass() {
        openWeatherMapConnector = new OpenWeatherMapConnector();

    }

    @Test
    public void jsonToObjectLondonFromFileTest() {
        try {
            String inputFromFile = FileUtils.readFileToString(new File("./src/main/resources/Testinput/jsonExsampleFromOpenWeatherMap_London.txt"), "utf-8");
            assertTrue("inputFile ikke læst korrekt", inputFromFile.length() > 0);

             Observation observation = GsonTool.getinstance().fromJsonToObservationObject(inputFromFile);
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);
          
            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");
            toJsonFromGson = toJsonFromGson.replace("\"deg\":230.0", "\"deg\":230");

            assertEquals(toJsonFromGson, inputFromFile);

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectAarhusFromFileTest() {
        try {
            String inputFromFile = FileUtils.readFileToString(new File("./src/main/resources/Testinput/jsonExsampleFromOpenWeatherMap_Aarhus.txt"), "utf-8");
            assertTrue("inputFile ikke læst korrekt", inputFromFile.length() > 0);

             Observation observation = GsonTool.getinstance().fromJsonToObservationObject(inputFromFile);
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);
          
            toJsonFromGson = toJsonFromGson.replace("\"visibility\":0,", "");
            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");
            toJsonFromGson = toJsonFromGson.replace("\"deg\":240.0", "\"deg\":240");

            assertEquals(toJsonFromGson, inputFromFile);

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectBerlinFromFileTest() {
        try {
            String inputFromFile = FileUtils.readFileToString(new File("./src/main/resources/Testinput/jsonExsampleFromOpenWeatherMap_Berlin.txt"), "utf-8");
            assertTrue("inputFile ikke læst korrekt", inputFromFile.length() > 0);

             Observation observation = GsonTool.getinstance().fromJsonToObservationObject(inputFromFile);
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);
          
            toJsonFromGson = toJsonFromGson.replace("\"visibility\":0,", "");
            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");
            toJsonFromGson = toJsonFromGson.replace("\"deg\":280.0", "\"deg\":280");
            assertEquals(toJsonFromGson, inputFromFile);

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectParisFromFileTest() {
        try {
            String inputFromFile = FileUtils.readFileToString(new File("./src/main/resources/Testinput/jsonExsampleFromOpenWeatherMap_Paris.txt"), "utf-8");
            assertTrue("inputFile ikke læst korrekt", inputFromFile.length() > 0);

             Observation observation = GsonTool.getinstance().fromJsonToObservationObject(inputFromFile);
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);
          
            toJsonFromGson = toJsonFromGson.replace("\"visibility\":0,", "");
            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");
            toJsonFromGson = toJsonFromGson.replace(",\"deg\":0", "");
            toJsonFromGson = toJsonFromGson.replace("\"speed\":3.1.0", "\"speed\":3.1");

            assertEquals(toJsonFromGson, inputFromFile);

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectSkjernFromFileTest() {
        try {
            String inputFromFile = FileUtils.readFileToString(new File("./src/main/resources/Testinput/jsonExsampleFromOpenWeatherMap_Skjern.txt"), "utf-8");
            assertTrue("inputFile ikke læst korrekt", inputFromFile.length() > 0);

             Observation observation = GsonTool.getinstance().fromJsonToObservationObject(inputFromFile);
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);
          
            toJsonFromGson = toJsonFromGson.replace("\"visibility\":0,", "");
            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");
            toJsonFromGson = toJsonFromGson.replace("\"deg\":250.0", "\"deg\":250");
            assertEquals(toJsonFromGson, inputFromFile);

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectOsloFromFileTest() {
        try {
            String inputFromFile = FileUtils.readFileToString(new File("./src/main/resources/Testinput/jsonExsampleFromOpenWeatherMap_Oslo.txt"), "utf-8");
            assertTrue("inputFile ikke læst korrekt", inputFromFile.length() > 0);

            Observation observation = GsonTool.getinstance().fromJsonToObservationObject(inputFromFile);
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);

            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");
            toJsonFromGson = toJsonFromGson.replace("\"deg\":180.0", "\"deg\":180");

            assertEquals(toJsonFromGson, inputFromFile);

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectStockholmFromFileTest() {
        try {
            String inputFromFile = FileUtils.readFileToString(new File("./src/main/resources/Testinput/jsonExsampleFromOpenWeatherMap_Stockholm.txt"), "utf-8");
            assertTrue("inputFile ikke læst korrekt", inputFromFile.length() > 0);

             Observation observation = GsonTool.getinstance().fromJsonToObservationObject(inputFromFile);
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);

            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");
            toJsonFromGson = toJsonFromGson.replace("\"deg\":140.0", "\"deg\":140");

            assertEquals(toJsonFromGson, inputFromFile);

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectLondonFromServletTest() {
        try {
            HttpResponceWrapper replyFromOpenWeather = openWeatherMapConnector.getOpenWeatherReport("London", "uk");
            assertTrue("input fra servlet ikke læst korrekt", replyFromOpenWeather.getResponseText().length() > 0);

             Observation observation = GsonTool.getinstance().fromJsonToObservationObject(replyFromOpenWeather.getResponseText());
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);
          
            // rette deg til hvis
            double deg = observation.getWind().getDeg();
            String degAsString = Double.toString(deg);
            if (degAsString.charAt(degAsString.length() - 1) == '0' && degAsString.charAt(degAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"deg\":" + degAsString, "\"deg\":" + degAsString.substring(0, degAsString.length() - 2));
            }
            
              // rette wind speed til hvis
            double speed = observation.getWind().getSpeed();
            String speedAsString = Double.toString(speed);
            if (speedAsString.charAt(speedAsString.length() - 1) == '0' && speedAsString.charAt(speedAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"speed\":" + speedAsString, "\"speed\":" + speedAsString.substring(0, speedAsString.length() - 2));
            }

            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");
            assertEquals(toJsonFromGson, replyFromOpenWeather.getResponseText());

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectAarhusFromServletTest() {
        try {
            HttpResponceWrapper replyFromOpenWeather = openWeatherMapConnector.getOpenWeatherReport("Århus", "dk");
            assertTrue("input fra servlet ikke læst korrekt", replyFromOpenWeather.getResponseText().length() > 0);

             Observation observation = GsonTool.getinstance().fromJsonToObservationObject(replyFromOpenWeather.getResponseText());
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);
          
            // rette deg til hvis
            double deg = observation.getWind().getDeg();
            String degAsString = Double.toString(deg);
            if (degAsString.charAt(degAsString.length() - 1) == '0' && degAsString.charAt(degAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"deg\":" + degAsString, "\"deg\":" + degAsString.substring(0, degAsString.length() - 2));
            }
            
              // rette wind speed til hvis
            double speed = observation.getWind().getSpeed();
            String speedAsString = Double.toString(speed);
            if (speedAsString.charAt(speedAsString.length() - 1) == '0' && speedAsString.charAt(speedAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"speed\":" + speedAsString, "\"speed\":" + speedAsString.substring(0, speedAsString.length() - 2));
            }

            toJsonFromGson = toJsonFromGson.replace("\"visibility\":0,", "");
            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");
            //   toJsonFromGson = toJsonFromGson.replace("\"deg\":240.0", "\"deg\":240");

            assertEquals(toJsonFromGson, replyFromOpenWeather.getResponseText());

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectBerlinFromServletTest() {
        try {
            HttpResponceWrapper replyFromOpenWeather = openWeatherMapConnector.getOpenWeatherReport("Berlin", "de");
            assertTrue("input fra servlet ikke læst korrekt", replyFromOpenWeather.getResponseText().length() > 0);

        
            Observation observation = GsonTool.getinstance().fromJsonToObservationObject(replyFromOpenWeather.getResponseText());
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);
          
            // rette deg til hvis
            double deg = observation.getWind().getDeg();
            String degAsString = Double.toString(deg);
            if (degAsString.charAt(degAsString.length() - 1) == '0' && degAsString.charAt(degAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"deg\":" + degAsString, "\"deg\":" + degAsString.substring(0, degAsString.length() - 2));
            }
            
              // rette wind speed til hvis
            double speed = observation.getWind().getSpeed();
            String speedAsString = Double.toString(speed);
            if (speedAsString.charAt(speedAsString.length() - 1) == '0' && speedAsString.charAt(speedAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"speed\":" + speedAsString, "\"speed\":" + speedAsString.substring(0, speedAsString.length() - 2));
            }

            toJsonFromGson = toJsonFromGson.replace("\"visibility\":0,", "");
            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");

            assertEquals(toJsonFromGson, replyFromOpenWeather.getResponseText());

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectParisFromServletTest() {
        try {
            HttpResponceWrapper replyFromOpenWeather = openWeatherMapConnector.getOpenWeatherReport("Paris", "fr");
            assertTrue("input fra servlet ikke læst korrekt", replyFromOpenWeather.getResponseText().length() > 0);

           Observation observation = GsonTool.getinstance().fromJsonToObservationObject(replyFromOpenWeather.getResponseText());
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);
 
            // rette deg til hvis
            double deg = observation.getWind().getDeg();
            String degAsString = Double.toString(deg);
            if (degAsString.charAt(degAsString.length() - 1) == '0' && degAsString.charAt(degAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"deg\":" + degAsString, "\"deg\":" + degAsString.substring(0, degAsString.length() - 2));
            }
            
              // rette wind speed til hvis
            double speed = observation.getWind().getSpeed();
            String speedAsString = Double.toString(speed);
            if (speedAsString.charAt(speedAsString.length() - 1) == '0' && speedAsString.charAt(speedAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"speed\":" + speedAsString, "\"speed\":" + speedAsString.substring(0, speedAsString.length() - 2));
            }
          
          
            toJsonFromGson = toJsonFromGson.replace("\"visibility\":0,", "");
            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");
            toJsonFromGson = toJsonFromGson.replace(",\"deg\":0", "");

            assertEquals(toJsonFromGson, replyFromOpenWeather.getResponseText());

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectSkjernFromServletTest() {
        try {
            HttpResponceWrapper replyFromOpenWeather = openWeatherMapConnector.getOpenWeatherReport("Skjern", "dk");
            assertTrue("input fra servlet ikke læst korrekt", replyFromOpenWeather.getResponseText().length() > 0);

             Observation observation = GsonTool.getinstance().fromJsonToObservationObject(replyFromOpenWeather.getResponseText());
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);
          
            // rette deg til hvis
            double deg = observation.getWind().getDeg();
            String degAsString = Double.toString(deg);
            if (degAsString.charAt(degAsString.length() - 1) == '0' && degAsString.charAt(degAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"deg\":" + degAsString, "\"deg\":" + degAsString.substring(0, degAsString.length() - 2));
            }
            
              // rette wind speed til hvis
            double speed = observation.getWind().getSpeed();
            String speedAsString = Double.toString(speed);
            if (speedAsString.charAt(speedAsString.length() - 1) == '0' && speedAsString.charAt(speedAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"speed\":" + speedAsString, "\"speed\":" + speedAsString.substring(0, speedAsString.length() - 2));
            }
          
            toJsonFromGson = toJsonFromGson.replace("\"visibility\":0,", "");
            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");

            assertEquals(toJsonFromGson, replyFromOpenWeather.getResponseText());

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectOsloFromServletTest() {
        try {
            HttpResponceWrapper replyFromOpenWeather = openWeatherMapConnector.getOpenWeatherReport("Oslo", "no");
            assertTrue("input fra servlet ikke læst korrekt", replyFromOpenWeather.getResponseText().length() > 0);

              Observation observation = GsonTool.getinstance().fromJsonToObservationObject(replyFromOpenWeather.getResponseText());
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);
          
            // rette deg til hvis
            double deg = observation.getWind().getDeg();
            String degAsString = Double.toString(deg);
            if (degAsString.charAt(degAsString.length() - 1) == '0' && degAsString.charAt(degAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"deg\":" + degAsString, "\"deg\":" + degAsString.substring(0, degAsString.length() - 2));
            }
            
              // rette wind speed til hvis
            double speed = observation.getWind().getSpeed();
            String speedAsString = Double.toString(speed);
            if (speedAsString.charAt(speedAsString.length() - 1) == '0' && speedAsString.charAt(speedAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"speed\":" + speedAsString, "\"speed\":" + speedAsString.substring(0, speedAsString.length() - 2));
            }

            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");

            assertEquals(toJsonFromGson, replyFromOpenWeather.getResponseText());

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void jsonToObjectStockholmFromServletTest() {
        try {
            HttpResponceWrapper replyFromOpenWeather = openWeatherMapConnector.getOpenWeatherReport("Stockholm", "se");
            assertTrue("input fra servlet ikke læst korrekt", replyFromOpenWeather.getResponseText().length() > 0);

             Observation observation = GsonTool.getinstance().fromJsonToObservationObject(replyFromOpenWeather.getResponseText());
            assertTrue("observation is null", observation != null);
        
          String toJsonFromGson = GsonTool.getinstance().fromObservationObjectToJsonString(observation);
          
            // rette deg til hvis
            double deg = observation.getWind().getDeg();
            String degAsString = Double.toString(deg);
            if (degAsString.charAt(degAsString.length() - 1) == '0' && degAsString.charAt(degAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"deg\":" + degAsString, "\"deg\":" + degAsString.substring(0, degAsString.length() - 2));
            }
            
              // rette wind speed til hvis
            double speed = observation.getWind().getSpeed();
            String speedAsString = Double.toString(speed);
            if (speedAsString.charAt(speedAsString.length() - 1) == '0' && speedAsString.charAt(speedAsString.length() - 2) == '.') {
                toJsonFromGson = toJsonFromGson.replace("\"speed\":" + speedAsString, "\"speed\":" + speedAsString.substring(0, speedAsString.length() - 2));
            }

            toJsonFromGson = toJsonFromGson.replace(",\"sea_level\":0.0,\"grnd_level\":0.0", "");

            assertEquals(toJsonFromGson, replyFromOpenWeather.getResponseText());

        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMapApiModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
