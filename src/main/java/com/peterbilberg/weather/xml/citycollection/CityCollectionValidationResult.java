/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.weather.xml.citycollection;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.bind.ValidationEvent;
import org.xml.sax.SAXException;

/**
 *
 * @author pbi
 */
public class CityCollectionValidationResult {
    
    private boolean validate = true;
    private String errorMessage;
    private List<ValidationEvent> events = new ArrayList<>();
    private SAXException saxException;
    private JAXBException jaxbException;
    private UnsupportedEncodingException unsupportedEncodingException;
    
    public CityCollectionValidationResult(){
        
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public SAXException getSaxException() {
        return saxException;
    }

    public void setSaxException(SAXException saxException) {
        this.saxException = saxException;
        setErrorMessage(saxException.getMessage());
    }

    public JAXBException getJaxbException() {
        return jaxbException;
    }

    public void setJaxbException(JAXBException jaxbException) {
        this.jaxbException = jaxbException;
        if(jaxbException.getLinkedException() != null){
            setErrorMessage( jaxbException.getLinkedException().getMessage());
        }else{
          setErrorMessage(jaxbException.getMessage());
        }
    }

    public UnsupportedEncodingException getUnsupportedEncodingException() {
        return unsupportedEncodingException;
    }

    public void setUnsupportedEncodingException(UnsupportedEncodingException unsupportedEncodingException) {
        this.unsupportedEncodingException = unsupportedEncodingException;
         setErrorMessage(unsupportedEncodingException.getMessage());
    }

    public List<ValidationEvent> getEvents() {
        return events;
    }

    public void addEvent(ValidationEvent event) {
       getEvents().add(event);
       if(getErrorMessage() == null){
           setErrorMessage(event.getMessage());
       }
    }
            
    
}
