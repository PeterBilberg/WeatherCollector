/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.weather.xml.citycollection.test;

import com.peterbilberg.weather.xml.citycollection.CityCollectionValidationResult;
import com.peterbilberg.weather.xml.citycollection.CitycollectionTool;
import com.peterbilberg.weather.xml.citycollection.schema.CityCollection;
import com.peterbilberg.weather.xml.citycollection.schema.CityType;
import com.peterbilberg.weather.xml.citycollection.schema.CitylistType;
import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pbi
 */
public class CitycollectionToolTest {

    
    private final String pathToTestinputFolder = "./src/test/resources/Testinput/";
    public CitycollectionToolTest() {
    }

    @Test
    public void getCityMapFromFileTest() {
        try {
            CityCollection collection = CitycollectionTool.getinstance().getCityMapFromXmlFile();
            assertTrue(collection != null);
            assertEquals("1.0.0", collection.getVersion());
            assertTrue("number of Cities is= " + collection.getCitylist().getCity().size(), collection.getCitylist().getCity().size() > 1);
        } catch (JAXBException ex) {
            fail("jaxB exception");
        }
    }

    @Test
    public void writeCityCollectionToXmlTest() {
        File outputFile = null;
        try {
            outputFile = File.createTempFile("tempCityCollectionXmlTest", "xml");
            CityCollection collection = new CityCollection();
            CityType city = new CityType();
            city.setName("Aarhus");
            city.setCountry("dk");
            collection.setCitylist(new CitylistType());
            collection.getCitylist().getCity().add(city);
            CitycollectionTool.getinstance().writeCityCollectionToXml(outputFile, collection);

            String stringFromOutoutFile = FileUtils.readFileToString(outputFile, "utf-8");
            assertTrue("Fil ikke læst korrekt", stringFromOutoutFile.contains("Aarhus"));
            outputFile.deleteOnExit();
        } catch (JAXBException ex) {
            outputFile.deleteOnExit();
            fail("jaxB exception");
        } catch (IOException ex) {
            outputFile.deleteOnExit();
            fail("IOException");
        }
    }

    @Test
    public void validateCityCollectionXmlTest_Not_wellFormed() {
        try {
            String inputFromFile = FileUtils.readFileToString(new File(pathToTestinputFolder+"xmlValidation/cityCollectionForTest_NotWellFormed.xml"), "utf-8");
            assertTrue("inputFile ikke læst korrekt", inputFromFile.length() > 0);

            CityCollectionValidationResult result = CitycollectionTool.getinstance().validateCityCollectionXml(inputFromFile);

            assertEquals(false, result.isValidate());
            assertEquals(null, result.getSaxException());
            assertEquals(null, result.getUnsupportedEncodingException());
            assertEquals(3, result.getEvents().size());
            assertEquals("The element type \"tn:cityx\" must be terminated by the matching end-tag \"</tn:cityx>\".", result.getErrorMessage());
            
        } catch (Exception ex) {

            fail("exception");
        }
    }
    
    @Test
    public void validateCityCollectionXmlTest_WellFormedOk() {
        try {
            String inputFromFile = FileUtils.readFileToString(new File(pathToTestinputFolder+"xmlValidation/cityCollectionForTest_WellFormedOk.xml"), "utf-8");
            assertTrue("inputFile ikke læst korrekt", inputFromFile.length() > 0);

            CityCollectionValidationResult result = CitycollectionTool.getinstance().validateCityCollectionXml(inputFromFile);

            assertEquals(true, result.isValidate());
            assertEquals(null, result.getSaxException());
            assertEquals(null, result.getUnsupportedEncodingException());
            assertEquals(null, result.getJaxbException());
            assertEquals(0, result.getEvents().size());
            assertEquals(null, result.getErrorMessage());
            
        } catch (Exception ex) {

            fail("exception");
        }
    }
    
    @Test
    public void validateCityCollectionXmlTest_WellFormedElementNotAllowed() {
        try {
            String inputFromFile = FileUtils.readFileToString(new File(pathToTestinputFolder+"xmlValidation/cityCollectionForTest_WellFormedElementNotAllowed.xml"), "utf-8");
            assertTrue("inputFile ikke læst korrekt", inputFromFile.length() > 0);

            CityCollectionValidationResult result = CitycollectionTool.getinstance().validateCityCollectionXml(inputFromFile);

            assertEquals(false, result.isValidate());
            assertEquals(null, result.getSaxException());
            assertEquals(null, result.getUnsupportedEncodingException());
            assertEquals(null, result.getJaxbException());
            assertEquals(2, result.getEvents().size());
            assertEquals("cvc-complex-type.2.4.a: Invalid content was found starting with element 'name'. One of '{\"peterBilberg.com/weather/cityCollection/schema\":name}' is expected.", result.getErrorMessage());
            
        } catch (Exception ex) {

            fail("exception");
        }
    }
    
     @Test
    public void validateCityCollectionXmlTest_WellFormedMissingElement() {
        try {
            String inputFromFile = FileUtils.readFileToString(new File(pathToTestinputFolder+"xmlValidation/cityCollectionForTest_WellFormedMissingElement.xml"), "utf-8");
            assertTrue("inputFile ikke læst korrekt", inputFromFile.length() > 0);

            CityCollectionValidationResult result = CitycollectionTool.getinstance().validateCityCollectionXml(inputFromFile);

            assertEquals(false, result.isValidate());
            assertEquals(null, result.getSaxException());
            assertEquals(null, result.getUnsupportedEncodingException());
            assertEquals(null, result.getJaxbException());
            assertEquals(1, result.getEvents().size());
            assertEquals("cvc-complex-type.2.4.b: The content of element 'tn:city' is not complete. One of '{\"peterBilberg.com/weather/cityCollection/schema\":country}' is expected.", result.getErrorMessage());
            
        } catch (Exception ex) {

            fail("exception");
        }
    }
}
