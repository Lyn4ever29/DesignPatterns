package cn.lyn4ever.v3.impl;

import cn.lyn4ever.v3.INotice;

public class AppNoticeImpl implements INotice {

    @Override
    public void notice() {
        System.out.println("进行app消息推送");
    }
}
