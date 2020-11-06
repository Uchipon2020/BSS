package com.timeshappy.scoresheet;
//make20201030_1
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

class DatabaseHelper  extends SQLiteOpenHelper {

    public static final String SCORE = "SCORE";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_COUNT_TIMER = "count_timer";
    public static final String COLUMN_PLAYER_NO = "player_No";
    public static final String COLUMN_FOUL_NAME = "foul_name";
    public static final String COLUMN_T_GOAL_A = "goal_a";
    public static final String COLUMN_T_GOAL_B = "goal_b";

    public DatabaseHelper(Context context) {
        super(context, "score_sheet.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_data = "CREATE TABLE "
                + SCORE
                + " ("
                + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_COUNT_TIMER + " TEXT,"
                + COLUMN_PLAYER_NO + " INTEGER,"
                + COLUMN_FOUL_NAME + " TEXT,"
                + COLUMN_T_GOAL_A + " TEXT,"
                + COLUMN_T_GOAL_B + " TEXT"
                + ")";

        db.execSQL(create_data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean addOne(Item item) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_COUNT_TIMER, item.getCount_timer());
        cv.put(COLUMN_PLAYER_NO, item.getNumber());
        cv.put(COLUMN_FOUL_NAME, item.getFoul_name());
        cv.put(COLUMN_T_GOAL_A,item.getGoal_a());
        cv.put(COLUMN_T_GOAL_B,item.getGoal_b());

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


    public List<Item> getEveryone() {

        List<Item> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + SCORE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int item_ID = cursor.getInt(0);
                String count_timer = cursor.getString(1);
                String player_No = cursor.getString(2);
                String foul_name = cursor.getString(3);
                String goal_a = cursor.getString(4);
                String goal_b = cursor.getString(5);

                int t_goal_a = Integer.valueOf(goal_a);
                int t_goal_b = Integer.valueOf(goal_b);
                int player = Integer.valueOf(player_No);

                Item newItem = new Item(item_ID,count_timer,0,player,0,0,0,null,null,t_goal_a,t_goal_b,foul_name);

                returnList.add(newItem);
            } while (cursor.moveToNext());
        } else {
        }
        cursor.close();
        db.close();
        return returnList;
    }
}





