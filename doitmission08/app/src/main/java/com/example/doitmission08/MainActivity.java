package com.example.doitmission08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    public EditText idInput, passwordInput;
    public String idInputdata, passwordInputdata;
    public static final int RESPOND_MAINMENU_CODE = 100;
    public String access_complete = "Main Menu Access Complete!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idInput = (EditText) findViewById(R.id.id);
        passwordInput = (EditText) findViewById(R.id.password);

        Button button = (Button) findViewById(R.id.login_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idInputdata = idInput.getText().toString();
                passwordInputdata = passwordInput.getText().toString();

                if (idInputdata.length() == 0 && passwordInputdata.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please input your ID & PASSWORD", Toast.LENGTH_SHORT).show();
                } else if (idInputdata.length() != 0 && passwordInputdata.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please input your PASSWORD", Toast.LENGTH_SHORT).show();
                } else if (idInputdata.length() == 0 && passwordInputdata.length() != 0) {
                    Toast.makeText(getApplicationContext(), "Please input your ID", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, mainmenu.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    intent.putExtra("Access Complete", access_complete);
                    intent.putExtra("respond_code", RESPOND_MAINMENU_CODE);
                    startActivityForResult(intent, RESPOND_MAINMENU_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (intent != null) {
            int resultString = intent.getIntExtra("comeback to login",0);
            if (requestCode == RESPOND_MAINMENU_CODE) {
                Toast.makeText(MainActivity.this, "Result OK = " + resultCode + "\n" + "menu : " + resultString, LENGTH_SHORT).show();
            }
        }
    }
}