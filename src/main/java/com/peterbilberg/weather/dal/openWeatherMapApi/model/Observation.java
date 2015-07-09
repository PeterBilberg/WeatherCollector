/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterbilberg.weather.dal.openWeatherMapApi.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pbi
 */
public class Observation {
    private Coord coord;
    private List<Weather> weather = new ArrayList<Weather>();
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Snow snow;
    private Clouds clouds;
    private int dt;
    private Sys sys;
    private int id;
    private String name;
    private int cod;
    
    public Observation(){
        
    }

    /**
     * @return the coord
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * @param coord the coord to set
     */
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    /**
     * @return the sys
     */
    public Sys getSys() {
        return sys;
    }

    /**
     * @param sys the sys to set
     */
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    /**
     * @return the weather
     */
    public List<Weather> getWeather() {
        return weather;
    }

    /**
     * @param weather the weather to set
     */
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
    
    public void addWeather(Weather weather) {
        this.weather.add(weather);
    }

    /**
     * @return the base
     */
    public String getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * @return the main
     */
    public Main getMain() {
        return main;
    }

    /**
     * @param main the main to set
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * @return the wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * @param wind the wind to set
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * @return the clouds
     */
    public Clouds getClouds() {
        return clouds;
    }

    /**
     * @param clouds the clouds to set
     */
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    /**
     * @return the dt
     */
    public int getDt() {
        return dt;
    }

    /**
     * @param dt the dt to set
     */
    public void setDt(int dt) {
        this.dt = dt;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }
    
}
