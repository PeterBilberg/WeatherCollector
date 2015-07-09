/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.weather.dal.openWeatherMapApi.model;

/**
 *
 * @author pbi
 */
public class Sys {

    private int type;
    private int id;
    private double message;
    private String country;
    private long sunrise;
    private long sunset;

    public Sys() {

    }

    /**
     * @return the message
     */
    public double getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(double message) {
        this.message = message;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the sunrise
     */
    public long getSunrise() {
        return sunrise;
    }

    /**
     * @param sunrise the sunrise to set
     */
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * @return the sunset
     */
    public long getSunset() {
        return sunset;
    }

    /**
     * @param sunset the sunset to set
     */
    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

}
