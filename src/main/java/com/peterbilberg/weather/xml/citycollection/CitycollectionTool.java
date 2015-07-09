/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.weather.xml.citycollection;

import com.peterbilberg.weather.xml.citycollection.schema.CityCollection;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.commons.io.FileUtils;
import org.xml.sax.SAXException;

/**
 *
 * @author pbi
 */
public class CitycollectionTool {

    private final String pathToCityCollectionXmlFile = "src/main/resources/cityCollectionXml/cityCollection.xml";
    private final String pathToCityCollectionXsdFile = "src/main/resources/cityCollectionJaxB/cityCollection.xsd";
    private static CitycollectionTool instance = new CitycollectionTool();

    private CitycollectionTool() {
    }

    public static CitycollectionTool getinstance() {
        return instance;
    }

    public CityCollection getCityMapFromXmlFile() throws JAXBException {
        CityCollection cityCollection = null;
        File file = new File(pathToCityCollectionXmlFile);
        JAXBContext jaxbContext = JAXBContext.newInstance(CityCollection.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        cityCollection = (CityCollection) jaxbUnmarshaller.unmarshal(file);
        return cityCollection;
    }

    public void writeCityCollectionToXml(File outputFile, CityCollection cityCollection) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(CityCollection.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(cityCollection, outputFile);
        jaxbMarshaller.marshal(cityCollection, System.out);
    }

    public CityCollectionValidationResult validateCityCollectionXml() throws IOException {
        File file = new File(pathToCityCollectionXmlFile);
        String inputXml = FileUtils.readFileToString(file,("utf-8"));
        return validateCityCollectionXml(inputXml);
    }
    
    public CityCollectionValidationResult validateCityCollectionXml(String inputXml) {
        CityCollectionValidationResult cityCollectionValidationResult = new CityCollectionValidationResult();
        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File(pathToCityCollectionXsdFile));

            JAXBContext jc = JAXBContext.newInstance(CityCollection.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setSchema(schema);
            CityCollectionValidationEventHandler cityCollectionValidationEventHandler = new CityCollectionValidationEventHandler(cityCollectionValidationResult);
            unmarshaller.setEventHandler(cityCollectionValidationEventHandler);

            InputStream stream = new ByteArrayInputStream(inputXml.getBytes("utf-8"));

            unmarshaller.unmarshal(stream);

        } catch (SAXException ex) {
            cityCollectionValidationResult.setValidate(false);
            cityCollectionValidationResult.setSaxException(ex);
        } catch (JAXBException ex) {
            cityCollectionValidationResult.setValidate(false);
            cityCollectionValidationResult.setJaxbException(ex);
        } catch (UnsupportedEncodingException ex) {
            cityCollectionValidationResult.setValidate(false);
            cityCollectionValidationResult.setUnsupportedEncodingException(ex);
        }
        return cityCollectionValidationResult;
    }

}
