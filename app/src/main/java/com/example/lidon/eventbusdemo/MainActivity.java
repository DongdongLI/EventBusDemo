package com.example.lidon.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private EventBus bus=EventBus.getDefault();
    private TextView textView;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);
        btn=(Button)findViewById(R.id.button);

        textView.setTextSize(20f);
        textView.setText("Waiting for events... ");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bus.post(new Event("What a great day!"));
            }
        });

        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        bus.unregister(this);
        super.onDestroy();
    }

    public void onEvent(Event event){
        textView.setText(textView.getText()+"\n"+event.getData());
        Toast.makeText(getApplicationContext(),event.getData(),Toast.LENGTH_SHORT).show();
    }
}
