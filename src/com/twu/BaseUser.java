package com.twu;

import java.util.Scanner;

public class BaseUser {
    private String name;
    private String password;
    protected String menuInfo = "";
    protected Scanner reader;
    BaseUser(String name, String password) {
        this.name = name;
        this.password = password;
        reader = new Scanner(System.in);
    }
    public String getName() {
        return this.name;
    }
    public void start() {}
    protected void showRankingList() {
        RankingList.getInstance().showRankingList();
        this.start();
    }
    private void exit() {
        Process.getInstance().start();
    }
    protected String getDataBySystemIn(String title) {
        System.out.println(title);
        return reader.next();
    }
}
