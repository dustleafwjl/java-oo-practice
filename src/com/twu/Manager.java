package com.twu;

public class Manager extends BaseUser{
    private String startInfo = "欢迎来到热搜排行榜， 你是？ \n1. 用户 \n2. 管理员 \n3. 退出";
    Manager(String name, String password) {
        super(name, password);
        this.menuInfo = "你好，"+ name +"，你可以： \n1. 查看热搜排行榜 \n2. 给热搜事件投票 \n3. 购买热搜 \n4. 添加热搜 \n5. 退出";
    }
    public void start() {
        String userType = getDataBySystemIn(menuInfo);
        switch (userType) {
//            case "1" : this.createNormalUser(); break;
//            case "2" : this.createManagerUser(); break;
            default : Process.getInstance().start(); break;
        }
    }
}
