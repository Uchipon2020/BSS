package com.timeshappy.scoresheet;
//make20201030_1
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MemberMenu extends AppCompatActivity {


    Intent intent = new Intent();
    Button btm_r1,btm_r2,btm_r3,btm_r4,btm_r5;
    Button btm_b1,btm_b2,btm_b3,btm_b4,btm_b5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_menu);

        btm_r1 = findViewById(R.id.red_1);
        btm_r2 = findViewById(R.id.red_2);
        btm_r3 = findViewById(R.id.red_3);
        btm_r4 = findViewById(R.id.red_4);
        btm_r5 = findViewById(R.id.red_5);


        btm_b1 = findViewById(R.id.blue_1);
        btm_b2 = findViewById(R.id.blue_2);
        btm_b3 = findViewById(R.id.blue_3);
        btm_b4 = findViewById(R.id.blue_4);
        btm_b5 = findViewById(R.id.blue_5);



        btm_r1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
             Item.numberT = "赤4";
                setResult(RESULT_OK,intent);
             finish();
            }

        });
        btm_r2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Item.numberT = "赤5";
                setResult(RESULT_OK,intent);
                finish();
            }

        });
        btm_r3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Item.numberT = "赤6";
                setResult(RESULT_OK,intent);
                finish();
            }

        });
        btm_r4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Item.numberT = "赤7";
                setResult(RESULT_OK,intent);
                finish();
            }

        });
        btm_r5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Item.numberT = "赤8";
                setResult(RESULT_OK,intent);
                finish();
            }

        });
        btm_b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Item.numberT = "青４";
                setResult(RESULT_OK,intent);
                finish();
            }

        });
        btm_b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Item.numberT = "青５";
                setResult(RESULT_OK,intent);
                finish();
            }

        });
        btm_b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Item.numberT = "青６";
                setResult(RESULT_OK,intent);
                finish();
            }

        }); btm_b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Item.numberT = "青７";
                setResult(RESULT_OK,intent);
                finish();
            }

        }); btm_b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Item.numberT = "青８";
                setResult(RESULT_OK,intent);
                finish();
            }

        });






}
}