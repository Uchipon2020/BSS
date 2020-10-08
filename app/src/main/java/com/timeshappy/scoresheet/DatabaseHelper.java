package com.timeshappy.scoresheet;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

class DatabaseHelper  extends SQLiteOpenHelper {

    public static final String SCORE = "score";//テーブル名
    public static final String COLUMN_ID = "id";//通しID
    public static final String COLUMN_COUNT_TIMER = "count_timer";//タイマーの記録用
    public static final String COLUMN_PLAYER_NO = "player_No";//プレーヤーの記録用
    public static final String COLUMN_FOUL_NAME = "foul_name";//イベント名の記録用
    public static final String COLUMN_GOAL_TEAM_A = "goal_team_a";//Aチームの得点記録
    public static final String COLUMN_GOAL_TEAM_B = "goal_team_b";//Bチームの得点記録
    public static final String COLUMN_DATE = "date";//試合日
    public static final String COLUMN_QUARTER = "quarter";//クウォーター数

    public DatabaseHelper(Context context) {
        super(context, "score_sheet.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_data = "CREATE TABLE " + SCORE +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_DATE + " TEXT,"
                + COLUMN_COUNT_TIMER + " TEXT,"
                + COLUMN_PLAYER_NO + " TEXT,"
                + COLUMN_FOUL_NAME + " TEXT,"
                + COLUMN_GOAL_TEAM_A + " TEXT,"
                + COLUMN_GOAL_TEAM_B + " TEXT,"
                + COLUMN_QUARTER + " TEXT )";

         db.execSQL(create_data);//テーブル作成実行
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(Item item) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_COUNT_TIMER, item.getCount_timer());
        cv.put(COLUMN_PLAYER_NO, item.getPlayer_No());
        cv.put(COLUMN_FOUL_NAME, item.getFoul_name());
        cv.put(COLUMN_GOAL_TEAM_A,item.getGoal_a());
        cv.put(COLUMN_GOAL_TEAM_B,item.getGoal_b());
        cv.put(COLUMN_QUARTER, item.getQuarter());

        long insert = db.insert(SCORE, null, cv);

        return insert != -1;
    }

    public boolean deleteOne(Item item) {


        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + SCORE + " WHERE " + COLUMN_ID + " = " + item.getId();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            return true;
        }
        else {
            return false;
        }
    }




    public List<String> getEveryone() {
        List<String> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + SCORE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            do {
                String count_timer = cursor.getString(1);
                String player_No = cursor.getString(2);
                String foul_name = cursor.getString(3);

                if (null == player_No  ){
                    String newItem = count_timer + " " + foul_name;
                    returnList.add(newItem);
                }else {

                    String newItem = count_timer + " " + player_No + "番" +" "+ foul_name;
                    returnList.add(newItem);
                }


            } while (cursor.moveToNext());
        } else {

        }
        cursor.close();
        db.close();
        return returnList;
    }
}





