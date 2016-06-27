package com.example.yoan.plusoumoins;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button buttMinus, buttPlus, buttSettings;
    private TextView textView;
    private long value, initPref, incremPref, maxPref, minPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init UI components
        buttMinus = (Button) findViewById(R.id.buttonMinus);
        buttPlus = (Button) findViewById(R.id.buttonPlus);
        buttSettings = (Button) findViewById(R.id.buttonSettings);
        textView = (TextView) findViewById(R.id.textView);

        initValue();

    }
    @Override
    protected void onResume(){
        super.onResume();
        initValue();
    }

    private void initValue() {
        SharedPreferences sharedPreferences = getSharedPreferences(Keys.getPrefName(),
                Context.MODE_PRIVATE);

        initPref = sharedPreferences.getLong(Keys.getINIT(), Keys.getInitDef());
        incremPref = sharedPreferences.getLong(Keys.getINCREM(), Keys.getIncremDef());
        maxPref = sharedPreferences.getLong(Keys.getMAX(), Keys.getMaxDef());
        minPref = sharedPreferences.getLong(Keys.getMIN(), Keys.getMinDef());

        //set default text
        textView.setText(String.valueOf(initPref));
        value = initPref;

        //onClick
        buttMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value - incremPref <= minPref){
                    value = minPref;
                }
                else{
                    value = value - incremPref;
                }
                textView.setText(String.valueOf(value));
            }
        });
        buttPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value + incremPref >= maxPref){
                    value = maxPref;
                }
                else{
                    value = value + incremPref;
                }
                textView.setText(String.valueOf(value));
            }
        });
        //settings
        buttSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
