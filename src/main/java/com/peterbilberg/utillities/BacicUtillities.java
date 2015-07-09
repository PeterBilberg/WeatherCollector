package com.peterbilberg.utillities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BacicUtillities {

	/**
	 * removes tabs and space from string
	 * 
	 * @param input
	 * @return
	 */
	public static String trimAll(String input) {
		StringBuilder out = new StringBuilder();
		String[] inputSplit = input.split("  ");

		for (String s : inputSplit) {
			String[] sSplit = s.split("\t");
			for (String split : sSplit) {
				if (split.length() > 0) {
					out.append(split);
				}
			}

		}
		return out.toString().trim();
	}

	/**
	 * simply converts a Inputstream into a string
	 * @param is
	 * @return
	 */
	public static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString().trim();
	}
	
	/**
	 * time as string yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String maketimeStamp(){
		 String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

		 
		    Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		 return sdf.format(cal.getTime());
		 

	}
	/**
	 * time as string yyyy-MM-dd 
	 * @return
	 */
	public static String makeDayStamp(){
		 String DATE_FORMAT_NOW = "yyyy-MM-dd";

		 
		    Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		 return sdf.format(cal.getTime());
		 

	}
        /**
         * dd-M-yyyy hh:mm:ss
         */
        public static String makeDateString() throws ParseException{
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	  return dateFormat.format(date);
        }

}
