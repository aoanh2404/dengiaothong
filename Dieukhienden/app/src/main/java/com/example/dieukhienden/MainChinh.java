package com.example.dieukhienden;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainChinh extends AppCompatActivity {
Button btnbangtay,btntudong,btncanhbao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chinh);
        addcontrol();
        addevent();
    }

    private void addevent() {
        btnbangtay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainChinh.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addcontrol() {
        btnbangtay=findViewById(R.id.btnbangtay);
        btntudong=findViewById(R.id.btntudong);
        btncanhbao=findViewById(R.id.btncanhbao);
    }
}
