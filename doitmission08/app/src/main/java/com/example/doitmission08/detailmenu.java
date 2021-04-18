package com.example.doitmission08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.doitmission08.mainmenu.RESPOND_CUSTOMMER_CODE;
import static com.example.doitmission08.mainmenu.RESPOND_PRODUCT_CODE;
import static com.example.doitmission08.mainmenu.RESPOND_PROFIT_CODE;

public class detailmenu extends AppCompatActivity {
    private TextView detail_menu_title;
    public String string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailmenu);

        Intent receiveIntent = new Intent(this.getIntent());
        int customercode = receiveIntent.getIntExtra("Customer Code", 0);
        int productcode = receiveIntent.getIntExtra("Product Code", 0);
        int profitcode = receiveIntent.getIntExtra("Profit Code", 0);

        detail_menu_title = (TextView) findViewById(R.id.detail_menu);

        if (customercode == RESPOND_CUSTOMMER_CODE) {
            detail_menu_title.setText("고객 관리");
            string = "고객 관리";
        } else if (productcode == RESPOND_PRODUCT_CODE) {
            detail_menu_title.setText("매출 관리");
            string = "매출 관리";
        } else {
            detail_menu_title.setText("상품 관리");
            string = "상품 관리";
        }

        Button btn1detail = (Button) findViewById(R.id.comeback_menu);
        Button btn2detail = (Button) findViewById(R.id.comeback_login);

        btn1detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(detailmenu.this, mainmenu.class);
                intent1.putExtra("menu", string);
                setResult(Activity.RESULT_OK, intent1);
                finish();
            }
        });

        btn2detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("menu", string);
                setResult(100, intent2);
                finish();
            }
        });

    }
}
