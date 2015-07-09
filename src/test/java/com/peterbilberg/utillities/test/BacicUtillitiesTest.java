/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.utillities.test;

import com.peterbilberg.utillities.BacicUtillities;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class BacicUtillitiesTest {

    @Test
    public void convertStreamToStringTest() {
        String input = "I think computer viruses should count as life. I think it says something about human nature that the only form of life we have created so far is purely destructive. We've created life in our own image.\n"
                + "Stephen Hawking";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        String output = BacicUtillities.convertStreamToString(is);
        assertEquals(input, output);
    }

    @Test
    public void makeDateStringTest() {

        try {
            String date = BacicUtillities.makeDateString();
            assertTrue("Date is not correct Date length is: " + date.length(), date.length() == 19);
        } catch (ParseException ex) {
            fail("ParseException");
        }
    }

    @Test
    public void makeDayStampTest() {

        String date = BacicUtillities.makeDayStamp();
        assertTrue("Date is not correct Date length is: " + date.length(), date.length() == 10);
    }

    @Test
    public void maketimeStampTest() {

        String date = BacicUtillities.maketimeStamp();
        assertTrue("Date is not correct Date length is: " + date.length(), date.length() == 19);
    }

    @Test
    public void trimAllTest() {
        String input = "I think computer viruses should count as life. I think it says something about human nature that the only form of life we have created so far is purely destructive. We've created life in our own image.\n"
                + "Stephen Hawking";
        String output = BacicUtillities.trimAll(input);
        assertEquals(input, output);

        String input2 = " I think \tcomputer \tviruses should count as life.  ";
        String output2 = BacicUtillities.trimAll(input2);
        String expected2 = "I think computer viruses should count as life.";
        assertEquals(expected2, output2);
    }
}
