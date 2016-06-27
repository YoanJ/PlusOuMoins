package com.example.yoan.plusoumoins;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    private EditText initValue, incremValue, maxValue, minValue;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final SharedPreferences sharedPreferences = getSharedPreferences(Keys.getPrefName(),
                Context.MODE_PRIVATE);

        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final long initPref = sharedPreferences.getLong(Keys.getINIT(), Keys.getInitDef());
        final long incremPref = sharedPreferences.getLong(Keys.getINCREM(), Keys.getIncremDef());
        final long maxPref = sharedPreferences.getLong(Keys.getMAX(), Keys.getMaxDef());
        final long minPref = sharedPreferences.getLong(Keys.getMIN(), Keys.getMinDef());

        //set UI components
        initValue = (EditText) findViewById(R.id.editTextInit);
        incremValue = (EditText) findViewById(R.id.editTextIncrem);
        maxValue = (EditText) findViewById(R.id.editTextMax);
        minValue = (EditText) findViewById(R.id.editTextMin);
        button = (Button) findViewById(R.id.buttonOK);

        //get values
        initValue.setText(String.valueOf(initPref));
        incremValue.setText(String.valueOf(incremPref));
        maxValue.setText(String.valueOf(maxPref));
        minValue.setText(String.valueOf(minPref));

        //listeners
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean changed = false;
                //update pref fields
                if(Long.valueOf(initValue.getText().toString()) != initPref){
                    editor.putLong(Keys.getINIT(), Long.valueOf(initValue.getText().toString()));
                    changed = true;
                }
                if(Long.valueOf(incremValue.getText().toString()) != incremPref){
                    editor.putLong(Keys.getINCREM(), Long.valueOf(incremValue.getText().toString()));
                    changed = true;
                }
                if(Long.valueOf(maxValue.getText().toString()) != maxPref){
                    editor.putLong(Keys.getMAX(), Long.valueOf(maxValue.getText().toString()));
                    changed = true;
                }
                if(Long.valueOf(minValue.getText().toString()) != minPref){
                    editor.putLong(Keys.getMIN(), Long.valueOf(minValue.getText().toString()));
                    changed = true;
                }

                editor.apply();

                SettingsActivity.this.finish();
            }
        });
    }
}
