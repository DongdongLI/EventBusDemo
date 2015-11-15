package com.example.lidon.eventbusdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.format.Time;

import de.greenrobot.event.EventBus;

/**
 * Created by lidon on 11/14/2015.
 */
public class Receiver extends BroadcastReceiver{

    private EventBus bus=EventBus.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {
        Event event=null;

        Time time=new Time();
        time.setToNow();
        String timeOfEvent=time.format("%H:%M:%S");

        String eventData="@"+timeOfEvent+" this device started";
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            event=new Event(eventData+" Charging");
        }else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            event=new Event(eventData+" discharging");
        }


        bus.post(event);
    }
}
