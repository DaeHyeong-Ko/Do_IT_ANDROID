package com.example.doitmission04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button transFerbutton;
    public Button closEbutton;
    public EditText inputController;
    public Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transFerbutton = (Button) findViewById(R.id.transFerbutton);
        inputController = (EditText) findViewById(R.id.inputbox);
        closEbutton = (Button) findViewById(R.id.closebox);

        transFerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String disPlay = inputController.getText().toString();
                toast = Toast.makeText(MainActivity.this, disPlay + " 전송합니다", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        closEbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDestroy();
            }
        });
    }
}