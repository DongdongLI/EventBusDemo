package com.example.lidon.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private EventBus bus=EventBus.getDefault();
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);

        textView.setTextSize(20f);
        textView.setText("Waiting for events... ");

        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        bus.unregister(this);
        super.onDestroy();
    }

    public void onEvent(ChargingEvent event){
        textView.setText(textView.getText()+"\n"+event.getData());
    }
}
