package com.twu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
        ArrayList<HotSearch> specialArr = new ArrayList();
        ArrayList<HotSearch> showHotSearch = new ArrayList();
        specialArr.addAll((ArrayList)specialHotSearchArr.stream().filter(ele -> {
            for (HotSearch item : specialHotSearchArr) {
                if(item.getRanking() == ele.getRanking() && item.getSellPrice() > ele.getSellPrice()){
                    return false;
                }
            }
            return true;
        }).collect(Collectors.toList()));
        specialArr.sort(Comparator.comparing(HotSearch::getRanking));
        showHotSearch.addAll(hotSearchArr);
        specialArr.forEach(ele -> {
            showHotSearch.add(ele.getRanking()-1, ele);
        });
        for (int i = 0; i < showHotSearch.size(); i ++) {
            System.out.println( (i+1) +". "+ showHotSearch.get(i).toString());
        }
    }
    public void addHotSearch(String text) {
        HotSearch newHotSearch = new HotSearch(text);
        if(hotSearchArr.contains(newHotSearch)) {
            System.out.println("添加热搜事件失败，事件重复，请重新操作！");
            return;
        }
        hotSearchArr.add(newHotSearch);
    }
    public void addSuperHotSearch(String text) {
        HotSearch superHotSearch = new HotSearch(text);
        superHotSearch.setSuper(true);
        if(hotSearchArr.contains(superHotSearch)) {
            System.out.println("添加超级热搜事件失败，事件重复，请重新操作！");
            return;
        }
        hotSearchArr.add(superHotSearch);
    }
    public boolean voteForHotSearch(String hotSearchText, int quantity) {
        HotSearch target = hotSearchArr.stream().filter(ele -> ele.getText().equals(hotSearchText)).findFirst().orElse(null);
        if (target == null) {
            System.out.println("热搜不存在！");
            return false;
        }
        if(target.getIsSuper()) {
            target.setCount(target.getCount() + quantity * 2);
        } else {
            target.setCount(target.getCount() + quantity);
        }
        updateRankingList();
        System.out.println("投票成功！");
        return true;
    }
    public void buyHotSearch(String hotSearchName, int ranking, int price) {
        HotSearch target = hotSearchArr.stream().filter(ele -> ele.getText().equals(hotSearchName)).findFirst().orElse(null);
        hotSearchArr.remove(target);
        target.setRanking(ranking);
        target.setSellPrice(price);
        specialHotSearchArr.add(target);
        System.out.println("添加成功！");
    }
    private void updateRankingList() {
        hotSearchArr = (ArrayList)hotSearchArr.stream().sorted(Comparator.comparing(HotSearch::getCount).reversed()).collect(Collectors.toList());
    }
}
