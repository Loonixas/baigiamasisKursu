package com.example.aurimasalisauskas.vertinimoapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.os.Environment;

import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    public static final int PRASTAS_ACTIVITY_RESULT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button mygtukas1 = findViewById(R.id.mygtukoId1);
        mygtukas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Kas lėmė tokį Jūsų pasirinkimą?", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, PrastasActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("pasirinkimas", 1);
                intent.putExtras(bundle);
                startActivityForResult(intent, PRASTAS_ACTIVITY_RESULT);
            }
        });

        Button mygtukas2 = findViewById(R.id.mygtukoId2);
        mygtukas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Kas lėmė tokį Jūsų pasirinkimą?", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, PrastasActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("pasirinkimas", 2);
                intent.putExtras(bundle);
                startActivityForResult(intent, PRASTAS_ACTIVITY_RESULT);

            }
        });

        Button mygtukas3 = findViewById(R.id.mygtukoId3);
        mygtukas3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Kas lėmė tokį Jūsų pasirinkimą?", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, PrastasActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("pasirinkimas", 3);
                intent.putExtras(bundle);
                startActivityForResult(intent, PRASTAS_ACTIVITY_RESULT);

            }
        });

        Button mygtukas4 = findViewById(R.id.mygtukoId4);
        mygtukas4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Kas lėmė tokį Jūsų pasirinkimą?", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, PrastasActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("pasirinkimas", 4);
                intent.putExtras(bundle);
                startActivityForResult(intent, PRASTAS_ACTIVITY_RESULT);

            }
        });

        Button mygtukas5 = findViewById(R.id.mygtukoId5);
        mygtukas5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ivertinimas ivertinimas = new Ivertinimas();
                ivertinimas.setPasirinkimas(5);
                Database.add(ivertinimas);
                Toast toast = Toast.makeText(MainActivity.this, "Ačiū už puikų įvertinimą", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 30);
                toast.show();
            }
        });

        findViewById(R.id.picture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                for (Ivertinimas ivertinimas : Database.getIvertinimai()) {
//                    Log.d("IVERTINIMAI", "Ivertinimas: " + ivertinimas.getPasirinkimas() + ", Trukumai: " + ivertinimas.getTrukumai());
//                }
                try {
                    File sdCard = Environment.getExternalStorageDirectory();
                    File dir = new File(sdCard.getAbsolutePath() + "/saugykla");
                    Log.d("kelias", dir.getAbsolutePath());
                    dir.mkdirs();
                    File file = new File(dir, "rezultatai.txt");
                    if (!file.exists()) {
                        file.createNewFile();
                        FileWriter writer = new FileWriter(file);
                        writer.write("Rezultatai:" + "\n\r");
                        for (Ivertinimas ivertinimas : Database.getIvertinimai()) {
                            writer.append("Ivertinimas: " + ivertinimas.getPasirinkimas() + ", Trukumai: " + ivertinimas.getTrukumai() + "\n\r");
                            Log.d("IVERTINIMAI", "Ivertinimas: " + ivertinimas.getPasirinkimas() + ", Trukumai: " + ivertinimas.getTrukumai());
                        }
                        writer.flush();
                        writer.close();
                    }
                } catch (IOException e) {
                }
                String filename = "rezultatai.txt";
                File filelocation = new File(Environment.getDownloadCacheDirectory().getAbsolutePath(),filename);
                Uri path = Uri.fromFile(filelocation);
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent .setType("vnd.android.cursor.dir/email");
                String to[] = {"loonixas@gmail.com"};
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
    }
}
