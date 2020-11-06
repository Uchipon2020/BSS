package com.timeshappy.scoresheet;
class Item {
    private int id;
    private String count_timer;
    private long date;
    private int number;
    private int foul;
    private int teamA_foul;
    private int teamB_foul;
    private String teama_name;
    private String teamb_name;
    private int goal_a;
    private int goal_b;
    private String foul_name;

    public static int numberT;


    public Item(int id, String count_timer, long date, int number, int foul, int teamA_foul, int teamB_foul, String teama_name, String teamb_name, int goal_a, int goal_b, String foul_name) {
        this.id = id;
        this.count_timer = count_timer;
        this.date = date;
        this.number = number;
        this.foul = foul;
        this.teamA_foul = teamA_foul;
        this.teamB_foul = teamB_foul;
        this.teama_name = teama_name;
        this.teamb_name = teamb_name;
        this.goal_a = goal_a;
        this.goal_b = goal_b;
        this.foul_name = foul_name;
    }

    //toStrings


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", 時間:" + count_timer + '\'' +
                ", 実施日:" + date +
                ", 番号：" + number + '\'' +
                ", ファール：" + foul +
                ", ﾁｰﾑﾌｧｰﾙA：" + teamA_foul +
                ", ﾁｰﾑﾌｧｰﾙB：" + teamB_foul +
                ", teama_name='" + teama_name + '\'' +
                ", teamb_name='" + teamb_name + '\'' +
                ", ｺﾞｰﾙA：" + goal_a +
                ", ｺﾞｰﾙB：" + goal_b +
                ", foul：" + foul_name + '\'' +
                '}';
    }

    //getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCount_timer() {
        return count_timer;
    }

    public void setCount_timer(String count_timer) {
        this.count_timer = count_timer;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFoul() {
        return foul;
    }

    public void setFoul(int foul) {
        this.foul = foul;
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

    public String getTeama_name() {
        return teama_name;
    }

    public void setTeama_name(String teama_name) {
        this.teama_name = teama_name;
    }

    public String getTeamb_name() {
        return teamb_name;
    }

    public void setTeamb_name(String teamb_name) {
        this.teamb_name = teamb_name;
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

    public String getFoul_name() {
        return foul_name;
    }

    public void setFoul_name(String foul_name) {
        this.foul_name = foul_name;
    }
}


