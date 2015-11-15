package com.example.lidon.eventbusdemo;

import de.greenrobot.event.EventBus;

/**
 * Created by lidon on 11/15/2015.
 */
public class WorkerThread implements Runnable{
    private EventBus bus=EventBus.getDefault();
    @Override
    public void run() {
        for(int i=0;i<100000;i++){
            int a=i*i;
        }
        bus.post(new WorkerEvent("Worker said: It's done"));
    }
}
