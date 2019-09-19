package com.hly.handler;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler(this);
        handler.sendEmptyMessageDelayed(1, 10 * 1000);


    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 1:
                startActivity(new Intent(MainActivity.this, OfferActivity.class));
                break;
        }
        return false;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler = null;
        }
    }


}
