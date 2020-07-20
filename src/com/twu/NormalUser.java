package com.twu;

public class NormalUser extends BaseUser {
    NormalUser(String name, String password) {
        super(name, password);
        this.menuInfo = "你好，"+ name +"，你可以： \n1. 查看热搜排行榜 \n2. 给热搜事件投票 \n3. 购买热搜 \n4. 添加热搜 \n5. 退出";
    }
    public void start() {
        String userType = getDataBySystemIn(menuInfo);
        switch (userType) {
            case "1" : this.showRankingList(); break;
//            case "2" : this.createManagerUser(); break;
//            case "2" : this.createManagerUser(); break;
            case "4" : this.addHotSearch(); break;
            default : Process.getInstance().start(); break;
        }
    }
    public void voteForHotSearch() {

    }
    public void addHotSearch() {
        String text = this.getDataBySystemIn("请输入要添加的热搜事件名称：");
        RankingList.getInstance().addHotSearch(text);
        this.start();
    }
    public void bugHotSearch() {

    }

}
