package yudistirosaputro.gmail.com.pertemuan4.pertemuan6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import yudistirosaputro.gmail.com.pertemuan4.R;

public class Pertemuan6 extends AppCompatActivity {

    Button buttonStop,buttonStart;
    TextView textViewBatteraiLevel;
    ProgressBar progressBar;
    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertemuan6);
        buttonStart = findViewById(R.id.button_start);
        buttonStop = findViewById(R.id.button_stop);

        textViewBatteraiLevel = findViewById(R.id.textViewBateraiLevel);
        progressBar = findViewById(R.id.progressBar3);
        broadcastReceiver = new BatteryBroadcastReceiver();

    }
    public void playAudio(View view){
        Intent objIntent = new Intent(this,PlayAudio.class);
        startService(objIntent);
    }

    public void stopAudio(View view){
        Intent objIntent = new Intent(this,PlayAudio.class);
        stopService(objIntent);
    }

    @Override
    protected void onStart() {

        registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(broadcastReceiver);
        super.onStop();
    }

    private class BatteryBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            textViewBatteraiLevel.setText("Batterai level " + level );
            progressBar.setProgress(level);
        }
    }
}
