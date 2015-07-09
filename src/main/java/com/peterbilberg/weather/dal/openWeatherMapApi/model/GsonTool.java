/*
 * OpenWeatherMap use numers in element names. 
 * Gson tool fix this problem -Java can not handle numbers in varable names
 */
package com.peterbilberg.weather.dal.openWeatherMapApi.model;

import com.google.gson.Gson;

/**
 *
 * @author pbi
 */
public class GsonTool {

    private Gson gson = new Gson();

    private static GsonTool instance = new GsonTool();

    private GsonTool() {

    }

    public static GsonTool getinstance() {
        return instance;
    }

    public Observation fromJsonToObservationObject(String jsonText) {
        //need to handle element names in json with numbers not allowed in java 
        String text = jsonText.replace("\"1h\":", "\"oneH\":");
        text = text.replace("\"2h\":", "\"twoH\":");
        text = text.replace("\"3h\":", "\"threeH\":");
        text = text.replace("\"4h\":", "\"fourH\":");
        text = text.replace("\"5h\":", "\"fiveH\":");
        text = text.replace("\"6h\":", "\"sixH\":");
        text = text.replace("\"7h\":", "\"sevenH\":");
        text = text.replace("\"8h\":", "\"eightH\":");
        text = text.replace("\"9h\":", "\"nineH\":");
        text = text.replace("\"10h\":", "\"tenH\":");
        text = text.replace("\"11h\":", "\"elevenH\":");
        text = text.replace("\"12h\":", "\"twelveH\":");
        text = text.replace("\"13h\":", "\"thirteenH\":");
        text = text.replace("\"14h\":", "\"fourteenH\":");
        text = text.replace("\"15h\":", "\"fifteenH\":");
        text = text.replace("\"16h\":", "\"sixteenH\":");
        text = text.replace("\"17h\":", "\"seventeenH\":");
        text = text.replace("\"18h\":", "\"eighteenH\":");
        text = text.replace("\"19h\":", "\"nineteenH\":");
        text = text.replace("\"21h\":", "\"twentyH\":");
        text = text.replace("\"21h\":", "\"twenty_oneH\":");
        text = text.replace("\"22h\":", "\"twenty_twoH\":");
        text = text.replace("\"23h\":", "\"twenty_threeH\":");
        text = text.replace("\"24h\":", "\"twenty_fourH\":");
        Observation observation = (Observation) gson.fromJson(text, Observation.class);
        return observation;
    }

    public String fromObservationObjectToJsonString(Observation observation) {
        //need to handle element names in json with numbers not allowed in java 
        String text = gson.toJson(observation);

        if (text.contains(",\"oneH\":0.0")) {
            text = text.replace(",\"oneH\":0.0", "");
        } else {
            text = text.replace("\"oneH\":", "\"1h\":");
        }
        if (text.contains(",\"twoH\":0.0")) {
            text = text.replace(",\"twoH\":0.0", "");
        } else {
            text = text.replace("\"twoH\":", "\"2h\":");
        }
        if (text.contains(",\"threeH\":0.0")) {
            text = text.replace(",\"threeH\":0.0", "");
        } else {
            text = text.replace("\"threeH\":", "\"3h\":");
        }

        if (text.contains(",\"fourH\":0.0")) {
            text = text.replace(",\"fourH\":0.0", "");
        } else {
            text = text.replace("\"fourH\":", "\"4h\":");
        }

        if (text.contains(",\"fiveH\":0.0")) {
            text = text.replace(",\"fiveH\":0.0", "");
        } else {
            text = text.replace("\"fiveH\":", "\"5h\":");
        }
        if (text.contains(",\"sixH\":0.0")) {
            text = text.replace(",\"sixH\":0.0", "");
        } else {
            text = text.replace("\"sixH\":", "\"6h\":");
        }
        if (text.contains(",\"sevenH\":0.0")) {
            text = text.replace(",\"sevenH\":0.0", "");
        } else {
            text = text.replace("\"sevenH\":", "\"7h\":");
        }
        if (text.contains(",\"eightH\":0.0")) {
            text = text.replace(",\"eightH\":0.0", "");
        } else {
            text = text.replace("\"eightH\":", "\"8h\":");
        }
        if (text.contains(",\"nineH\":0.0")) {
            text = text.replace(",\"nineH\":0.0", "");
        } else {
            text = text.replace("\"nineH\":", "\"9h\":");
        }
        if (text.contains(",\"tenH\":0.0")) {
            text = text.replace(",\"tenH\":0.0", "");
        } else {
            text = text.replace("\"tenH\":", "\"10h\":");
        }
        if (text.contains(",\"elevenH\":0.0")) {
            text = text.replace(",\"elevenH\":0.0", "");
        } else {
            text = text.replace("\"elevenH\":", "\"11h\":");
        }
        if (text.contains(",\"twelveH\":0.0")) {
            text = text.replace(",\"twelveH\":0.0", "");
        } else {
            text = text.replace("\"twelveH\":", "\"12h\":");
        }
        if (text.contains(",\"thirteenH\":0.0")) {
            text = text.replace(",\"thirteenH\":0.0", "");
        } else {
            text = text.replace("\"thirteenH\":", "\"13h\":");
        }
        if (text.contains(",\"fourteenH\":0.0")) {
            text = text.replace(",\"fourteenH\":0.0", "");
        } else {
            text = text.replace("\"fourteenH\":", "\"14h\":");
        }
        if (text.contains(",\"fifteenH\":0.0")) {
            text = text.replace(",\"fifteenH\":0.0", "");
        } else {
            text = text.replace("\"fifteenH\":", "\"15h\":");
        }
        if (text.contains(",\"sixteenH\":0.0")) {
            text = text.replace(",\"sixteenH\":0.0", "");
        } else {
            text = text.replace("\"sixteenH\":", "\"16h\":");
        }
        if (text.contains(",\"seventeenH\":0.0")) {
            text = text.replace(",\"seventeenH\":0.0", "");
        } else {
            text = text.replace("\"seventeenH\":", "\"17h\":");
        }
        if (text.contains(",\"eighteenH\":0.0")) {
            text = text.replace(",\"eighteenH\":0.0", "");
        } else {
            text = text.replace("\"eighteenH\":", "\"18h\":");
        }
        if (text.contains(",\"nineteenH\":0.0")) {
            text = text.replace(",\"nineteenH\":0.0", "");
        } else {
            text = text.replace("\"nineteenH\":", "\"19h\":");
        }
        if (text.contains(",\"twentyH\":0.0")) {
            text = text.replace(",\"twentyH\":0.0", "");
        } else {
            text = text.replace("\"twentyH\":", "\"21h\":");
        }
        if (text.contains(",\"twenty_oneH\":0.0")) {
            text = text.replace(",\"twenty_oneH\":0.0", "");
        } else {
            text = text.replace("\"twenty_oneH\":", "\"21h\":");
        }
        if (text.contains(",\"twenty_twoH\":0.0")) {
            text = text.replace(",\"twenty_twoH\":0.0", "");
        } else {
            text = text.replace("\"twenty_twoH\":", "\"22h\":");
        }
        if (text.contains(",\"twenty_threeH\":0.0")) {
            text = text.replace(",\"twenty_threeH\":0.0", "");
        } else {
            text = text.replace("\"twenty_threeH\":", "\"23h\":");
        }
        if (text.contains(",\"twenty_fourH\":0.0")) {
            text = text.replace(",\"twenty_fourH\":0.0", "");
        } else {
            text = text.replace("\"twenty_fourH\":", "\"24h\":");
        }

        return text;
    }

}
