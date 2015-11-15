package com.example.lidon.eventbusdemo;

/**
 * Created by lidon on 11/15/2015.
 */
public class WorkerEvent {
    private String data;

    public WorkerEvent(String data){
        this.data=data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
