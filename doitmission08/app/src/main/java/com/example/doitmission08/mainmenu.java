package com.example.doitmission08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.doitmission08.MainActivity.RESPOND_MAINMENU_CODE;

public class mainmenu extends AppCompatActivity {
    public static final int RESPOND_CUSTOMMER_CODE = 200;
    public static final int RESPOND_PRODUCT_CODE = 300;
    public static final int RESPOND_PROFIT_CODE = 400;
    public String access_customer = "Customer Access Complete!";
    public String access_product = "Product Access Complete!";
    public String access_profit = "Profit Access Complete!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);

        Intent receiveIntent = getIntent();
        String message = receiveIntent.getStringExtra("Access Complete");
        int code = receiveIntent.getIntExtra("respond_code",RESPOND_MAINMENU_CODE);

        Toast.makeText(mainmenu.this, message + "\n" + code , LENGTH_SHORT).show();

        Button btn1 = (Button) findViewById(R.id.detail_customer);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent btn1intent = new Intent(mainmenu.this, detailmenu.class);
                btn1intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                btn1intent.putExtra("access_customer",access_customer);
                btn1intent.putExtra("Customer Code",RESPOND_CUSTOMMER_CODE);
                startActivityForResult(btn1intent, RESPOND_CUSTOMMER_CODE);
            }});

        Button btn2 = (Button) findViewById(R.id.detail_profit);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent btn2intent = new Intent(mainmenu.this, detailmenu.class);
                btn2intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                btn2intent.putExtra("access_product",access_product);
                btn2intent.putExtra("Product Code",RESPOND_PRODUCT_CODE);
                startActivityForResult(btn2intent, RESPOND_PRODUCT_CODE);
            }});

        Button btn3 = (Button) findViewById(R.id.detail_merchandise);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent btn3intent = new Intent(mainmenu.this, detailmenu.class);
                btn3intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                btn3intent.putExtra("access_customer",access_profit);
                btn3intent.putExtra("Profit Code",RESPOND_PROFIT_CODE);
                startActivityForResult(btn3intent, RESPOND_PROFIT_CODE);
            }});
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (intent != null){
            String resultString = intent.getStringExtra("menu");
            if(resultCode == -1){
                if (requestCode == RESPOND_CUSTOMMER_CODE) {
                    Toast.makeText(mainmenu.this,"Result OK = " + resultCode + "\n" + "menu : " +  resultString,LENGTH_SHORT).show();
                } else if (requestCode == RESPOND_PRODUCT_CODE) {
                    Toast.makeText(mainmenu.this,"Result OK = " + resultCode + "\n" + "menu : " +  resultString,LENGTH_SHORT).show();
                } else{
                    Toast.makeText(mainmenu.this,"Result OK = " + resultCode + "\n" + "menu : " +  resultString,LENGTH_SHORT).show();
                }
            } else {
                Intent intentTologin = new Intent(mainmenu.this,MainActivity.class);
                intentTologin.putExtra("comeback to login",resultCode);
                setResult(resultCode,intentTologin);
                finish();
            }
            return;
        }
    }
}