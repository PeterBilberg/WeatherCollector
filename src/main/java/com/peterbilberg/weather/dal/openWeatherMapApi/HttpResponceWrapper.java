package com.peterbilberg.weather.dal.openWeatherMapApi;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


import org.apache.http.Header;
import org.apache.http.HeaderIterator;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;



/**
 * This class wraps an apache.http.HttpResponse
 * And makes it easy to get data from the responce
 * @author peter Bilberg
 *
 */
public class HttpResponceWrapper {
		
	private final HttpResponse response;
	private String responseText = null;
        private Exception exception = null;

	/**
	 * Constructor takes a org.apache.http.HttpResponse
	 * @param response
	 */
	public HttpResponceWrapper(HttpResponse response){

	this.response = response;	

	}
/**
 * returns the statuscode from the http responce
 * The statuscode is an int code.
 * 
 * @return statuscode as int or null if not yet set
 */
	public int getStatusCode(){
		return response.getStatusLine().getStatusCode();
	}
	
	/**
	 * returns the StatusLinie from the http responce
	 * @return
	 */
	public String getStatusLinie(){
		return response.getStatusLine().getReasonPhrase();
	}
	
	/**
	 * returns the protocol from the http responce
	 * @return
	 */
	public String getProtocol(){
		return response.getStatusLine().getProtocolVersion().getProtocol();
	}

	/**
	 * returns the Content-Type value from http header
	 * @return
	 */
	public String getHttpHeaderContentTypeValue(){
		return getHeaders().get("Content-Type");
	}

	/**
	 * returns the Transfer-Encoding value from http header
	 * @return
	 */
	public String getHttpHeaderTransferEncoding(){
		return getHeaders().get("Transfer-Encoding");
	}

	/**
	 * returns the Server value from http header
	 * @return
	 */
	public String getHttpHeaderServer(){
		return getHeaders().get("Server");
	}

	/**
	 * returns Map containing all http headers from responce
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String,String> getHeaders(){
	Map<String,String> headerMap = new HashMap<String, String>();
		HeaderIterator iterator = response. headerIterator();
		
		while(iterator.hasNext()){
			
			Header header = (Header)iterator.next();
			headerMap.put(header.getName(), header.getValue());
		}
		
		return headerMap;
	}

/**
 * returns the responce text (payload) from the http responce
 * @return
 * @throws IllegalStateException
 * @throws IOException
 */
	public String getResponseText() throws IllegalStateException, IOException{
	if(responseText == null){
		HttpEntity responseEntity = response.getEntity();
		if (responseEntity != null) {
			InputStream instream = responseEntity.getContent();
			 responseText = com.peterbilberg.utillities.BacicUtillities.convertStreamToString(instream);	
			} 
	}
	  return responseText;
	}
	@Override
	public String toString(){
		StringBuilder value = new StringBuilder();
		value.append("ContentTypeValue = "+this.getHttpHeaderContentTypeValue()+"\r\n");
		value.append("Server = "+this.getHttpHeaderServer()+"\r\n");
		value.append("TransferEncoding = "+this.getHttpHeaderTransferEncoding()+"\r\n");
		value.append("Protocol = "+this.getProtocol()+"\r\n");
		value.append("StatusCode = "+this.getStatusCode()+"\r\n");
		value.append("StatusLinie = "+this.getStatusLinie()+"\r\n");
		value.append("\r\n");
		try {
			value.append("ResponseText = "+this.getResponseText()+"\r\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		
		return value.toString();
	}

    /**
     * @return the exception
     */
    public Exception getException() {
        return exception;
    }

    /**
     * @param exception the exception to set
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }


	}
	
	
	

