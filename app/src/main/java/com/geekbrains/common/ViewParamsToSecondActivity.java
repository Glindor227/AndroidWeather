package com.geekbrains.common;

import java.io.Serializable;

public class ViewParamsToSecondActivity implements Serializable {
    private String cityName;
    private boolean enableHum;
    private boolean enableOvercast;
    private boolean enableWind;
    private boolean enablePressure;


    public ViewParamsToSecondActivity(String cityName, boolean enableHum, boolean enableOvercast, boolean enableWind, boolean enablePressure) {
        this.cityName = cityName;
        this.enableHum = enableHum;
        this.enableOvercast = enableOvercast;
        this.enableWind = enableWind;
        this.enablePressure = enablePressure;
    }

    public String getCityName() {
        return cityName;
    }

    public boolean isEnableHum() {
        return enableHum;
    }

    public boolean isEnableOvercast() {
        return enableOvercast;
    }

    public boolean isEnableWind() {
        return enableWind;
    }

    public boolean isEnablePressure() {
        return enablePressure;
    }
}
