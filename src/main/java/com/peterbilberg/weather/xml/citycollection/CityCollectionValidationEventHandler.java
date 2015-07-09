/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.weather.xml.citycollection;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

/**
 *
 * @author pbi
 */
public class CityCollectionValidationEventHandler implements ValidationEventHandler {

    private CityCollectionValidationResult result;
    public CityCollectionValidationEventHandler(CityCollectionValidationResult result){
        this.result = result;
    }
 @Override
    public boolean handleEvent(ValidationEvent event) {
      result.addEvent(event);
      result.setValidate(false);
//        System.out.println("\nEVENT");
//        System.out.println("SEVERITY:  " + event.getSeverity());
//        System.out.println("MESSAGE:  " + event.getMessage());
//        System.out.println("LINKED EXCEPTION:  " + event.getLinkedException());
//        System.out.println("LOCATOR");
//        System.out.println("    LINE NUMBER:  " + event.getLocator().getLineNumber());
//        System.out.println("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber());
//        System.out.println("    OFFSET:  " + event.getLocator().getOffset());
//        System.out.println("    OBJECT:  " + event.getLocator().getObject());
//        System.out.println("    NODE:  " + event.getLocator().getNode());
//        System.out.println("    URL:  " + event.getLocator().getURL());
        return true;
    }

    
    
    
    
}
