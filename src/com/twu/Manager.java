package com.twu;

public class Manager extends BaseUser{
    private String startInfo = "欢迎来到热搜排行榜， 你是？ \n1. 用户 \n2. 管理员 \n3. 退出";
    Manager(String name, String password) {
        super(name, password);
        this.menuInfo = "你好，"+ name +"，你可以： \n1. 查看热搜排行榜 \n2. 添加热搜 \n3. 添加超级热搜. \n4. 退出";
    }
    public void start() {
        String userType = getDataBySystemIn(menuInfo);
        switch (userType) {
            case "1" : this.showRankingList(); break;
            case "2" : this.addHotSearch(); break;
            case "3" : this.addSuperHotSearch(); break;
            default : Process.getInstance().start(); break;
        }
    }
    public void addSuperHotSearch() {
        String text = this.getDataBySystemIn("请输入要添加的超级热搜事件名称：");
        RankingList.getInstance().addSuperHotSearch(text);
        this.start();
    }
}
