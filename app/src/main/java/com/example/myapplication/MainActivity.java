package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText editable;
    Button write, read;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editable =findViewById(R.id.edit);
        write = findViewById(R.id.write);
        read = findViewById(R.id.read);
        text = findViewById(R.id.text);


        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(openFileOutput("file",MODE_PRIVATE)));
            bufferedWriter.write("write something first");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(openFileOutput("file",MODE_PRIVATE)));
                    bufferedWriter.write(editable.getText().toString());
                    bufferedWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput ("file")));
                    String s;
                    while ((s = bufferedReader.readLine()) != null) {
                        text.setText(s.toString());
                    }
                    bufferedReader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}