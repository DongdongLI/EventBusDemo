package com.example.lidon.eventbusdemo;

/**
 * Created by lidon on 11/14/2015.
 */
public class ChargingEvent {

    private String data;

    public ChargingEvent(String data){
        this.data=data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
