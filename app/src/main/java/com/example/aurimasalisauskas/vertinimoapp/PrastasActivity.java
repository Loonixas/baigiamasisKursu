package com.example.aurimasalisauskas.vertinimoapp;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class PrastasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.prastas_activity);

        final CheckBox c1 = findViewById(R.id.checkBox);
        final CheckBox c2 = findViewById(R.id.checkBox2);
        final CheckBox c3 = findViewById(R.id.checkBox3);
        final CheckBox c4 = findViewById(R.id.checkBox4);
        final CheckBox c5 = findViewById(R.id.checkBox5);
        Button button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = getIntent().getExtras();
                int pasirinkimas = b.getInt("pasirinkimas");

                Ivertinimas ivertinimas = new Ivertinimas();
                ivertinimas.setPasirinkimas(pasirinkimas);
                if (c1.isChecked()) {
                    ivertinimas.getTrukumai().add("1");
                } else {
                    ivertinimas.getTrukumai().add("0");
                }
                if (c2.isChecked()) {
                    ivertinimas.getTrukumai().add("1");
                } else {
                    ivertinimas.getTrukumai().add("0");
                }
                if (c3.isChecked()) {
                    ivertinimas.getTrukumai().add("1");
                } else {
                    ivertinimas.getTrukumai().add("0");
                }
                if (c4.isChecked()) {
                    ivertinimas.getTrukumai().add("1");
                } else {
                    ivertinimas.getTrukumai().add("0");
                }
                if (c5.isChecked()) {
                    ivertinimas.getTrukumai().add("1");
                } else {
                    ivertinimas.getTrukumai().add("0");
                }
                Database.add(ivertinimas);
                finish();

            }
        });


    }
}
