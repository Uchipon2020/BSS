package com.timeshappy.scoresheet;

import android.widget.Toast;

class Item {
    private int id;                 //通しID
    private String count_timer;     //現在のタイマー
    private long date;              //開催日
    private int player_No;       //プレイヤーナンバー
    private int teamA_foul;         //Aチームファール
    private int teamB_foul;         //Bチームファール
    private String team_A_name;     //Aチーム名
    private String team_B_name;     //Bチーム名
    private int goal_a;             //Aチームゴール
    private int goal_b;             //Bチームゴール
    private String foul_name;       //イベント名
    private int quarter;            //クオーター

    public static int numberT;

//コンテキスト
 public Item(int id, String count_timer, long date,
             int player_No,
             String team_A_name, String team_B_name,
             int teamA_foul,int teamB_foul,
             int goal_a, int goal_b,
             String foul_name,
             int quarter) {
        this.id = id;
        this.count_timer = count_timer;
        this.date = date;
        this.player_No = player_No;
        this.teamA_foul = teamA_foul;
        this.teamB_foul = teamB_foul;
        this.team_A_name = team_A_name;
        this.team_B_name = team_B_name;
        this.goal_a = goal_a;
        this.goal_b = goal_b;
        this.foul_name = foul_name;
        this.quarter= quarter;
    }

//getter setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
    }

    public long getDate() {
        return date;
    }
    public void setDate(long date) {
        this.date = date;
    }
    public int getPlayer_No(){
     return player_No;
    }
    public void setPlayer_No(int player_No){
     this.player_No = player_No;
    }

    public String getFoul_name() {
        return foul_name;
    }
    public void setFoul_name(String foul_name) {
        this.foul_name = foul_name;
    }

    public int getTeamA_foul() {
        return teamA_foul;
    }
    public void setTeamA_foul(int teamA_foul) {
        this.teamA_foul = teamA_foul;
    }

    public int getTeamB_foul() {
        return teamB_foul;
    }
    public void setTeamB_foul(int teamB_foul) {
        this.teamB_foul = teamB_foul;
    }

    public String getTeam_A_name() {
        return team_A_name;
    }
    public void setTeam_A_name(String team_A_name) {
        this.team_A_name = team_A_name;
    }

    public String getTeam_B_name() {
        return team_B_name;
    }
    public void setTeam_B_name(String team_B_name) {
        this.team_B_name = team_B_name;
    }

    public int getGoal_a() {
        return goal_a;
    }
    public void setGoal_a(int goal_a) {
        this.goal_a = goal_a;
    }

    public int getGoal_b() {
        return goal_b;
    }
    public void setGoal_b(int goal_b) {
        this.goal_b = goal_b;
    }

    public String getCount_timer() {
        return count_timer;
    }
    public void setCount_timer(String count_timer) {
        this.count_timer = count_timer;
    }
    public int getQuarter() {
        return quarter;
    }
    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }
}
