/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.weather.dal.openWeatherMapApi.test;

import com.peterbilberg.weather.dal.openWeatherMapApi.HttpResponceWrapper;
import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
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
public class HttpResponceWrapperTest {

    private static HttpResponceWrapper myHttpResponseWrapper;

    public HttpResponceWrapperTest() {
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
        String url = "http://google.com";
        HttpClient httpclient = HttpClientBuilder.create().build();

        HttpGet httpget = new HttpGet(url);

        HttpResponse response = httpclient.execute(httpget);
        myHttpResponseWrapper = new HttpResponceWrapper(response);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        assertTrue("myHttpResponseWrapper was null", myHttpResponseWrapper != null);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getHeadersTest() {
        Map<String, String> headerMap = myHttpResponseWrapper.getHeaders();
        assertTrue("headerMap was null", headerMap != null);
        for (String key : headerMap.keySet()) {
            //  System.out.println("key: "+key+"      value: "+headerMap.get(key));
        }

    }

    @Test
    public void getHttpHeaderContentTypeValueTest() {
        String httpHeaderContentTypeValue = myHttpResponseWrapper.getHttpHeaderContentTypeValue();
        assertEquals("text/html; charset=ISO-8859-1", httpHeaderContentTypeValue);
    }

    @Test
    public void getHttpHeaderServerTest() {
        String httpHeaderServer = myHttpResponseWrapper.getHttpHeaderServer();
        assertEquals("gws", httpHeaderServer);
    }

    @Test
    public void getHttpHeaderTransferEncodingTest() {
        String httpHeaderTransferEncoding = myHttpResponseWrapper.getHttpHeaderTransferEncoding();
        assertEquals("chunked", httpHeaderTransferEncoding);
    }

    @Test
    public void getProtocolTest() {
        String protocol = myHttpResponseWrapper.getProtocol();
        assertEquals("HTTP", protocol);
    }

    @Test
    public void getResponseTextTest() {
        try {
            String text = myHttpResponseWrapper.getResponseText();
            assertTrue("ResponseText does not have body element", text.contains("body>"));
        } catch (IllegalStateException ex) {
            fail("IllegalStateException " + ex.getMessage());
        } catch (IOException ex) {
            fail("IOException " + ex.getMessage());
        }
    }

    @Test
    public void getStatusCodeTest() {
        int statusCode = myHttpResponseWrapper.getStatusCode();
        assertEquals(statusCode, 200);
    }

    @Test
    public void getStatusLinieTest() {
        String statusLinie = myHttpResponseWrapper.getStatusLinie();
        assertEquals(statusLinie, "OK");
    }

}
