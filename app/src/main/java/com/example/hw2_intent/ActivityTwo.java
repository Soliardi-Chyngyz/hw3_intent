package com.example.hw2_intent;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityTwo extends AppCompatActivity {

    public final static String SUPER_KEY = "number";


    public TextView textView2, txtResult;
    private EditText count1, count2;
    private Button btnSendToMain;
    double sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        init();

        btnSendToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double c1 = Double.parseDouble(count1.getText().toString());
                double c2 = Double.parseDouble(count2.getText().toString());
                sum = c1 + c2;
                String s = Double.toString(sum);
                txtResult.setText(s);
//                double a,b,c;

//                String S1 = count1.getText().toString();
//                String S2 = count2.getText().toString();
//
//                a = Double.parseDouble(S1);
//                b = Double.parseDouble(S2);
//                c = a + b;
//                String S = Double.toString(c);
//                txtResult.setText(S);
                sendResult();            }
        });
    }

    private void init(){
        textView2 = findViewById(R.id.textView2);
        count1 = findViewById(R.id.count1);
        count2 = findViewById(R.id.count2);
        btnSendToMain = findViewById(R.id.btnSendToMain);
        txtResult = (TextView) findViewById(R.id.txt_result);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("sum", txtResult.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        txtResult.setText(savedInstanceState.getString("sum"));
    }

    public void sendResult() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(SUPER_KEY, txtResult.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}

