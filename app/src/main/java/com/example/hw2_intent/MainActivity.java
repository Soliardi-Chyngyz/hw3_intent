package com.example.hw2_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String SUPER_KEY = "txt";

    private TextView textView;
    private Button btnSend, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
//        getResult();   из-за него приложение выбрасывает едва открыв
    }

    private void getResult() {
        Intent intent = getIntent();
        if (intent != null){
            int number = intent.getIntExtra("Результат", Integer.parseInt(SUPER_KEY));
            textView.setText(number);
        }
    }

    public void init(){
        textView = findViewById(R.id.text_view);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataIntent();
            }
        });
        btnEmail = findViewById(R.id.btnEmail);
    }

    public void getDataIntent(){
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
    }

}