package com.timeshappy.scoresheet;
//make20201030_1

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StopMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_menu);

        final Button foul,out_of_bounds,member_change,time_out,cancel,violation,referee_time;

        foul            = findViewById(R.id.btn_foul);
        out_of_bounds   = findViewById(R.id.btn_oob);
        member_change   = findViewById(R.id.btn_menber);
        time_out        = findViewById(R.id.btn_timeout);
        violation       = findViewById(R.id.btn_vaioltion);
        cancel          = findViewById(R.id.btn_cancel);
        referee_time    = findViewById(R.id.btn_refelytime);

        final Intent intent = new Intent();

        //ファール
        foul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mIntent = intent.putExtra("mFoul_name", "ファール");
                setResult(RESULT_OK,mIntent);
                Intent intent = new Intent(getApplication(), MemberMenu.class);
                startActivity(intent);
                finish();
            }
        });

        //タイムアウト
        time_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = intent.putExtra("mFoul_name", "タイムアウト");
                setResult(RESULT_OK,mIntent);

                finish();
            }
        });

        //メンバーチェンジ
        member_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = intent.putExtra("mFoul_name", "メンバーチェンジ");
                setResult(RESULT_OK,mIntent);
                finish();
            }
        });

        //ヴァイオレーション
       violation.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent mIntent = intent.putExtra("mFoul_name", "バイオレーション");
               setResult(RESULT_OK,mIntent);

               finish();

           }
       });

        //キャンセル
       cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();

           }
       });


        //アウトオブバウンズ
        out_of_bounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = intent.putExtra("mFoul_name", "アウトオブバウンズ");
                setResult(RESULT_OK,mIntent);
                finish();

            }
        });




        //レフェリータイム
        referee_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = intent.putExtra("mFoul_name", "レフェリータイム");
                setResult(RESULT_OK,mIntent);

                finish();

            }
        });


    }
}