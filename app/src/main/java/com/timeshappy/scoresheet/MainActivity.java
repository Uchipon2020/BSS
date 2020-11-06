package com.timeshappy.scoresheet;
//make20201030_1
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //初期設定エリア
    Button btn_restart,btn_stop,btn_reset,btn_goal_a,btn_goal_b;
    TextView et_title_view,goal_a,goal_b;
    String et_teama,et_teamb,title_view,taa,tbb;
    ListView lv_item;

    private Timer timer;
    private CountUpTimerTask timerTask;
    private Handler handler = new Handler();
    private TextView timerText;
    private long count, delay, period, stopCount;
    private String zero;
    public CharSequence stopTime;

    ArrayAdapter<Item> itemArrayAdapter;
    DatabaseHelper databaseHelper ;
    //コンテキスト
    Item item = new Item(-1,null,0,0,0,
            0,0,null,null,
            0,0,null);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //タイマー初期設定
        delay = 0;
        period = 100;
        count = 4000;
        // "05:00.0"
        zero = getString(R.string.zero);
        timerText = findViewById(R.id.countView);
        timerText.setText(zero);

        //各ボタンセット---------------------------------------------------------------
        btn_restart = findViewById(R.id.btn_restart);
        btn_goal_a = findViewById(R.id.btn_goal_a);
        btn_goal_b = findViewById(R.id.btn_goal_b);
        btn_reset = findViewById(R.id.btn_reset);
        btn_stop = findViewById(R.id.btn_stop);
        lv_item = findViewById(R.id.lv_itemList);


        databaseHelper = new DatabaseHelper(MainActivity.this);

        ShowItemOnListView(databaseHelper);

        //前のページからのチーム名の引継ぎ-----------------------------------------------------
        Intent intent = getIntent();

        taa = intent.getStringExtra("ta");
        item.setTeama_name(taa);
        et_teama = item.getTeama_name();

        tbb = intent.getStringExtra("tb");
        item.setTeamb_name(tbb);
        et_teamb = item.getTeamb_name();

        title_view = (et_teama + "   対   " + et_teamb);
        et_title_view = findViewById(R.id.title_view);
        et_title_view.setText(title_view);

        //
        goal_a = findViewById(R.id.text_goal_a);
        goal_a.setText("0");
        goal_b = findViewById(R.id.text_goal_b);
        goal_b.setText("0");

        // タイマー開始--- タイマーが走っている最中にボタンをタップされたケース
        if (null != timer) {
            timer.cancel();
            timer = null;
        }
        timer = new Timer();
        timerTask = new CountUpTimerTask();
        timer.schedule(timerTask, delay, period);

      //Stop---------------------------------------------------------------------------------
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // timer がnullでない、起動しているときのみキャンセルする
                if (null != timer) {
                    // Cancel
                    stopCount = count;
                    stopTime = timerText.getText();
                    timer.cancel();
                    item.setCount_timer((String) stopTime);

                    Intent intent = new Intent(getApplication(), StopMenu.class);
                    startActivityForResult(intent, 1000);

                }
            }
        });
        //リスタートボタン-----------------------------------------------------------------------
        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // タイマーが走っている最中にボタンをタップされたケース
                if (null != timer) {
                    timer.cancel();
                    timer = null;

                    // Timerエリア
                    timer = new Timer();
                    timerTask = new CountUpTimerTask();
                    timer.schedule(timerTask, delay, period);
                    count = stopCount;
                    timerText.setText(stopTime);

                    Button btn = findViewById(R.id.btn_restart);
                    btn.setText("再　開");
                }
            }
        });
        //ゴールボタン A---------------------------------------------------------20201106 point
        btn_goal_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTime = timerText.getText();
                item.setCount_timer((String) stopTime);

                int i;
                i = item.getGoal_a() + 2;
                item.setGoal_a(i);
                String ii = String.valueOf(i);
                goal_a.setText(ii);

                ShowItemOnListView(databaseHelper);

                Toast.makeText(MainActivity.this, "ゴール！！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplication(), MemberMenu.class);
                startActivity(intent);
            }});


        //ゴールボタン Ｂ---------------------------------------------------------
        btn_goal_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopTime = timerText.getText();
                item.setCount_timer((String) stopTime);

                int i;
                i = item.getGoal_b() + 2;
                item.setGoal_b(i);
                String ii = String.valueOf(i);
                goal_b.setText(ii);

                ShowItemOnListView(databaseHelper);

                Toast.makeText(MainActivity.this, "ゴール！！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplication(), MemberMenu.class);
                startActivity(intent);
            }


        });


        //リセットボタン----------------------------------------------------------------
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerText = findViewById(R.id.countView);
                timerText.setText(zero);
                count = 40000;
            }
        });


        //アイテムを押して削除-----------------------------------------------------------------------

        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = (Item) parent.getItemAtPosition(position);

                Boolean success = databaseHelper.deleteOne(item);
                Toast.makeText(MainActivity.this,"DELETE" + success,Toast.LENGTH_SHORT).show();
                ShowItemOnListView(databaseHelper);//一覧表示用
            }
        });
    }


    //リストを再読み込みして最新のものを表示させるメソッド
   private void ShowItemOnListView(DatabaseHelper databaseHelper) {
        itemArrayAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                databaseHelper.getEveryone());
        lv_item.setAdapter(itemArrayAdapter);
    }
    //カウンター用処理------------------------------------------------------------------------
    class CountUpTimerTask extends TimerTask {
        @Override
    public void run() {
        // handlerを使って処理をキューイングする
        handler.post(new Runnable() {
            public void run() {
                if (count <= 0) {
                    return;
                }
                count-- ;//カウントダウン
                long mm = count * 100 / 1000 / 60;
                long ss = count * 100 / 1000 % 60;
                long ms = (count * 100 - ss * 1000 - mm * 1000 * 60) / 100;
                // 桁数を合わせるために02d(2桁)を設定
                timerText.setText(
                        String.format(Locale.US, "%1$02d:%2$02d.%3$01d", mm, ss, ms));
            }
        });
    }}
    @Override
    /////////save(戻ってきた）
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (RESULT_OK == resultCode) {
                String mFoul_name = data.getStringExtra("mFoul_name");
                item.setFoul_name(mFoul_name);
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                item.setNumber(Item.numberT);
                //save
                boolean success = databaseHelper.addOne(item);//保存作業
                item.setNumber(0);//保存したのでリセット
                Toast.makeText(MainActivity.this,"保存"+success,Toast.LENGTH_SHORT).show();

                ShowItemOnListView(databaseHelper);//一覧表示用
            }
        }
    }
}


