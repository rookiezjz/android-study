package com.zjz.demo.exp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zjz.demo.HomeActivity;
import com.zjz.demo.R;

public class ShowPowerActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout r;
    TextView showpower, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showpower_layout);

        r = (RelativeLayout)findViewById(R.id.relative_showpower);
        r.setOnClickListener(this);

        showpower = (TextView)findViewById(R.id.tv_showpower);
        showpower.setOnClickListener(this);

        back = (TextView)findViewById(R.id.back4_btn);
        back.setOnClickListener(this);

    }

    class BatteryBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){

                int level = intent.getIntExtra("level", 0);
                int scale = intent.getIntExtra("scale", 100);
                int percent = level * 100 / scale;
                showpower.setText(""+percent+"%");
            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.relative_showpower : {
                registerReceiver(new ShowPowerActivity.BatteryBroadcastReceiver(), new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
                break;
            }
            case R.id.tv_showpower: {
                registerReceiver(new ShowPowerActivity.BatteryBroadcastReceiver(), new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
                break;
            }
            case R.id.back4_btn:{
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            }
        }
    }
}
