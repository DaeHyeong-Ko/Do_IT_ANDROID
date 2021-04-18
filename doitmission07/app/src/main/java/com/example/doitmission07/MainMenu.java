package com.example.doitmission07;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {
    public static final int ANSWER_CODE = 200;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);

        Intent reciever = getIntent();
        String message = reciever.getStringExtra("login messege");

        Toast.makeText(this.getApplicationContext(),message,Toast.LENGTH_SHORT).show();

        Button customerManagingButton = (Button) findViewById(R.id.customerManagingButton);
        Button benefitManagingButton = (Button) findViewById(R.id.benefitManagingButton);
        Button productManagingButton = (Button) findViewById(R.id.productManagingButton);

        customerManagingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("menu","고객 관리");
                intent.putExtra("message","result message is Ok!");
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        benefitManagingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("menu","매출 관리");
                intent.putExtra("message","result message is Ok!");
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        productManagingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("menu","상품 관리");
                intent.putExtra("message","result message is Ok!");
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

}
