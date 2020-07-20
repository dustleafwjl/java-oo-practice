package com.twu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RankingList {
    private static RankingList instance;
    private Scanner reader;
    private ArrayList<HotSearch> hotSearchArr;
    private ArrayList<HotSearch> specialHotSearchArr;
    RankingList() {
        reader = new Scanner(System.in);
        hotSearchArr = new ArrayList<HotSearch>();
        specialHotSearchArr = new ArrayList<HotSearch>();
    }
    public void init() {}
    static public RankingList getInstance() {
        if(instance == null) {
            instance = new RankingList();
        }
        return instance;
    }
    public void showRankingList() {
        AtomicInteger index = new AtomicInteger(0);
        specialHotSearchArr.stream().forEach(ele -> {
            System.out.println(index.incrementAndGet()+ ". "+ ele.toString());
        });
        hotSearchArr.stream().forEach(ele -> {
            System.out.println(index.incrementAndGet()+ ". "+ ele.toString());
        });
    }
    public void addHotSearch(String text) {
        hotSearchArr.add(new HotSearch(text));
    }
    public void voteForHotSearch(int index, int quantity) {
        HotSearch target = hotSearchArr.get(index - 1);
        target.setCount(target.getCount() + quantity);
    }
    public void buyHotSearch(int index) {
        specialHotSearchArr.add(hotSearchArr.subList(index, index).get(0));
        System.out.println("添加成功！");
    }
}
