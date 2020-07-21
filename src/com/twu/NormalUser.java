package com.twu;

public class NormalUser extends BaseUser {
    private int voteQuantity = 10;
    NormalUser(String name, String password) {
        super(name, password);
        this.menuInfo = "你好，"+ name +"，你可以： \n1. 查看热搜排行榜 \n2. 给热搜事件投票 \n3. 购买热搜 \n4. 添加热搜 \n5. 退出";
    }
    public void start() {
        String userType = getDataBySystemIn(menuInfo);
        switch (userType) {
            case "1" : this.showRankingList(); break;
            case "2" : this.voteForHotSearch(); break;
            case "3" : this.bugHotSearch(); break;
            case "4" : this.addHotSearch(); break;
            default : Process.getInstance().start(); break;
        }
    }
    public void voteForHotSearch() {
        if(voteQuantity == 0) {
            System.out.println("你已经没有投票数了，不能投票！");
            this.start();
            return;
        }
        String hotSearchName = this.getDataBySystemIn("请输入要投票的热搜事件名称：");
        int quantity = Integer.parseInt(this.getDataBySystemIn("请输入投票数量: （你现在有"+ voteQuantity +"票)"));
        while(quantity > voteQuantity) {
            quantity = Integer.parseInt(this.getDataBySystemIn("输入票数不能超过你所拥有的，请重新输入: （你现在有"+ voteQuantity +"票)"));
        }
        if(RankingList.getInstance().voteForHotSearch(hotSearchName, quantity)) {
            voteQuantity -= quantity;
        }
        this.start();
    }

    public void bugHotSearch() {
        String hotSearchName = this.getDataBySystemIn("请输入要购买的热搜事件名称：");
        int ranking = Integer.parseInt(this.getDataBySystemIn("请输入热搜排名:"));
        int price = Integer.parseInt(this.getDataBySystemIn("请输入你的拍卖金额:"));
        RankingList.getInstance().buyHotSearch(hotSearchName, ranking, price);
        this.start();
    }

}
