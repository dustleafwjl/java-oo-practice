package com.twu;

import java.util.Scanner;

public class Process {
    private BaseUser user;
    private Scanner reader;
    private RankingList rankingList;
    private static Process instance;
    static public Process getInstance() {
        if(instance == null) {
            instance = new Process();
        }
        return instance;
    }
    Process() {
        this.reader = new Scanner(System.in);
        this.rankingList = RankingList.getInstance();
    }

    public void start() {
        String userType = getDataBySystemIn(InfoConfig.INITUSERINFO);
        switch (userType) {
            case "1" : this.createNormalUser(); break;
            case "2" : this.createManagerUser(); break;
            default : start(); break;
        }
        startUser();
    }
    private void startUser() {
        user.start();
    }
    private void createNormalUser() {
        String username = getDataBySystemIn("请输入你的昵称:");
        user = new NormalUser(username, "");
    }
    private void createManagerUser() {
        String username = getDataBySystemIn("请输入你的昵称:");
        String password = getDataBySystemIn("请输入你的密码");
        user = new Manager(username, password);
    }
    private String getDataBySystemIn(String title) {
        System.out.println(title);
        return reader.next();
    }
}
